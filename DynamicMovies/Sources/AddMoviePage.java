/*
 AddMoviePage.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */

import webobjectsexamples.businesslogic.movies.server.Studio;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;


/*
 This class and the associated component creates a page to gather information
 for a new movie.  This page only takes the information in and passes it along
 to the DirectAction bound to the form:  the EO is created in the DirectAction
 itself.
 */
 
public class AddMoviePage extends WOComponent {

    // Instance variables for the new movie information
    public String aTitle;
    public String aDateReleased;
    public String aCategory;
    public String aRevenue;
    
    // Instance variable for the Studio
    public Studio aStudio;
    
    // Instance variable for the array of all studios
    public NSArray aStudioList;
    
    // Instance variable for possible exceptions
    public Exception validationException;


    /**
     * Constructor 
     */
     
    public AddMoviePage( WOContext context ) {
        super( context );
    }


    /**
     * Override of the awake method - this override checks the local instance
     * variable for null;  if it is null, it is populated with the cached
     * studio list from the Application class.
     */
     
    public void awake() {
        super.awake();
        if (aStudioList == null) {
            aStudioList = ((Application) application()).studioList();
        }
    }


    /**
     * Method to return the status of an exception:  if the local instance
     * variable for exceptions is not null after the form processing then
     * an error has occurred;  otherwise everything is ok.
     */
     
    public boolean didValidationFail() {
        return (validationException != null);
    }


    /**
     * Method to return the (possible) validation method for the component.
     * This method checks the to see if the validation failed, and if it did
     * it creates an appropriate message to return to the user.
     */
     
    public String validationMessage() {
    
        if ( didValidationFail() ) {
            String msg = validationException.getMessage();
            if ( ( msg.indexOf("title" ) > -1) && ( msg.lastIndexOf("null") > -1) ) {
                return "The movie title must not be left blank.";
            } else {
                return msg;
            }
        } else {
            return "";
        }
    }

}
