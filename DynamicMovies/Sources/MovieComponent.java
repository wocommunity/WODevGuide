/*
 MovieComponent.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */


import webobjectsexamples.businesslogic.movies.common.Movie;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSKeyValueCoding;


/*
 This class is used as an enhanced class for the components to extend in this
 application.  This class contains a number of instance variables for the names
 of the form fields, and methods to return the ID for a movie, the index of the
 movie, and the index of the movie ID.  These are used by a number of components
 for batching and other processes.
 */
 
public class MovieComponent extends WOComponent {

    // Static instance variable for the form attribute names
    public static final String MovieKey = "movie";
    public static final String RawMovieKey = "rawMovie";
    public static final String MovieIDKey = "movieID";
    public static final String MovieTitleKey = "title";

    // Instance variable for the movie object
    protected Movie movie;
    
    // Instance variable for the raw movie information
    protected NSKeyValueCoding rawMovie;


    /**
     * Constructor for the component
     */
     
    public MovieComponent( WOContext context ) {
        super( context );
    }


    /**
     * Method returning the movie ID for the local instance variable for the movie.
     * This method uses the information on the movie to get the raw (dictionary) data
     * for the movie from the Application class, and then returns the value for the 
     * ID attribute.
     */

    public Number movieID() {
    
        if ( rawMovie == null ) {
	
            if ( movie != null ) {
                Object result = Application.myApplication().primaryKeyForObject( movie );
                String title = (String)movie.valueForKey( MovieTitleKey );
                rawMovie = new NSDictionary(
		    new Object[] { result, title }, 
		    new Object[] { MovieIDKey, MovieTitleKey } );		    
            } else {
                return null;
            }
        }
        return (Number) rawMovie.valueForKey(MovieIDKey);
    }


    /**
     * Method to return the index of the current movie in the list of movies.  This
     * method uses the primary key for the movie and then, based on the index of
     * at key in the list of all primary keys, returns the appropriate index.
     *
     * @param list	list of movies
     * @param movie	more to find the index of
     * @return		the index of the movie in the list
     */
     
    public int indexOfMovie( NSArray list, EOEnterpriseObject movie ) {
    
        Object result = Application.myApplication().primaryKeyForObject( movie );
        if ( result == null ) {
            return -1;
        }

        return indexOfMovieID( list, result );
    }


    /**
     * Method to return the index of the current movieID in the list of all indexes.
     *
     * @param list	list of movie IDs
     * @param movieID	ID for the current movie
     * @return		the index of the movie ID in the list
     */
     
    public int indexOfMovieID( NSArray list, Object movieID ) {
        if (movieID == null) {
            return -1;
        }

        int c = list.count();
        for (int i = 0; i < c; i++) {
            NSKeyValueCoding object = (NSKeyValueCoding)list.objectAtIndex(i);
            Object id = object.valueForKey(MovieIDKey);
            if ((id != null) && (id.equals(movieID))) {
                return i;
            }
        }

        return -1;
    }
    
    /**
     * Override of the awake method.  This method uses a local instance variable
     * to lock and get the Application's editing context while displaying the
     * information on the page.
     */
     
    public void awake() {
        super.awake();
        EOEditingContext ignore = ( (Application)application() ).lockEC();
    }

    
    /**
     * Override of the sleep method -- this method uses the Application's method
     * to unlock the editing context for the Application (which was locked during
     * the awake() method.)
     */
     
    public void sleep() {
        ( (Application)application() ).unlockEC();
        super.sleep();
    }


}
