/*
 VotingPage.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableDictionary;


/*
 This class and the associated component creates a page to allow the
 user to vote on how they like a movie.  Using the pop-up  list of information,
 this page takes in the vote information and passes it to a DirectAction
 which computes and saves the vote.
 */
 
public class VotingPage extends MovieComponent {

    // Instance variable for the new vote value
    public int newVote;
    
    // Instance variable for the query information
    public NSMutableDictionary queryDict;


    /**
     * Constructor
     */
     
    public VotingPage( WOContext context ) {
        super( context );
    }


    /**
     * Method to return the value of the new vote - used to populate
     * the textfield with the value for the user.
     */
     
    public int getNewVote() {
        return newVote;
    }

}
