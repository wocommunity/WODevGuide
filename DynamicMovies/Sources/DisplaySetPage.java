/*
 DisplaySetPage.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSMutableDictionary;

public class DisplaySetPage extends WOComponent {

    // Instance variable to use to show the list of movies
    protected WODisplayGroup displayGroup;
   
    // Instance variable for query information
    protected NSMutableDictionary queryDict;

    // Instance variable used internally
    public NSKeyValueCoding aMovie;


    /**
     * Constructor
     */
     
    public DisplaySetPage( WOContext context ) {
        super( context );
    }


    /**
     * Method to return the batch index plus one (used to set the information
     * in the navigation hyperlink to move to the next batch.
     */
     
    public int batchIndexPlusOne() {
	return displayGroup.currentBatchIndex() + 1;
    }


    /**
     * Method to return the batch index minus one (used to set the information
     * in the navigation hyperlink to move to the previous batch.
     */
     
    public int batchIndexMinusOne() {
       return displayGroup.currentBatchIndex() - 1;
    }

}
