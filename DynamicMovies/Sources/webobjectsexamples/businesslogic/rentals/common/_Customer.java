// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to Customer.java instead.
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
public abstract class _Customer extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Customer";

	// Attributes
	public static final String CITY_KEY = "city";
	public static final String FIRST_NAME_KEY = "firstName";
	public static final String LAST_NAME_KEY = "lastName";
	public static final String MEMBER_SINCE_KEY = "memberSince";
	public static final String PHONE_KEY = "phone";
	public static final String STATE_KEY = "state";
	public static final String STREET_ADDRESS_KEY = "streetAddress";
	public static final String ZIP_KEY = "zip";

	// Relationships
	public static final String CREDIT_CARD_KEY = "creditCard";
	public static final String RENTALS_KEY = "rentals";

  private static Logger LOG = Logger.getLogger(_Customer.class);

  public Customer localInstanceIn(EOEditingContext editingContext) {
    Customer localInstance = (Customer)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String city() {
    return (String) storedValueForKey("city");
  }

  public void setCity(String value) {
    if (_Customer.LOG.isDebugEnabled()) {
    	_Customer.LOG.debug( "updating city from " + city() + " to " + value);
    }
    takeStoredValueForKey(value, "city");
  }

  public String firstName() {
    return (String) storedValueForKey("firstName");
  }

  public void setFirstName(String value) {
    if (_Customer.LOG.isDebugEnabled()) {
    	_Customer.LOG.debug( "updating firstName from " + firstName() + " to " + value);
    }
    takeStoredValueForKey(value, "firstName");
  }

  public String lastName() {
    return (String) storedValueForKey("lastName");
  }

  public void setLastName(String value) {
    if (_Customer.LOG.isDebugEnabled()) {
    	_Customer.LOG.debug( "updating lastName from " + lastName() + " to " + value);
    }
    takeStoredValueForKey(value, "lastName");
  }

  public NSTimestamp memberSince() {
    return (NSTimestamp) storedValueForKey("memberSince");
  }

  public void setMemberSince(NSTimestamp value) {
    if (_Customer.LOG.isDebugEnabled()) {
    	_Customer.LOG.debug( "updating memberSince from " + memberSince() + " to " + value);
    }
    takeStoredValueForKey(value, "memberSince");
  }

  public String phone() {
    return (String) storedValueForKey("phone");
  }

  public void setPhone(String value) {
    if (_Customer.LOG.isDebugEnabled()) {
    	_Customer.LOG.debug( "updating phone from " + phone() + " to " + value);
    }
    takeStoredValueForKey(value, "phone");
  }

  public String state() {
    return (String) storedValueForKey("state");
  }

  public void setState(String value) {
    if (_Customer.LOG.isDebugEnabled()) {
    	_Customer.LOG.debug( "updating state from " + state() + " to " + value);
    }
    takeStoredValueForKey(value, "state");
  }

  public String streetAddress() {
    return (String) storedValueForKey("streetAddress");
  }

  public void setStreetAddress(String value) {
    if (_Customer.LOG.isDebugEnabled()) {
    	_Customer.LOG.debug( "updating streetAddress from " + streetAddress() + " to " + value);
    }
    takeStoredValueForKey(value, "streetAddress");
  }

  public String zip() {
    return (String) storedValueForKey("zip");
  }

  public void setZip(String value) {
    if (_Customer.LOG.isDebugEnabled()) {
    	_Customer.LOG.debug( "updating zip from " + zip() + " to " + value);
    }
    takeStoredValueForKey(value, "zip");
  }

  public webobjectsexamples.businesslogic.rentals.common.CreditCard creditCard() {
    return (webobjectsexamples.businesslogic.rentals.common.CreditCard)storedValueForKey("creditCard");
  }

  public void setCreditCardRelationship(webobjectsexamples.businesslogic.rentals.common.CreditCard value) {
    if (_Customer.LOG.isDebugEnabled()) {
      _Customer.LOG.debug("updating creditCard from " + creditCard() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.rentals.common.CreditCard oldValue = creditCard();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "creditCard");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "creditCard");
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(webobjectsexamples.businesslogic.rentals.common.Rental.CUSTOMER_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    if (_Customer.LOG.isDebugEnabled()) {
      _Customer.LOG.debug("adding " + object + " to rentals relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "rentals");
  }

  public void removeFromRentalsRelationship(webobjectsexamples.businesslogic.rentals.common.Rental object) {
    if (_Customer.LOG.isDebugEnabled()) {
      _Customer.LOG.debug("removing " + object + " from rentals relationship");
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
  }

  public void deleteAllRentalsRelationships() {
    Enumeration objects = rentals().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRentalsRelationship((webobjectsexamples.businesslogic.rentals.common.Rental)objects.nextElement());
    }
  }


  public static Customer createCustomer(EOEditingContext editingContext, String city
, String firstName
, String lastName
) {
    Customer eo = (Customer) EOUtilities.createAndInsertInstance(editingContext, _Customer.ENTITY_NAME);    
		eo.setCity(city);
		eo.setFirstName(firstName);
		eo.setLastName(lastName);
    return eo;
  }

  public static NSArray<Customer> fetchAllCustomers(EOEditingContext editingContext) {
    return _Customer.fetchAllCustomers(editingContext, null);
  }

  public static NSArray<Customer> fetchAllCustomers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Customer.fetchCustomers(editingContext, null, sortOrderings);
  }

  public static NSArray<Customer> fetchCustomers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Customer.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Customer> eoObjects = (NSArray<Customer>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Customer fetchCustomer(EOEditingContext editingContext, String keyName, Object value) {
    return _Customer.fetchCustomer(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Customer fetchCustomer(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Customer> eoObjects = _Customer.fetchCustomers(editingContext, qualifier, null);
    Customer eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Customer)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Customer that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Customer fetchRequiredCustomer(EOEditingContext editingContext, String keyName, Object value) {
    return _Customer.fetchRequiredCustomer(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Customer fetchRequiredCustomer(EOEditingContext editingContext, EOQualifier qualifier) {
    Customer eoObject = _Customer.fetchCustomer(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Customer that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Customer localInstanceIn(EOEditingContext editingContext, Customer eo) {
    Customer localInstance = (eo == null) ? null : (Customer)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
