// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to Voting.java instead.
package webobjectsexamples.businesslogic.movies.common;

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
public abstract class _Voting extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Voting";

	// Attributes
	public static final String NUMBER_OF_VOTES_KEY = "numberOfVotes";
	public static final String RUNNING_AVERAGE_KEY = "runningAverage";

	// Relationships
	public static final String MOVIE_KEY = "movie";

  private static Logger LOG = Logger.getLogger(_Voting.class);

  public Voting localInstanceIn(EOEditingContext editingContext) {
    Voting localInstance = (Voting)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer numberOfVotes() {
    return (Integer) storedValueForKey("numberOfVotes");
  }

  public void setNumberOfVotes(Integer value) {
    if (_Voting.LOG.isDebugEnabled()) {
    	_Voting.LOG.debug( "updating numberOfVotes from " + numberOfVotes() + " to " + value);
    }
    takeStoredValueForKey(value, "numberOfVotes");
  }

  public Double runningAverage() {
    return (Double) storedValueForKey("runningAverage");
  }

  public void setRunningAverage(Double value) {
    if (_Voting.LOG.isDebugEnabled()) {
    	_Voting.LOG.debug( "updating runningAverage from " + runningAverage() + " to " + value);
    }
    takeStoredValueForKey(value, "runningAverage");
  }

  public webobjectsexamples.businesslogic.movies.common.Movie movie() {
    return (webobjectsexamples.businesslogic.movies.common.Movie)storedValueForKey("movie");
  }

  public void setMovieRelationship(webobjectsexamples.businesslogic.movies.common.Movie value) {
    if (_Voting.LOG.isDebugEnabled()) {
      _Voting.LOG.debug("updating movie from " + movie() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.movies.common.Movie oldValue = movie();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "movie");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "movie");
    }
  }
  

  public static Voting createVoting(EOEditingContext editingContext, webobjectsexamples.businesslogic.movies.common.Movie movie) {
    Voting eo = (Voting) EOUtilities.createAndInsertInstance(editingContext, _Voting.ENTITY_NAME);    
    eo.setMovieRelationship(movie);
    return eo;
  }

  public static NSArray<Voting> fetchAllVotings(EOEditingContext editingContext) {
    return _Voting.fetchAllVotings(editingContext, null);
  }

  public static NSArray<Voting> fetchAllVotings(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Voting.fetchVotings(editingContext, null, sortOrderings);
  }

  public static NSArray<Voting> fetchVotings(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Voting.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Voting> eoObjects = (NSArray<Voting>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Voting fetchVoting(EOEditingContext editingContext, String keyName, Object value) {
    return _Voting.fetchVoting(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Voting fetchVoting(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Voting> eoObjects = _Voting.fetchVotings(editingContext, qualifier, null);
    Voting eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Voting)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Voting that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Voting fetchRequiredVoting(EOEditingContext editingContext, String keyName, Object value) {
    return _Voting.fetchRequiredVoting(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Voting fetchRequiredVoting(EOEditingContext editingContext, EOQualifier qualifier) {
    Voting eoObject = _Voting.fetchVoting(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Voting that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Voting localInstanceIn(EOEditingContext editingContext, Voting eo) {
    Voting localInstance = (eo == null) ? null : (Voting)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
