/*
 Application.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EODatabaseDataSource;
import com.webobjects.eoaccess.EOEntity;
import com.webobjects.eoaccess.EOModelGroup;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSPropertyListSerialization;
import com.webobjects.foundation._NSUtilities;


/*
 This is the Application class for the ThinkMovies example.  The Application
 class is being used here for maintaining a list of information the application
 will use;  since this application is based on DirectActions (thus never creating
 a session) there is a good deal of information stored here.
 */
 
public class Application extends WOApplication {
    protected NSDictionary imageMap;

    // Instance variables for the comparison operators for searching
    public static final NSArray dateOperators = new NSArray( new Object[] { "is","before","after" } );
    public static final NSArray textOperators = new NSArray( new Object[] { "starts with","ends with","contains", "is" });

    // Private instance variables for the editing context and datasource
    private EOEditingContext editingContext;
    private EODatabaseDataSource movieDataSource;

    // Private instance variable for cached image data
    private NSData pictureNotFoundImage;

    // Private instance variable listing the primary key attributes of entities
    private static final NSDictionary pkAttributeForEntityName = new NSDictionary(new Object[] {"movieID", "studioID", "reviewID"}, new Object[] {"Movie", "Studio", "Review"});
    
    // Private instance variables for specific entities
    private static NSMutableDictionary entityForEntityNameCache;
    private static EOEntity movieEntity;
    private static EOEntity studioEntity;
    private static EOEntity reviewEntity;

    // Private instance variables used for fetching
    private static final String studioEntityFetchSpecName = "RawFetchAllStudios";
    private static final String DeepFetchOneMovieFetchSpecName = "DeepFetchOneMovie";
    private static final String RawFetchAllMoviesFetchSpecName = "RawFetchAllMovies";
    private static EOFetchSpecification studioEntityFetchSpec;
    private static EOFetchSpecification DeepFetchOneMovieFetchSpec;
    private static EOFetchSpecification RawFetchAllMoviesFetchSpec;
   
   
    /**
     * Main run loop for the application
     */
     
    public static void main( String argv[] ) {
        WOApplication.main( argv, Application.class );
    }


    /**
     * Application constructor.  This method starts and "warms up" the application
     * by creating a new editing context and fetching a single entity from each of the
     * Movie, Studio, and Review tables;  the method then performs deep fetches (via
     * fetchSpecifications in the EOModel) to prefetch the entities.  This method also
     * sets the default request handler to the directAction handler.  By using the 
     * directAction handler, the default page returned when a session starts is defined 
     * in the defaultAction() method in the DirectAction class.
     */

    public Application() {
    
        super();
	
        editingContext = new EOEditingContext();

        movieEntity = EOUtilities.entityNamed(editingContext, "Movie");
        studioEntity = EOUtilities.entityNamed(editingContext, "Studio");
        reviewEntity = EOUtilities.entityNamed(editingContext, "Review");
        entityForEntityNameCache = new NSMutableDictionary
	    ( new Object[] {movieEntity, studioEntity, reviewEntity}, 
	      new Object[] {"Movie", "Studio", "Review"});
	      
        EOModelGroup modelGroup = EOUtilities.modelGroup(editingContext);
        DeepFetchOneMovieFetchSpec = modelGroup.fetchSpecificationNamed(DeepFetchOneMovieFetchSpecName, "Movie");
        RawFetchAllMoviesFetchSpec = modelGroup.fetchSpecificationNamed(RawFetchAllMoviesFetchSpecName, "Movie");
        studioEntityFetchSpec = modelGroup.fetchSpecificationNamed(studioEntityFetchSpecName, "Studio");

        movieDataSource = new EODatabaseDataSource(editingContext, "Movie", RawFetchAllMoviesFetchSpecName);
        
	setDefaultRequestHandler(requestHandlerForKey(directActionRequestHandlerKey()));
        
        NSLog.out.appendln("Welcome to " + name() + "!\n --------------------");
    }


    /**
     * Static method to return this application instance
     */
     
    public static Application myApplication() {
        return (Application)Application.application();
    }

    
    /**
     * Method to lock and return the editing context for the application.  This allows
     * the application to lock the context down while operations are in process.
     */
     
    public EOEditingContext lockEC() {
        editingContext.lock();
        return editingContext;
    }


    /**
     * Method to unlock the editing context for the application.  This allows
     * the application to allow other operations to proceed with using the context
     * after a lock has been used
     */
     
    public void unlockEC() {
        editingContext.unlock();
    }
    
        public NSDictionary imageMap() {
	if (imageMap == null) {	
	    InputStream inputStream = resourceManager().inputStreamForResourceNamed("ImageMap.plist", null, null);

	    // create the data, log exceptions
	    try { 
		NSData mapData = new NSData(inputStream, inputStream.available()); 
		imageMap = (NSDictionary) NSPropertyListSerialization.propertyListFromData(mapData);
	    } catch (Exception exception) {
		logString("Application:  failed to read in image map");
	    }
	} return imageMap;
    }    

    /**
     * Method to return an array of Studio objects.  This method locks the editing context
     * and attempts to use a fetch spec to obtain all of the objects.
     */
    
    public NSArray studioList() {
        NSArray results;
        try {
            EOEditingContext anEC = lockEC();
            results = anEC.objectsWithFetchSpecification(studioEntityFetchSpec);
        } finally {
            unlockEC();
        }
        return results;
    }


    /**
     * Convenience method to return the primary key attribute name for a particular
     * entity.  This method attempts to get the information from the dictionary 
     * initialized at runtime;  if no information is available for the entity, the
     * first attribute in the array of primary key attribute names for the entity
     * is used.  Note that this method will only succeed for entities with a single
     * primary key.
     *
     * @param entity		the EOEntity to get the pkey attribute name for
     * @return			the primary key attribute name
     */
     
    public String primaryKeyAttributeName( EOEntity entity ) {
        Object result = pkAttributeForEntityName.objectForKey( entity.name() );
        if (result != null) {
            return (String)result;
        }
        return (String)entity.primaryKeyAttributeNames().objectAtIndex( 0 );
    }
    
    
    /**
     * Method to return the primary key for an Enterprise Object.  This method
     * locks the editing context and gets the global ID for the passed in object.
     * Once it has the global ID, you can use the EOEntity for the object to
     * obtain the primary key dictionary (using the global ID).  From the dictionary
     * we can fetch the value by using key-value coding with the primary key
     * attribute name.
     *
     * @param eo		Object to fetch the primary key for
     * @return			the corresponding Object for the pkey
     */
     
    public Object primaryKeyForObject( EOEnterpriseObject eo ) {
        NSDictionary result = null;
        String pkName;
        EOEntity entity;

        try {
            EOEditingContext ec = lockEC();
            EOGlobalID globalID = ec.globalIDForObject( eo );
            if (globalID == null) {
                return null;
            }
            entity = entityForEntityName( eo.entityName() );
            result = entity.primaryKeyForGlobalID( globalID );
        } finally {
            unlockEC();
        }
        
        if ( result == null ) {
            return null;
        }
        pkName = primaryKeyAttributeName( entity );
        if ( pkName == null ) {
            return null;
        }
        return result.valueForKey( pkName );
    }
        
	
    /**
     * Convenience method to return an EOEntity for an entity name.  This
     * method first checks the dictionary of cached information (intialized at
     * runtime) to get the information;  if there is no corresponding info,
     * the method uses the EOUtilities entityNamed()... method.
     *
     * @param entityName	name of the entity
     * @return			the corresponding EOEntity
     */
     
    public EOEntity entityForEntityName( String entityName ) {
        EOEntity entity = (EOEntity)entityForEntityNameCache.objectForKey( entityName );
        if ( entity == null ) {
            try {
                EOEditingContext anEC = lockEC();
                entity = EOUtilities.entityNamed( anEC, entityName );
            } finally {
                unlockEC();
            }
        }
        return entity;
    }


    /**
     * Method to return an Enterprise Object by using the entity name and the 
     * ID number for the object.  This method first obtains the primary key
     * attribute for the corresponding entity, then uses the global ID and
     * other information to get the fault for the object.  If no fault is 
     * found, the information is pulled using the EOUtilities convenience
     * method objectWithPrimaryKeyValue()...
     *
     * @param entityName	name of the EOEntity
     * @param id		primary key for the entity
     * @return			the corresponding Enterprise Object
     */
     
    public EOEnterpriseObject lookupByID( String entityName, Number id ) {
    
        if (id.intValue() == 0) {
            return null;
        }

        EOEnterpriseObject result = null;
        NSDictionary pk;
        Object pkAttributeName = pkAttributeForEntityName.objectForKey( entityName );
        try {
            EOEditingContext anEC = lockEC();
            if (pkAttributeName != null) {
                pk = new NSDictionary( id, pkAttributeName );
                EOEntity entity = entityForEntityName( entityName );
                if ( entity != null ) {
                    EOGlobalID globalID = entity.globalIDForRow( pk );
                    result = anEC.faultForGlobalID( globalID, anEC );
                }
            }
            if ( result == null ) {
                result = EOUtilities.objectWithPrimaryKeyValue( anEC, entityName, id );
            }
        } finally {
            unlockEC();
        }
        return result;
    }


    /**
     * Method to return a deep fetch of a Movie object in an editing context. This
     * method uses the "deepFetchOneMovieFetchSpec" to get the results, and then
     * return the first object in the resulting array.
     *
     * @param movieID		ID for a particular movie
     * @param ec		editing context for the fetch
     * @return			a deep-fetched Enterprise Object
     */
     
    public EOEnterpriseObject deepFetchMovie( Object movieID, EOEditingContext ec ) {
    
        NSDictionary bindings = new NSDictionary( new Object[]{ movieID }, new Object[]{ "myMovie" } );
        EOFetchSpecification boundFetchSpec = 
	    Application.DeepFetchOneMovieFetchSpec.fetchSpecificationWithQualifierBindings( bindings );

        // run the fetch spec
        NSArray results = ec.objectsWithFetchSpecification( boundFetchSpec );
        return (EOEnterpriseObject) results.objectAtIndex( 0 );
    }


    /**
     * Cover method to return the EODatabaseDatasource in the Application class.
     */
     
    public EODatabaseDataSource movieDataSource() {
        return movieDataSource;
    }


    /**
     * Method to return the local cached image data for the "PictureNotFound.gif" image.
     * This image is used in place of any empty image data which comes back from the
     * database.  First the local instance variable is checked, and if it is null the
     * method gets the NSData from the Java file reference.
     */
     
    public NSData pictureNotFoundImage() {
    
        if ( pictureNotFoundImage == null ) {
            synchronized ( this ) {
	    
                if ( pictureNotFoundImage == null ) {
                    try {
		    
                        String aFilePath = resourceManager().pathForResourceNamed( "PictureNotFound.gif", 
										   null, 
										   null );
                        File file = new File( aFilePath );
                        pictureNotFoundImage = new NSData(new FileInputStream(file), (int)file.length());
			
                    } catch ( Exception exception ) {
		    
                        NSLog.err.appendln( "PictureNotFound.gif resource is missing from the project" );
                        if (NSLog.debugLoggingAllowedForLevel(NSLog.DebugLevelDetailed)) {
                            NSLog.debug.appendln(exception);
                        }
                    }
                }
            }
        }
        return pictureNotFoundImage;
    }
    
	public WOResponse dispatchRequest(WORequest request) {
		request.setContentEncoding(_NSUtilities.UTF8StringEncoding);
		request.setHeader("text/html; charset=UTF-8; encoding=UTF-8", "content-type");
		return super.dispatchRequest(request);
	}
}
