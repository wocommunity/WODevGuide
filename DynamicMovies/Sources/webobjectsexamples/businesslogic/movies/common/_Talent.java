// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to Talent.java instead.
package webobjectsexamples.businesslogic.movies.common;

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
public abstract class _Talent extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Talent";

	// Attributes
	public static final String FIRST_NAME_KEY = "firstName";
	public static final String LAST_NAME_KEY = "lastName";

	// Relationships
	public static final String MOVIES_DIRECTED_KEY = "moviesDirected";
	public static final String PHOTO_KEY = "photo";
	public static final String ROLES_KEY = "roles";

  private static Logger LOG = Logger.getLogger(_Talent.class);

  public Talent localInstanceIn(EOEditingContext editingContext) {
    Talent localInstance = (Talent)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String firstName() {
    return (String) storedValueForKey("firstName");
  }

  public void setFirstName(String value) {
    if (_Talent.LOG.isDebugEnabled()) {
    	_Talent.LOG.debug( "updating firstName from " + firstName() + " to " + value);
    }
    takeStoredValueForKey(value, "firstName");
  }

  public String lastName() {
    return (String) storedValueForKey("lastName");
  }

  public void setLastName(String value) {
    if (_Talent.LOG.isDebugEnabled()) {
    	_Talent.LOG.debug( "updating lastName from " + lastName() + " to " + value);
    }
    takeStoredValueForKey(value, "lastName");
  }

  public webobjectsexamples.businesslogic.movies.common.TalentPhoto photo() {
    return (webobjectsexamples.businesslogic.movies.common.TalentPhoto)storedValueForKey("photo");
  }

  public void setPhotoRelationship(webobjectsexamples.businesslogic.movies.common.TalentPhoto value) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("updating photo from " + photo() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.movies.common.TalentPhoto oldValue = photo();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "photo");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "photo");
    }
  }
  
  public NSArray<webobjectsexamples.businesslogic.movies.common.Movie> moviesDirected() {
    return (NSArray<webobjectsexamples.businesslogic.movies.common.Movie>)storedValueForKey("moviesDirected");
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.Movie> moviesDirected(EOQualifier qualifier) {
    return moviesDirected(qualifier, null);
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.Movie> moviesDirected(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<webobjectsexamples.businesslogic.movies.common.Movie> results;
      results = moviesDirected();
      if (qualifier != null) {
        results = (NSArray<webobjectsexamples.businesslogic.movies.common.Movie>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<webobjectsexamples.businesslogic.movies.common.Movie>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToMoviesDirectedRelationship(webobjectsexamples.businesslogic.movies.common.Movie object) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("adding " + object + " to moviesDirected relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "moviesDirected");
  }

  public void removeFromMoviesDirectedRelationship(webobjectsexamples.businesslogic.movies.common.Movie object) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("removing " + object + " from moviesDirected relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "moviesDirected");
  }

  public webobjectsexamples.businesslogic.movies.common.Movie createMoviesDirectedRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Movie");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "moviesDirected");
    return (webobjectsexamples.businesslogic.movies.common.Movie) eo;
  }

  public void deleteMoviesDirectedRelationship(webobjectsexamples.businesslogic.movies.common.Movie object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "moviesDirected");
    editingContext().deleteObject(object);
  }

  public void deleteAllMoviesDirectedRelationships() {
    Enumeration objects = moviesDirected().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMoviesDirectedRelationship((webobjectsexamples.businesslogic.movies.common.Movie)objects.nextElement());
    }
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.MovieRole> roles() {
    return (NSArray<webobjectsexamples.businesslogic.movies.common.MovieRole>)storedValueForKey("roles");
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.MovieRole> roles(EOQualifier qualifier) {
    return roles(qualifier, null, false);
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.MovieRole> roles(EOQualifier qualifier, boolean fetch) {
    return roles(qualifier, null, fetch);
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.MovieRole> roles(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<webobjectsexamples.businesslogic.movies.common.MovieRole> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(webobjectsexamples.businesslogic.movies.common.MovieRole.TALENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = webobjectsexamples.businesslogic.movies.common.MovieRole.fetchMovieRoles(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = roles();
      if (qualifier != null) {
        results = (NSArray<webobjectsexamples.businesslogic.movies.common.MovieRole>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<webobjectsexamples.businesslogic.movies.common.MovieRole>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToRolesRelationship(webobjectsexamples.businesslogic.movies.common.MovieRole object) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("adding " + object + " to roles relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "roles");
  }

  public void removeFromRolesRelationship(webobjectsexamples.businesslogic.movies.common.MovieRole object) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("removing " + object + " from roles relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "roles");
  }

  public webobjectsexamples.businesslogic.movies.common.MovieRole createRolesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("MovieRole");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "roles");
    return (webobjectsexamples.businesslogic.movies.common.MovieRole) eo;
  }

  public void deleteRolesRelationship(webobjectsexamples.businesslogic.movies.common.MovieRole object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "roles");
    editingContext().deleteObject(object);
  }

  public void deleteAllRolesRelationships() {
    Enumeration objects = roles().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRolesRelationship((webobjectsexamples.businesslogic.movies.common.MovieRole)objects.nextElement());
    }
  }


  public static Talent createTalent(EOEditingContext editingContext, String firstName
, String lastName
) {
    Talent eo = (Talent) EOUtilities.createAndInsertInstance(editingContext, _Talent.ENTITY_NAME);    
		eo.setFirstName(firstName);
		eo.setLastName(lastName);
    return eo;
  }

  public static NSArray<Talent> fetchAllTalents(EOEditingContext editingContext) {
    return _Talent.fetchAllTalents(editingContext, null);
  }

  public static NSArray<Talent> fetchAllTalents(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Talent.fetchTalents(editingContext, null, sortOrderings);
  }

  public static NSArray<Talent> fetchTalents(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Talent.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Talent> eoObjects = (NSArray<Talent>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Talent fetchTalent(EOEditingContext editingContext, String keyName, Object value) {
    return _Talent.fetchTalent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Talent fetchTalent(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Talent> eoObjects = _Talent.fetchTalents(editingContext, qualifier, null);
    Talent eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Talent)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Talent that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Talent fetchRequiredTalent(EOEditingContext editingContext, String keyName, Object value) {
    return _Talent.fetchRequiredTalent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Talent fetchRequiredTalent(EOEditingContext editingContext, EOQualifier qualifier) {
    Talent eoObject = _Talent.fetchTalent(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Talent that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Talent localInstanceIn(EOEditingContext editingContext, Talent eo) {
    Talent localInstance = (eo == null) ? null : (Talent)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
