/*
 AddReviewPage.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */

import com.webobjects.appserver.WOContext;


/*
 This class and the associated component creates form elements to take
 information for a new review and pass it to the directAction bound to 
 the form.
 */
 
public class AddReviewPage extends MovieComponent {

    // Instance variable to iterate through the reviews
    public String review;

    // Instance variable for the reviewer
    public String reviewer;


    /**
     * Constructor
     */
     
    public AddReviewPage( WOContext context ) {
        super( context );
    }


}
