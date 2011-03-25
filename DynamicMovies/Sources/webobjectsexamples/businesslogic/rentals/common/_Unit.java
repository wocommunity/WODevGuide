// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to Unit.java instead.
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
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

@SuppressWarnings("all")
public abstract class _Unit extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Unit";

	// Attributes
	public static final String DATE_ACQUIRED_KEY = "dateAcquired";
	public static final String NOTES_KEY = "notes";
	public static final String UNIT_ID_KEY = "unitID";

	// Relationships
	public static final String RENTALS_KEY = "rentals";
	public static final String VIDEO_KEY = "video";

  private static Logger LOG = Logger.getLogger(_Unit.class);

  public Unit localInstanceIn(EOEditingContext editingContext) {
    Unit localInstance = (Unit)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp dateAcquired() {
    return (NSTimestamp) storedValueForKey("dateAcquired");
  }

  public void setDateAcquired(NSTimestamp value) {
    if (_Unit.LOG.isDebugEnabled()) {
    	_Unit.LOG.debug( "updating dateAcquired from " + dateAcquired() + " to " + value);
    }
    takeStoredValueForKey(value, "dateAcquired");
  }

  public String notes() {
    return (String) storedValueForKey("notes");
  }

  public void setNotes(String value) {
    if (_Unit.LOG.isDebugEnabled()) {
    	_Unit.LOG.debug( "updating notes from " + notes() + " to " + value);
    }
    takeStoredValueForKey(value, "notes");
  }

  public Integer unitID() {
    return (Integer) storedValueForKey("unitID");
  }

  public void setUnitID(Integer value) {
    if (_Unit.LOG.isDebugEnabled()) {
    	_Unit.LOG.debug( "updating unitID from " + unitID() + " to " + value);
    }
    takeStoredValueForKey(value, "unitID");
  }

  public webobjectsexamples.businesslogic.rentals.common.Video video() {
    return (webobjectsexamples.businesslogic.rentals.common.Video)storedValueForKey("video");
  }

  public void setVideoRelationship(webobjectsexamples.businesslogic.rentals.common.Video value) {
    if (_Unit.LOG.isDebugEnabled()) {
      _Unit.LOG.debug("updating video from " + video() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.rentals.common.Video oldValue = video();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "video");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "video");
    }
  }
  
  public NSArray<webobjectsexamples.businesslogic.rentals.common.Rental> rentals() {
    return (NSArray<webobjectsexamples.businesslogic.rentals.common.Rental>)storedValueForKey("rentals");
  }

  public NSArray<webobjectsexamples.businesslogic.rentals.common.Rental> rentals(EOQualifier qualifier) {
    return rentals(qualifier, null, false);
  }

  public NSArray<webobjectsexamples.businesslogic.rentals.common.Rental> rentals(EOQualifier qualifier, boolean fetch) {
    return rentals(qualifier, null, fetch);
  }

  public NSArray<webobjectsexamples.businesslogic.rentals.common.Rental> rentals(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<webobjectsexamples.businesslogic.rentals.common.Rental> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(webobjectsexamples.businesslogic.rentals.common.Rental.UNIT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = webobjectsexamples.businesslogic.rentals.common.Rental.fetchRentals(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = rentals();
      if (qualifier != null) {
        results = (NSArray<webobjectsexamples.businesslogic.rentals.common.Rental>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<webobjectsexamples.businesslogic.rentals.common.Rental>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToRentalsRelationship(webobjectsexamples.businesslogic.rentals.common.Rental object) {
    if (_Unit.LOG.isDebugEnabled()) {
      _Unit.LOG.debug("adding " + object + " to rentals relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "rentals");
  }

  public void removeFromRentalsRelationship(webobjectsexamples.businesslogic.rentals.common.Rental object) {
    if (_Unit.LOG.isDebugEnabled()) {
      _Unit.LOG.debug("removing " + object + " from rentals relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "rentals");
  }

  public webobjectsexamples.businesslogic.rentals.common.Rental createRentalsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Rental");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "rentals");
    return (webobjectsexamples.businesslogic.rentals.common.Rental) eo;
  }

  public void deleteRentalsRelationship(webobjectsexamples.businesslogic.rentals.common.Rental object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "rentals");
    editingContext().deleteObject(object);
  }

  public void deleteAllRentalsRelationships() {
    Enumeration objects = rentals().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRentalsRelationship((webobjectsexamples.businesslogic.rentals.common.Rental)objects.nextElement());
    }
  }


  public static Unit createUnit(EOEditingContext editingContext, NSTimestamp dateAcquired
, Integer unitID
, webobjectsexamples.businesslogic.rentals.common.Video video) {
    Unit eo = (Unit) EOUtilities.createAndInsertInstance(editingContext, _Unit.ENTITY_NAME);    
		eo.setDateAcquired(dateAcquired);
		eo.setUnitID(unitID);
    eo.setVideoRelationship(video);
    return eo;
  }

  public static NSArray<Unit> fetchAllUnits(EOEditingContext editingContext) {
    return _Unit.fetchAllUnits(editingContext, null);
  }

  public static NSArray<Unit> fetchAllUnits(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Unit.fetchUnits(editingContext, null, sortOrderings);
  }

  public static NSArray<Unit> fetchUnits(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Unit.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Unit> eoObjects = (NSArray<Unit>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Unit fetchUnit(EOEditingContext editingContext, String keyName, Object value) {
    return _Unit.fetchUnit(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Unit fetchUnit(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Unit> eoObjects = _Unit.fetchUnits(editingContext, qualifier, null);
    Unit eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Unit)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Unit that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Unit fetchRequiredUnit(EOEditingContext editingContext, String keyName, Object value) {
    return _Unit.fetchRequiredUnit(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Unit fetchRequiredUnit(EOEditingContext editingContext, EOQualifier qualifier) {
    Unit eoObject = _Unit.fetchUnit(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Unit that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Unit localInstanceIn(EOEditingContext editingContext, Unit eo) {
    Unit localInstance = (eo == null) ? null : (Unit)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<webobjectsexamples.businesslogic.rentals.common.Unit> fetchPrefetchVideoMovie(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("prefetchVideoMovie", "Unit");
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<webobjectsexamples.businesslogic.rentals.common.Unit>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<webobjectsexamples.businesslogic.rentals.common.Unit> fetchPrefetchVideoMovie(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("prefetchVideoMovie", "Unit");
    return (NSArray<webobjectsexamples.businesslogic.rentals.common.Unit>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
