// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to CreditCard.java instead.
package webobjectsexamples.businesslogic.rentals.common;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

@SuppressWarnings("all")
public abstract class _CreditCard extends  EOGenericRecord {
	public static final String ENTITY_NAME = "CreditCard";

	// Attributes
	public static final String AUTHORIZATION_DATE_KEY = "authorizationDate";
	public static final String AUTHORIZATION_NUM_KEY = "authorizationNum";
	public static final String CARD_NUMBER_KEY = "cardNumber";
	public static final String EXPIRATION_DATE_KEY = "expirationDate";
	public static final String LIMIT_KEY = "limit";

	// Relationships
	public static final String CUSTOMER_KEY = "customer";

  private static Logger LOG = Logger.getLogger(_CreditCard.class);

  public CreditCard localInstanceIn(EOEditingContext editingContext) {
    CreditCard localInstance = (CreditCard)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp authorizationDate() {
    return (NSTimestamp) storedValueForKey("authorizationDate");
  }

  public void setAuthorizationDate(NSTimestamp value) {
    if (_CreditCard.LOG.isDebugEnabled()) {
    	_CreditCard.LOG.debug( "updating authorizationDate from " + authorizationDate() + " to " + value);
    }
    takeStoredValueForKey(value, "authorizationDate");
  }

  public String authorizationNum() {
    return (String) storedValueForKey("authorizationNum");
  }

  public void setAuthorizationNum(String value) {
    if (_CreditCard.LOG.isDebugEnabled()) {
    	_CreditCard.LOG.debug( "updating authorizationNum from " + authorizationNum() + " to " + value);
    }
    takeStoredValueForKey(value, "authorizationNum");
  }

  public String cardNumber() {
    return (String) storedValueForKey("cardNumber");
  }

  public void setCardNumber(String value) {
    if (_CreditCard.LOG.isDebugEnabled()) {
    	_CreditCard.LOG.debug( "updating cardNumber from " + cardNumber() + " to " + value);
    }
    takeStoredValueForKey(value, "cardNumber");
  }

  public NSTimestamp expirationDate() {
    return (NSTimestamp) storedValueForKey("expirationDate");
  }

  public void setExpirationDate(NSTimestamp value) {
    if (_CreditCard.LOG.isDebugEnabled()) {
    	_CreditCard.LOG.debug( "updating expirationDate from " + expirationDate() + " to " + value);
    }
    takeStoredValueForKey(value, "expirationDate");
  }

  public java.math.BigDecimal limit() {
    return (java.math.BigDecimal) storedValueForKey("limit");
  }

  public void setLimit(java.math.BigDecimal value) {
    if (_CreditCard.LOG.isDebugEnabled()) {
    	_CreditCard.LOG.debug( "updating limit from " + limit() + " to " + value);
    }
    takeStoredValueForKey(value, "limit");
  }

  public webobjectsexamples.businesslogic.rentals.common.Customer customer() {
    return (webobjectsexamples.businesslogic.rentals.common.Customer)storedValueForKey("customer");
  }

  public void setCustomerRelationship(webobjectsexamples.businesslogic.rentals.common.Customer value) {
    if (_CreditCard.LOG.isDebugEnabled()) {
      _CreditCard.LOG.debug("updating customer from " + customer() + " to " + value);
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
  

  public static CreditCard createCreditCard(EOEditingContext editingContext, NSTimestamp authorizationDate
, String authorizationNum
, String cardNumber
, NSTimestamp expirationDate
, java.math.BigDecimal limit
, webobjectsexamples.businesslogic.rentals.common.Customer customer) {
    CreditCard eo = (CreditCard) EOUtilities.createAndInsertInstance(editingContext, _CreditCard.ENTITY_NAME);    
		eo.setAuthorizationDate(authorizationDate);
		eo.setAuthorizationNum(authorizationNum);
		eo.setCardNumber(cardNumber);
		eo.setExpirationDate(expirationDate);
		eo.setLimit(limit);
    eo.setCustomerRelationship(customer);
    return eo;
  }

  public static NSArray<CreditCard> fetchAllCreditCards(EOEditingContext editingContext) {
    return _CreditCard.fetchAllCreditCards(editingContext, null);
  }

  public static NSArray<CreditCard> fetchAllCreditCards(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _CreditCard.fetchCreditCards(editingContext, null, sortOrderings);
  }

  public static NSArray<CreditCard> fetchCreditCards(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_CreditCard.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<CreditCard> eoObjects = (NSArray<CreditCard>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static CreditCard fetchCreditCard(EOEditingContext editingContext, String keyName, Object value) {
    return _CreditCard.fetchCreditCard(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static CreditCard fetchCreditCard(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<CreditCard> eoObjects = _CreditCard.fetchCreditCards(editingContext, qualifier, null);
    CreditCard eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (CreditCard)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one CreditCard that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static CreditCard fetchRequiredCreditCard(EOEditingContext editingContext, String keyName, Object value) {
    return _CreditCard.fetchRequiredCreditCard(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static CreditCard fetchRequiredCreditCard(EOEditingContext editingContext, EOQualifier qualifier) {
    CreditCard eoObject = _CreditCard.fetchCreditCard(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no CreditCard that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static CreditCard localInstanceIn(EOEditingContext editingContext, CreditCard eo) {
    CreditCard localInstance = (eo == null) ? null : (CreditCard)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
