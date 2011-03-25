/*
 DisplayReviewPage.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */

import webobjectsexamples.businesslogic.movies.common.Review;

import com.webobjects.appserver.WOContext;


/*
 This class and the associated component is used to list the reviews
 for a particular movie, displaying links for all of the reviews but
 showing only the current one.
 */
 
public class DisplayReviewsPage extends MovieComponent {

    // Instance variable to iterate through the list of reviews
    public Review rev;

    // Instance variable for the selected review 
    public Review review;


    /**
     * Constructor
     */
     
    public DisplayReviewsPage( WOContext context ) {
        super( context );
    }
    

    /**
     * Method to return the selection status of the current Review.  If
     * the current Review is the same as the iterated Review in the list
     * return true;  otherwise false is returned.
     */
     
    public boolean isSelectedReview() {
        return rev == review;
    }


    /**
     * Method to return the review ID, used as an attribute on the WOHyperlink
     * to display a review when clicked.  If the Review is null, then return
     * 0 (which would show the first Review in the list).
     */
      
    public Number reviewID() {
        if (rev == null) {
            return new Integer(0);
        } else {
            return (Number)Application.myApplication().primaryKeyForObject( rev );
        }
    }
    
}
