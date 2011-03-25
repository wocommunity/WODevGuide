// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to RentalTerms.java instead.
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

@SuppressWarnings("all")
public abstract class _RentalTerms extends  EOGenericRecord {
	public static final String ENTITY_NAME = "RentalTerms";

	// Attributes
	public static final String CHECK_OUT_LENGTH_KEY = "checkOutLength";
	public static final String COST_KEY = "cost";
	public static final String DEPOSIT_AMOUNT_KEY = "depositAmount";
	public static final String NAME_KEY = "name";

	// Relationships

  private static Logger LOG = Logger.getLogger(_RentalTerms.class);

  public RentalTerms localInstanceIn(EOEditingContext editingContext) {
    RentalTerms localInstance = (RentalTerms)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer checkOutLength() {
    return (Integer) storedValueForKey("checkOutLength");
  }

  public void setCheckOutLength(Integer value) {
    if (_RentalTerms.LOG.isDebugEnabled()) {
    	_RentalTerms.LOG.debug( "updating checkOutLength from " + checkOutLength() + " to " + value);
    }
    takeStoredValueForKey(value, "checkOutLength");
  }

  public java.math.BigDecimal cost() {
    return (java.math.BigDecimal) storedValueForKey("cost");
  }

  public void setCost(java.math.BigDecimal value) {
    if (_RentalTerms.LOG.isDebugEnabled()) {
    	_RentalTerms.LOG.debug( "updating cost from " + cost() + " to " + value);
    }
    takeStoredValueForKey(value, "cost");
  }

  public java.math.BigDecimal depositAmount() {
    return (java.math.BigDecimal) storedValueForKey("depositAmount");
  }

  public void setDepositAmount(java.math.BigDecimal value) {
    if (_RentalTerms.LOG.isDebugEnabled()) {
    	_RentalTerms.LOG.debug( "updating depositAmount from " + depositAmount() + " to " + value);
    }
    takeStoredValueForKey(value, "depositAmount");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_RentalTerms.LOG.isDebugEnabled()) {
    	_RentalTerms.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }


  public static RentalTerms createRentalTerms(EOEditingContext editingContext, Integer checkOutLength
, java.math.BigDecimal cost
, java.math.BigDecimal depositAmount
, String name
) {
    RentalTerms eo = (RentalTerms) EOUtilities.createAndInsertInstance(editingContext, _RentalTerms.ENTITY_NAME);    
		eo.setCheckOutLength(checkOutLength);
		eo.setCost(cost);
		eo.setDepositAmount(depositAmount);
		eo.setName(name);
    return eo;
  }

  public static NSArray<RentalTerms> fetchAllRentalTermses(EOEditingContext editingContext) {
    return _RentalTerms.fetchAllRentalTermses(editingContext, null);
  }

  public static NSArray<RentalTerms> fetchAllRentalTermses(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _RentalTerms.fetchRentalTermses(editingContext, null, sortOrderings);
  }

  public static NSArray<RentalTerms> fetchRentalTermses(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_RentalTerms.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<RentalTerms> eoObjects = (NSArray<RentalTerms>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static RentalTerms fetchRentalTerms(EOEditingContext editingContext, String keyName, Object value) {
    return _RentalTerms.fetchRentalTerms(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static RentalTerms fetchRentalTerms(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<RentalTerms> eoObjects = _RentalTerms.fetchRentalTermses(editingContext, qualifier, null);
    RentalTerms eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (RentalTerms)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one RentalTerms that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static RentalTerms fetchRequiredRentalTerms(EOEditingContext editingContext, String keyName, Object value) {
    return _RentalTerms.fetchRequiredRentalTerms(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static RentalTerms fetchRequiredRentalTerms(EOEditingContext editingContext, EOQualifier qualifier) {
    RentalTerms eoObject = _RentalTerms.fetchRentalTerms(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no RentalTerms that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static RentalTerms localInstanceIn(EOEditingContext editingContext, RentalTerms eo) {
    RentalTerms localInstance = (eo == null) ? null : (RentalTerms)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
