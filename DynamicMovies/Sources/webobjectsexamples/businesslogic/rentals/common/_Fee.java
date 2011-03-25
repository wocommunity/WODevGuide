// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to Fee.java instead.
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
public abstract class _Fee extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Fee";

	// Attributes
	public static final String AMOUNT_KEY = "amount";
	public static final String DATE_PAID_KEY = "datePaid";

	// Relationships
	public static final String FEE_TYPE_KEY = "feeType";
	public static final String RENTAL_KEY = "rental";

  private static Logger LOG = Logger.getLogger(_Fee.class);

  public Fee localInstanceIn(EOEditingContext editingContext) {
    Fee localInstance = (Fee)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public java.math.BigDecimal amount() {
    return (java.math.BigDecimal) storedValueForKey("amount");
  }

  public void setAmount(java.math.BigDecimal value) {
    if (_Fee.LOG.isDebugEnabled()) {
    	_Fee.LOG.debug( "updating amount from " + amount() + " to " + value);
    }
    takeStoredValueForKey(value, "amount");
  }

  public NSTimestamp datePaid() {
    return (NSTimestamp) storedValueForKey("datePaid");
  }

  public void setDatePaid(NSTimestamp value) {
    if (_Fee.LOG.isDebugEnabled()) {
    	_Fee.LOG.debug( "updating datePaid from " + datePaid() + " to " + value);
    }
    takeStoredValueForKey(value, "datePaid");
  }

  public webobjectsexamples.businesslogic.rentals.common.FeeType feeType() {
    return (webobjectsexamples.businesslogic.rentals.common.FeeType)storedValueForKey("feeType");
  }

  public void setFeeTypeRelationship(webobjectsexamples.businesslogic.rentals.common.FeeType value) {
    if (_Fee.LOG.isDebugEnabled()) {
      _Fee.LOG.debug("updating feeType from " + feeType() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.rentals.common.FeeType oldValue = feeType();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "feeType");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "feeType");
    }
  }
  
  public webobjectsexamples.businesslogic.rentals.common.Rental rental() {
    return (webobjectsexamples.businesslogic.rentals.common.Rental)storedValueForKey("rental");
  }

  public void setRentalRelationship(webobjectsexamples.businesslogic.rentals.common.Rental value) {
    if (_Fee.LOG.isDebugEnabled()) {
      _Fee.LOG.debug("updating rental from " + rental() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.rentals.common.Rental oldValue = rental();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "rental");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "rental");
    }
  }
  

  public static Fee createFee(EOEditingContext editingContext, java.math.BigDecimal amount
, webobjectsexamples.businesslogic.rentals.common.FeeType feeType) {
    Fee eo = (Fee) EOUtilities.createAndInsertInstance(editingContext, _Fee.ENTITY_NAME);    
		eo.setAmount(amount);
    eo.setFeeTypeRelationship(feeType);
    return eo;
  }

  public static NSArray<Fee> fetchAllFees(EOEditingContext editingContext) {
    return _Fee.fetchAllFees(editingContext, null);
  }

  public static NSArray<Fee> fetchAllFees(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Fee.fetchFees(editingContext, null, sortOrderings);
  }

  public static NSArray<Fee> fetchFees(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Fee.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Fee> eoObjects = (NSArray<Fee>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Fee fetchFee(EOEditingContext editingContext, String keyName, Object value) {
    return _Fee.fetchFee(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Fee fetchFee(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Fee> eoObjects = _Fee.fetchFees(editingContext, qualifier, null);
    Fee eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Fee)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Fee that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Fee fetchRequiredFee(EOEditingContext editingContext, String keyName, Object value) {
    return _Fee.fetchRequiredFee(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Fee fetchRequiredFee(EOEditingContext editingContext, EOQualifier qualifier) {
    Fee eoObject = _Fee.fetchFee(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Fee that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Fee localInstanceIn(EOEditingContext editingContext, Fee eo) {
    Fee localInstance = (eo == null) ? null : (Fee)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
