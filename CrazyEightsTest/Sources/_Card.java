// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to Card.java instead.
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
public abstract class _Card extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Card";

	// Attributes
	public static final String FILENAME_KEY = "filename";
	public static final String NAME_KEY = "name";
	public static final String RANK_KEY = "rank";
	public static final String SUIT_KEY = "suit";
	public static final String VALUE_KEY = "value";

	// Relationships

  private static Logger LOG = Logger.getLogger(_Card.class);

  public Card localInstanceIn(EOEditingContext editingContext) {
    Card localInstance = (Card)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String filename() {
    return (String) storedValueForKey("filename");
  }

  public void setFilename(String value) {
    if (_Card.LOG.isDebugEnabled()) {
    	_Card.LOG.debug( "updating filename from " + filename() + " to " + value);
    }
    takeStoredValueForKey(value, "filename");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_Card.LOG.isDebugEnabled()) {
    	_Card.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public String rank() {
    return (String) storedValueForKey("rank");
  }

  public void setRank(String value) {
    if (_Card.LOG.isDebugEnabled()) {
    	_Card.LOG.debug( "updating rank from " + rank() + " to " + value);
    }
    takeStoredValueForKey(value, "rank");
  }

  public String suit() {
    return (String) storedValueForKey("suit");
  }

  public void setSuit(String value) {
    if (_Card.LOG.isDebugEnabled()) {
    	_Card.LOG.debug( "updating suit from " + suit() + " to " + value);
    }
    takeStoredValueForKey(value, "suit");
  }

  public Integer value() {
    return (Integer) storedValueForKey("value");
  }

  public void setValue(Integer value) {
    if (_Card.LOG.isDebugEnabled()) {
    	_Card.LOG.debug( "updating value from " + value() + " to " + value);
    }
    takeStoredValueForKey(value, "value");
  }


  public static Card createCard(EOEditingContext editingContext, String name
) {
    Card eo = (Card) EOUtilities.createAndInsertInstance(editingContext, _Card.ENTITY_NAME);    
		eo.setName(name);
    return eo;
  }

  public static NSArray<Card> fetchAllCards(EOEditingContext editingContext) {
    return _Card.fetchAllCards(editingContext, null);
  }

  public static NSArray<Card> fetchAllCards(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Card.fetchCards(editingContext, null, sortOrderings);
  }

  public static NSArray<Card> fetchCards(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Card.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Card> eoObjects = (NSArray<Card>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Card fetchCard(EOEditingContext editingContext, String keyName, Object value) {
    return _Card.fetchCard(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Card fetchCard(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Card> eoObjects = _Card.fetchCards(editingContext, qualifier, null);
    Card eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Card)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Card that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Card fetchRequiredCard(EOEditingContext editingContext, String keyName, Object value) {
    return _Card.fetchRequiredCard(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Card fetchRequiredCard(EOEditingContext editingContext, EOQualifier qualifier) {
    Card eoObject = _Card.fetchCard(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Card that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Card localInstanceIn(EOEditingContext editingContext, Card eo) {
    Card localInstance = (eo == null) ? null : (Card)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
