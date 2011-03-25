/*
 DisplayVideoPage.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */

import webobjectsexamples.businesslogic.movies.common.MovieRole;
import webobjectsexamples.businesslogic.movies.common.Talent;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;


/*
 This class and the associated component create a page to display the
 information for a particular Movie.  This page shows the details for a
 Movie, the list of actors/Roles for the Movie, and the Director for 
 the Movie. 
 */
 
public class DisplayVideoPage extends MovieComponent {

    // Instance variable for the full list of movies
    protected NSMutableArray list;
    
    // Instance variable for the query dictionary
    protected NSMutableDictionary queryDict;
    
    // Instance variable for a Role in the movie
    protected MovieRole aRole;
    
    // Instance variable for the Director of the movie
    protected Talent aDirector;


    /**
     * Constructor
     */
     
    public DisplayVideoPage( WOContext context ) {
        super( context );
    }

    
    /**
     * Method to return the index of the Movie ID in the full list
     */
     
    private int movieIndex() {
        return indexOfMovieID( list, movieID() );
    }
    
    
    /**
     * Method to get the summary information for a particular Movie.  This method
     * gets the information from the "plotSummary" attribute of the Movie (which
     * is the Summary EO) and then gets the "summary" attribute from it.
     */
     
    public String summaryString() {
        EOGenericRecord plotSummary = (EOGenericRecord) movie.valueForKey( "plotSummary" );
        return (String) plotSummary.valueForKey( "summary" );
    }


    /**
     * Method to return the ID number for the previous movie in the list.  This ID
     * number is used on a hyperlink to show the details for the previous movie.
     */
     
    public Number previousMovieID() {
        int aPreviousMovieIndex = movieIndex() - 1;
        if ((aPreviousMovieIndex >= 0) && (aPreviousMovieIndex < list.count())) {
            NSKeyValueCoding aPreviousMovie = (NSKeyValueCoding) list.objectAtIndex(aPreviousMovieIndex);
            return (Number) aPreviousMovie.valueForKey("movieID");
        }
        return movieID();
    }


    /**
     * Method to return the ID number for the next movie in the list.  This ID
     * number is used on a hyperlink to show the details for the next movie.
     */
     
    public Number nextMovieID() {
        int aNextMovieIndex = movieIndex() + 1;
        if ((aNextMovieIndex >= 0) && (aNextMovieIndex < list.count())) {
            NSKeyValueCoding aNextMovie = (NSKeyValueCoding) list.objectAtIndex(aNextMovieIndex);
            return (Number) aNextMovie.valueForKey("movieID");
        }
        return movieID();
    }


    /**
     * Method to compute the number of roles in the movie, and then add one.  This number
     * is used as the COLSPAN attribute for the generic table element to display the
     * information.
     */
     
    public int computedRolesRowspan() {
        NSArray roles = (NSArray) movie.valueForKey("roles");
        return roles.count() + 1;
    }


    /**
     * Method to return the image for a specific Talent EO.  This component displays
     * the list of roles in the Movie, and then shows the Talent performing the role.
     * This method fetches the image data for the Talent EO (which could be null).
     */
     
    private NSData talentPhotoForTalent(EOEnterpriseObject talent) {
        EOEnterpriseObject aTalentPhoto = (EOEnterpriseObject)talent.valueForKey("photo");
        NSData aPhoto = null;
        if (aTalentPhoto != null) {
            aPhoto = (NSData)aTalentPhoto.valueForKey("photo");
            if (aPhoto != null && aPhoto.length() == 0) {
                aPhoto = null;
            }
        }
        return aPhoto;
    }
    
    
    /**
     * Method to return the image data for a particular Talent, OR to use the
     * default image ("PictureNotFound") if no image data is available.  The image
     * data used for unavailable pictures is cached in the Application class.
     */
     
    public NSData actorImageData() {
        EOEnterpriseObject aTalent = (EOEnterpriseObject)aRole.valueForKey("talent");
        NSData aPhoto = talentPhotoForTalent(aTalent);
        if (aPhoto == null) {
            aPhoto = ((Application)application()).pictureNotFoundImage();
        }
        return aPhoto;
    }


    /**
     * Method to generate the URL to the RentalStore application - this method will create
     * a link to the RentalStore and allow the user to jump to the page to add the selected
     * Movie to a shopping basket (if the application is running).  This method will NOT
     * work correctly if the application is running in DirectConnect mode:  you must go
     * through the adaptor.
     */
     
    public String rentalStoreURL() {
        WORequest r = context().request();
        return r.adaptorPrefix() + "/RentalStore.woa/wa/AddMovieToShoppingBasket";
    }


    /**
     * Method to return the caching key for the image for a particular Talent.
     * This key is by the browser to cache the data for the image to allow for
     * the use of the cached version the next time it is displayed.  For images
     * with image data, the global ID for the Talent EO is used;  otherwise
     * the "PictureNotFoundImage" key is used.
     */

    public String talentPhotoCachingKey() {
    
        EOEnterpriseObject anEO = (EOEnterpriseObject) aRole.valueForKey("talent");
        NSData aPhoto = talentPhotoForTalent(anEO);
        if ( aPhoto == null ) {
            return "PictureNotFoundImage";
        }
	
        EOEditingContext anEditingContext = anEO.editingContext();
        EOGlobalID aGlobalID;
        anEditingContext.lock();
        aGlobalID = anEditingContext.globalIDForObject(anEO);
        anEditingContext.unlock();
        return aGlobalID.toString();
    }

}
