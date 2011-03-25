/*
 SearchPage.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableDictionary;


/**
 This class and the associated component creates the search page for looking
 up movie information.  The actual search is performed by a directAction: all
 this page does is take the form information and pass it along.  Note that 
 this page utilizes a WOForm tag with a directActionName binding, and all of 
 the form elements all have defined "name" bindings (rather than using the
 generated element IDs.)  This is done so that the directAction for searching
 knows specifically which values are from which elements.
 */
 
public class SearchPage extends WOComponent {

    // Instance variable for the query dictionary for the search
    protected NSMutableDictionary queryDict;
    
    // Static instance variable set for the failed query key
    public static final String QueryFailedKey = "QueryFailed";
    

    /**
     * Constructor - this method instantiates the query dictionary
     * to a new NSMutableDictionary to get the form values
     */
     
    public SearchPage( WOContext context ) {
        super( context );
        queryDict = new NSMutableDictionary();
    }


    /**
     * Method to check to see if the query failed.  If the query
     * dictionary still has a value for the QueryFailedKey, then
     * return true:  otherwise return false.
     */
     
    public boolean didQueryFail() {
        return (queryDict.valueForKey(QueryFailedKey) != null);
    }
    
    
    /**
     * Cover method to return the date operator list from the Application
     * class to populate the pop-up button of options.
     */
     
    public NSArray dateOperatorList() {
        return Application.dateOperators;
    }


    /**
     * Cover method to return the text operator list from the Application
     * class to populate the pop-up button of options.
     */
     
    public NSArray textOperatorList() {
        return Application.textOperators;
    }

}
