// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to FeeType.java instead.
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
public abstract class _FeeType extends  EOGenericRecord {
	public static final String ENTITY_NAME = "FeeType";

	// Attributes
	public static final String ENABLED_KEY = "enabled";
	public static final String FEE_TYPE_KEY = "feeType";
	public static final String ORDER_BY_KEY = "orderBy";

	// Relationships

  private static Logger LOG = Logger.getLogger(_FeeType.class);

  public FeeType localInstanceIn(EOEditingContext editingContext) {
    FeeType localInstance = (FeeType)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer enabled() {
    return (Integer) storedValueForKey("enabled");
  }

  public void setEnabled(Integer value) {
    if (_FeeType.LOG.isDebugEnabled()) {
    	_FeeType.LOG.debug( "updating enabled from " + enabled() + " to " + value);
    }
    takeStoredValueForKey(value, "enabled");
  }

  public String feeType() {
    return (String) storedValueForKey("feeType");
  }

  public void setFeeType(String value) {
    if (_FeeType.LOG.isDebugEnabled()) {
    	_FeeType.LOG.debug( "updating feeType from " + feeType() + " to " + value);
    }
    takeStoredValueForKey(value, "feeType");
  }

  public Integer orderBy() {
    return (Integer) storedValueForKey("orderBy");
  }

  public void setOrderBy(Integer value) {
    if (_FeeType.LOG.isDebugEnabled()) {
    	_FeeType.LOG.debug( "updating orderBy from " + orderBy() + " to " + value);
    }
    takeStoredValueForKey(value, "orderBy");
  }


  public static FeeType createFeeType(EOEditingContext editingContext, Integer enabled
, String feeType
, Integer orderBy
) {
    FeeType eo = (FeeType) EOUtilities.createAndInsertInstance(editingContext, _FeeType.ENTITY_NAME);    
		eo.setEnabled(enabled);
		eo.setFeeType(feeType);
		eo.setOrderBy(orderBy);
    return eo;
  }

  public static NSArray<FeeType> fetchAllFeeTypes(EOEditingContext editingContext) {
    return _FeeType.fetchAllFeeTypes(editingContext, null);
  }

  public static NSArray<FeeType> fetchAllFeeTypes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _FeeType.fetchFeeTypes(editingContext, null, sortOrderings);
  }

  public static NSArray<FeeType> fetchFeeTypes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_FeeType.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<FeeType> eoObjects = (NSArray<FeeType>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static FeeType fetchFeeType(EOEditingContext editingContext, String keyName, Object value) {
    return _FeeType.fetchFeeType(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static FeeType fetchFeeType(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<FeeType> eoObjects = _FeeType.fetchFeeTypes(editingContext, qualifier, null);
    FeeType eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (FeeType)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one FeeType that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static FeeType fetchRequiredFeeType(EOEditingContext editingContext, String keyName, Object value) {
    return _FeeType.fetchRequiredFeeType(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static FeeType fetchRequiredFeeType(EOEditingContext editingContext, EOQualifier qualifier) {
    FeeType eoObject = _FeeType.fetchFeeType(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no FeeType that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static FeeType localInstanceIn(EOEditingContext editingContext, FeeType eo) {
    FeeType localInstance = (eo == null) ? null : (FeeType)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
