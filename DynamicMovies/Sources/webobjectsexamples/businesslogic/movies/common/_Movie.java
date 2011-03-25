// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to Movie.java instead.
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
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimestamp;

@SuppressWarnings("all")
public abstract class _Movie extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Movie";

	// Attributes
	public static final String CATEGORY_KEY = "category";
	public static final String DATE_RELEASED_KEY = "dateReleased";
	public static final String POSTER_NAME_KEY = "posterName";
	public static final String RATED_KEY = "rated";
	public static final String REVENUE_KEY = "revenue";
	public static final String TITLE_KEY = "title";
	public static final String TRAILER_NAME_KEY = "trailerName";

	// Relationships
	public static final String DIRECTORS_KEY = "directors";
	public static final String PLOT_SUMMARY_KEY = "plotSummary";
	public static final String REVIEWS_KEY = "reviews";
	public static final String ROLES_KEY = "roles";
	public static final String STUDIO_KEY = "studio";
	public static final String VOTING_KEY = "voting";

  private static Logger LOG = Logger.getLogger(_Movie.class);

  public Movie localInstanceIn(EOEditingContext editingContext) {
    Movie localInstance = (Movie)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String category() {
    return (String) storedValueForKey("category");
  }

  public void setCategory(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating category from " + category() + " to " + value);
    }
    takeStoredValueForKey(value, "category");
  }

  public NSTimestamp dateReleased() {
    return (NSTimestamp) storedValueForKey("dateReleased");
  }

  public void setDateReleased(NSTimestamp value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating dateReleased from " + dateReleased() + " to " + value);
    }
    takeStoredValueForKey(value, "dateReleased");
  }

  public String posterName() {
    return (String) storedValueForKey("posterName");
  }

  public void setPosterName(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating posterName from " + posterName() + " to " + value);
    }
    takeStoredValueForKey(value, "posterName");
  }

  public String rated() {
    return (String) storedValueForKey("rated");
  }

  public void setRated(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating rated from " + rated() + " to " + value);
    }
    takeStoredValueForKey(value, "rated");
  }

  public java.math.BigDecimal revenue() {
    return (java.math.BigDecimal) storedValueForKey("revenue");
  }

  public void setRevenue(java.math.BigDecimal value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating revenue from " + revenue() + " to " + value);
    }
    takeStoredValueForKey(value, "revenue");
  }

  public String title() {
    return (String) storedValueForKey("title");
  }

  public void setTitle(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating title from " + title() + " to " + value);
    }
    takeStoredValueForKey(value, "title");
  }

  public String trailerName() {
    return (String) storedValueForKey("trailerName");
  }

  public void setTrailerName(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating trailerName from " + trailerName() + " to " + value);
    }
    takeStoredValueForKey(value, "trailerName");
  }

  public webobjectsexamples.businesslogic.movies.common.PlotSummary plotSummary() {
    return (webobjectsexamples.businesslogic.movies.common.PlotSummary)storedValueForKey("plotSummary");
  }

  public void setPlotSummaryRelationship(webobjectsexamples.businesslogic.movies.common.PlotSummary value) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("updating plotSummary from " + plotSummary() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.movies.common.PlotSummary oldValue = plotSummary();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "plotSummary");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "plotSummary");
    }
  }
  
  public webobjectsexamples.businesslogic.movies.server.Studio studio() {
    return (webobjectsexamples.businesslogic.movies.server.Studio)storedValueForKey("studio");
  }

  public void setStudioRelationship(webobjectsexamples.businesslogic.movies.server.Studio value) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("updating studio from " + studio() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.movies.server.Studio oldValue = studio();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "studio");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "studio");
    }
  }
  
  public webobjectsexamples.businesslogic.movies.common.Voting voting() {
    return (webobjectsexamples.businesslogic.movies.common.Voting)storedValueForKey("voting");
  }

  public void setVotingRelationship(webobjectsexamples.businesslogic.movies.common.Voting value) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("updating voting from " + voting() + " to " + value);
    }
    if (value == null) {
    	webobjectsexamples.businesslogic.movies.common.Voting oldValue = voting();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "voting");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "voting");
    }
  }
  
  public NSArray<webobjectsexamples.businesslogic.movies.common.Talent> directors() {
    return (NSArray<webobjectsexamples.businesslogic.movies.common.Talent>)storedValueForKey("directors");
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.Talent> directors(EOQualifier qualifier) {
    return directors(qualifier, null);
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.Talent> directors(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<webobjectsexamples.businesslogic.movies.common.Talent> results;
      results = directors();
      if (qualifier != null) {
        results = (NSArray<webobjectsexamples.businesslogic.movies.common.Talent>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<webobjectsexamples.businesslogic.movies.common.Talent>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToDirectorsRelationship(webobjectsexamples.businesslogic.movies.common.Talent object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("adding " + object + " to directors relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "directors");
  }

  public void removeFromDirectorsRelationship(webobjectsexamples.businesslogic.movies.common.Talent object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("removing " + object + " from directors relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "directors");
  }

  public webobjectsexamples.businesslogic.movies.common.Talent createDirectorsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Talent");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "directors");
    return (webobjectsexamples.businesslogic.movies.common.Talent) eo;
  }

  public void deleteDirectorsRelationship(webobjectsexamples.businesslogic.movies.common.Talent object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "directors");
    editingContext().deleteObject(object);
  }

  public void deleteAllDirectorsRelationships() {
    Enumeration objects = directors().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDirectorsRelationship((webobjectsexamples.businesslogic.movies.common.Talent)objects.nextElement());
    }
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.Review> reviews() {
    return (NSArray<webobjectsexamples.businesslogic.movies.common.Review>)storedValueForKey("reviews");
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.Review> reviews(EOQualifier qualifier) {
    return reviews(qualifier, null, false);
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.Review> reviews(EOQualifier qualifier, boolean fetch) {
    return reviews(qualifier, null, fetch);
  }

  public NSArray<webobjectsexamples.businesslogic.movies.common.Review> reviews(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<webobjectsexamples.businesslogic.movies.common.Review> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(webobjectsexamples.businesslogic.movies.common.Review.MOVIE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = webobjectsexamples.businesslogic.movies.common.Review.fetchReviews(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = reviews();
      if (qualifier != null) {
        results = (NSArray<webobjectsexamples.businesslogic.movies.common.Review>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<webobjectsexamples.businesslogic.movies.common.Review>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToReviewsRelationship(webobjectsexamples.businesslogic.movies.common.Review object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("adding " + object + " to reviews relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "reviews");
  }

  public void removeFromReviewsRelationship(webobjectsexamples.businesslogic.movies.common.Review object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("removing " + object + " from reviews relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "reviews");
  }

  public webobjectsexamples.businesslogic.movies.common.Review createReviewsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Review");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "reviews");
    return (webobjectsexamples.businesslogic.movies.common.Review) eo;
  }

  public void deleteReviewsRelationship(webobjectsexamples.businesslogic.movies.common.Review object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "reviews");
  }

  public void deleteAllReviewsRelationships() {
    Enumeration objects = reviews().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteReviewsRelationship((webobjectsexamples.businesslogic.movies.common.Review)objects.nextElement());
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(webobjectsexamples.businesslogic.movies.common.MovieRole.MOVIE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("adding " + object + " to roles relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "roles");
  }

  public void removeFromRolesRelationship(webobjectsexamples.businesslogic.movies.common.MovieRole object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("removing " + object + " from roles relationship");
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
  }

  public void deleteAllRolesRelationships() {
    Enumeration objects = roles().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRolesRelationship((webobjectsexamples.businesslogic.movies.common.MovieRole)objects.nextElement());
    }
  }


  public static Movie createMovie(EOEditingContext editingContext, String title
) {
    Movie eo = (Movie) EOUtilities.createAndInsertInstance(editingContext, _Movie.ENTITY_NAME);    
		eo.setTitle(title);
    return eo;
  }

  public static NSArray<Movie> fetchAllMovies(EOEditingContext editingContext) {
    return _Movie.fetchAllMovies(editingContext, null);
  }

  public static NSArray<Movie> fetchAllMovies(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Movie.fetchMovies(editingContext, null, sortOrderings);
  }

  public static NSArray<Movie> fetchMovies(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Movie.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Movie> eoObjects = (NSArray<Movie>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Movie fetchMovie(EOEditingContext editingContext, String keyName, Object value) {
    return _Movie.fetchMovie(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Movie fetchMovie(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Movie> eoObjects = _Movie.fetchMovies(editingContext, qualifier, null);
    Movie eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Movie)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Movie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Movie fetchRequiredMovie(EOEditingContext editingContext, String keyName, Object value) {
    return _Movie.fetchRequiredMovie(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Movie fetchRequiredMovie(EOEditingContext editingContext, EOQualifier qualifier) {
    Movie eoObject = _Movie.fetchMovie(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Movie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Movie localInstanceIn(EOEditingContext editingContext, Movie eo) {
    Movie localInstance = (eo == null) ? null : (Movie)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<webobjectsexamples.businesslogic.movies.common.Movie> fetchDeepFetchOneMovie(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("DeepFetchOneMovie", "Movie");
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<webobjectsexamples.businesslogic.movies.common.Movie>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<webobjectsexamples.businesslogic.movies.common.Movie> fetchDeepFetchOneMovie(EOEditingContext editingContext,
	Integer myMovieBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("DeepFetchOneMovie", "Movie");
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(myMovieBinding, "myMovie");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<webobjectsexamples.businesslogic.movies.common.Movie>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<webobjectsexamples.businesslogic.movies.common.Movie> fetchQualifierVariable(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("QualifierVariable", "Movie");
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<webobjectsexamples.businesslogic.movies.common.Movie>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<webobjectsexamples.businesslogic.movies.common.Movie> fetchQualifierVariable(EOEditingContext editingContext,
	java.math.BigDecimal revenueBinding,
	webobjectsexamples.businesslogic.movies.server.Studio studioBinding,
	String studioNameBinding,
	String titleBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("QualifierVariable", "Movie");
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(revenueBinding, "revenue");
    bindings.takeValueForKey(studioBinding, "studio");
    bindings.takeValueForKey(studioNameBinding, "studioName");
    bindings.takeValueForKey(titleBinding, "title");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<webobjectsexamples.businesslogic.movies.common.Movie>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<NSDictionary> fetchRawFetchAllMovies(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("RawFetchAllMovies", "Movie");
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<NSDictionary>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<NSDictionary> fetchRawFetchAllMovies(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("RawFetchAllMovies", "Movie");
    return (NSArray<NSDictionary>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
