// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to Video.java instead.
package webobjectsexamples.businesslogic.rentals.common;

import java.util.Enumeration;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

@SuppressWarnings("all")
public abstract class _Video extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Video";

	// Attributes

	// Relationships
	public static final String MOVIE_KEY = "movie";
	public static final String RENTAL_TERMS_KEY = "rentalTerms";
	public static final String UNITS_KEY = "units";

  private static Logger LOG = Logger.getLogger(_Video.class);

  public Video localInstanceIn(EOEditingContext editingContext) {
    Video localInstance = (Video)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public EOGenericRecord movie() {
    return (EOGenericRecord)storedValueForKey("movie");
  }

  public void setMovieRelationship(EOGenericRecord value) {
    if (_Video.LOG.isDebugEnabled()) {
      _Video.LOG.debug("updating movie from " + movie() + " to " + value);
    }
    if (value == null) {
    	EOGenericRecord oldValue = movie();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "movie");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "movie");
    }
  }
  
  public webobjectsexamples.businesslogic.rentals.common.RentalTerms rentalTerms() {
    return (webobjectsexamples.businesslogic.rentals.common.RentalTerms)storedValueForKey("rentalTerms");
  }

  public void setRentalTermsRelationship(webobjectsexamples.businesslogic.rentals.common.RentalTerms value) {
    if (_Video.LOG.isDebugEnabled()) {
      _Video.LOG.debug("updating rentalTerms from " + rentalTerms() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.rentals.common.RentalTerms oldValue = rentalTerms();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "rentalTerms");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "rentalTerms");
    }
  }
  
  public NSArray<webobjectsexamples.businesslogic.rentals.common.Unit> units() {
    return (NSArray<webobjectsexamples.businesslogic.rentals.common.Unit>)storedValueForKey("units");
  }

  public NSArray<webobjectsexamples.businesslogic.rentals.common.Unit> units(EOQualifier qualifier) {
    return units(qualifier, null, false);
  }

  public NSArray<webobjectsexamples.businesslogic.rentals.common.Unit> units(EOQualifier qualifier, boolean fetch) {
    return units(qualifier, null, fetch);
  }

  public NSArray<webobjectsexamples.businesslogic.rentals.common.Unit> units(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<webobjectsexamples.businesslogic.rentals.common.Unit> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(webobjectsexamples.businesslogic.rentals.common.Unit.VIDEO_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = webobjectsexamples.businesslogic.rentals.common.Unit.fetchUnits(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = units();
      if (qualifier != null) {
        results = (NSArray<webobjectsexamples.businesslogic.rentals.common.Unit>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<webobjectsexamples.businesslogic.rentals.common.Unit>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToUnitsRelationship(webobjectsexamples.businesslogic.rentals.common.Unit object) {
    if (_Video.LOG.isDebugEnabled()) {
      _Video.LOG.debug("adding " + object + " to units relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "units");
  }

  public void removeFromUnitsRelationship(webobjectsexamples.businesslogic.rentals.common.Unit object) {
    if (_Video.LOG.isDebugEnabled()) {
      _Video.LOG.debug("removing " + object + " from units relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "units");
  }

  public webobjectsexamples.businesslogic.rentals.common.Unit createUnitsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Unit");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "units");
    return (webobjectsexamples.businesslogic.rentals.common.Unit) eo;
  }

  public void deleteUnitsRelationship(webobjectsexamples.businesslogic.rentals.common.Unit object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "units");
    editingContext().deleteObject(object);
  }

  public void deleteAllUnitsRelationships() {
    Enumeration objects = units().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteUnitsRelationship((webobjectsexamples.businesslogic.rentals.common.Unit)objects.nextElement());
    }
  }


  public static Video createVideo(EOEditingContext editingContext, EOGenericRecord movie, webobjectsexamples.businesslogic.rentals.common.RentalTerms rentalTerms) {
    Video eo = (Video) EOUtilities.createAndInsertInstance(editingContext, _Video.ENTITY_NAME);    
    eo.setMovieRelationship(movie);
    eo.setRentalTermsRelationship(rentalTerms);
    return eo;
  }

  public static NSArray<Video> fetchAllVideos(EOEditingContext editingContext) {
    return _Video.fetchAllVideos(editingContext, null);
  }

  public static NSArray<Video> fetchAllVideos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Video.fetchVideos(editingContext, null, sortOrderings);
  }

  public static NSArray<Video> fetchVideos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Video.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Video> eoObjects = (NSArray<Video>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Video fetchVideo(EOEditingContext editingContext, String keyName, Object value) {
    return _Video.fetchVideo(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Video fetchVideo(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Video> eoObjects = _Video.fetchVideos(editingContext, qualifier, null);
    Video eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Video)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Video that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Video fetchRequiredVideo(EOEditingContext editingContext, String keyName, Object value) {
    return _Video.fetchRequiredVideo(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Video fetchRequiredVideo(EOEditingContext editingContext, EOQualifier qualifier) {
    Video eoObject = _Video.fetchVideo(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Video that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Video localInstanceIn(EOEditingContext editingContext, Video eo) {
    Video localInstance = (eo == null) ? null : (Video)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
