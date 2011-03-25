// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to Rental.java instead.
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
import com.webobjects.foundation.NSTimestamp;

@SuppressWarnings("all")
public abstract class _Rental extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Rental";

	// Attributes
	public static final String DATE_OUT_KEY = "dateOut";
	public static final String DATE_RETURNED_KEY = "dateReturned";

	// Relationships
	public static final String CUSTOMER_KEY = "customer";
	public static final String FEES_KEY = "fees";
	public static final String UNIT_KEY = "unit";

  private static Logger LOG = Logger.getLogger(_Rental.class);

  public Rental localInstanceIn(EOEditingContext editingContext) {
    Rental localInstance = (Rental)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp dateOut() {
    return (NSTimestamp) storedValueForKey("dateOut");
  }

  public void setDateOut(NSTimestamp value) {
    if (_Rental.LOG.isDebugEnabled()) {
    	_Rental.LOG.debug( "updating dateOut from " + dateOut() + " to " + value);
    }
    takeStoredValueForKey(value, "dateOut");
  }

  public NSTimestamp dateReturned() {
    return (NSTimestamp) storedValueForKey("dateReturned");
  }

  public void setDateReturned(NSTimestamp value) {
    if (_Rental.LOG.isDebugEnabled()) {
    	_Rental.LOG.debug( "updating dateReturned from " + dateReturned() + " to " + value);
    }
    takeStoredValueForKey(value, "dateReturned");
  }

  public webobjectsexamples.businesslogic.rentals.common.Customer customer() {
    return (webobjectsexamples.businesslogic.rentals.common.Customer)storedValueForKey("customer");
  }

  public void setCustomerRelationship(webobjectsexamples.businesslogic.rentals.common.Customer value) {
    if (_Rental.LOG.isDebugEnabled()) {
      _Rental.LOG.debug("updating customer from " + customer() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.rentals.common.Customer oldValue = customer();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "customer");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "customer");
    }
  }
  
  public webobjectsexamples.businesslogic.rentals.common.Unit unit() {
    return (webobjectsexamples.businesslogic.rentals.common.Unit)storedValueForKey("unit");
  }

  public void setUnitRelationship(webobjectsexamples.businesslogic.rentals.common.Unit value) {
    if (_Rental.LOG.isDebugEnabled()) {
      _Rental.LOG.debug("updating unit from " + unit() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.rentals.common.Unit oldValue = unit();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "unit");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "unit");
    }
  }
  
  public NSArray<webobjectsexamples.businesslogic.rentals.common.Fee> fees() {
    return (NSArray<webobjectsexamples.businesslogic.rentals.common.Fee>)storedValueForKey("fees");
  }

  public NSArray<webobjectsexamples.businesslogic.rentals.common.Fee> fees(EOQualifier qualifier) {
    return fees(qualifier, null, false);
  }

  public NSArray<webobjectsexamples.businesslogic.rentals.common.Fee> fees(EOQualifier qualifier, boolean fetch) {
    return fees(qualifier, null, fetch);
  }

  public NSArray<webobjectsexamples.businesslogic.rentals.common.Fee> fees(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<webobjectsexamples.businesslogic.rentals.common.Fee> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(webobjectsexamples.businesslogic.rentals.common.Fee.RENTAL_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = webobjectsexamples.businesslogic.rentals.common.Fee.fetchFees(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = fees();
      if (qualifier != null) {
        results = (NSArray<webobjectsexamples.businesslogic.rentals.common.Fee>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<webobjectsexamples.businesslogic.rentals.common.Fee>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToFeesRelationship(webobjectsexamples.businesslogic.rentals.common.Fee object) {
    if (_Rental.LOG.isDebugEnabled()) {
      _Rental.LOG.debug("adding " + object + " to fees relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "fees");
  }

  public void removeFromFeesRelationship(webobjectsexamples.businesslogic.rentals.common.Fee object) {
    if (_Rental.LOG.isDebugEnabled()) {
      _Rental.LOG.debug("removing " + object + " from fees relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "fees");
  }

  public webobjectsexamples.businesslogic.rentals.common.Fee createFeesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Fee");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "fees");
    return (webobjectsexamples.businesslogic.rentals.common.Fee) eo;
  }

  public void deleteFeesRelationship(webobjectsexamples.businesslogic.rentals.common.Fee object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "fees");
  }

  public void deleteAllFeesRelationships() {
    Enumeration objects = fees().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteFeesRelationship((webobjectsexamples.businesslogic.rentals.common.Fee)objects.nextElement());
    }
  }


  public static Rental createRental(EOEditingContext editingContext, NSTimestamp dateOut
, webobjectsexamples.businesslogic.rentals.common.Customer customer, webobjectsexamples.businesslogic.rentals.common.Unit unit) {
    Rental eo = (Rental) EOUtilities.createAndInsertInstance(editingContext, _Rental.ENTITY_NAME);    
		eo.setDateOut(dateOut);
    eo.setCustomerRelationship(customer);
    eo.setUnitRelationship(unit);
    return eo;
  }

  public static NSArray<Rental> fetchAllRentals(EOEditingContext editingContext) {
    return _Rental.fetchAllRentals(editingContext, null);
  }

  public static NSArray<Rental> fetchAllRentals(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Rental.fetchRentals(editingContext, null, sortOrderings);
  }

  public static NSArray<Rental> fetchRentals(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Rental.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Rental> eoObjects = (NSArray<Rental>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Rental fetchRental(EOEditingContext editingContext, String keyName, Object value) {
    return _Rental.fetchRental(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Rental fetchRental(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Rental> eoObjects = _Rental.fetchRentals(editingContext, qualifier, null);
    Rental eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Rental)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Rental that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Rental fetchRequiredRental(EOEditingContext editingContext, String keyName, Object value) {
    return _Rental.fetchRequiredRental(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Rental fetchRequiredRental(EOEditingContext editingContext, EOQualifier qualifier) {
    Rental eoObject = _Rental.fetchRental(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Rental that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Rental localInstanceIn(EOEditingContext editingContext, Rental eo) {
    Rental localInstance = (eo == null) ? null : (Rental)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
