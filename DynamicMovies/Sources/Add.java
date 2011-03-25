/*
 Add.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;


/*
 This class is used to extend the directAction class and add an action
 to jump to the page to add movies ("AddMoviePage"), but setting the proper
 HTTP header ("pragma") to force the page to be updated if the client
 backtracks to it.
 */
 
public class Add extends WODirectAction {

    /**
     * Constructor for the DirectAction class.  This constructor is 
     * required in Java for all WODirectAction subclasses.
     */

    public Add(WORequest aRequest) {
        super(aRequest);
    }


    /**
     * Method to return the page to add new movies with special handling
     * to make sure the page is updated if backtracked to.
     */

    public WOResponse MovieAction() {

        WOResponse aResponse = null;
        WOComponent aPage = pageWithName("AddMoviePage");
        aResponse = aPage.generateResponse();
        aResponse.setHeader("no-cache", "pragma");
        return aResponse;
    }
}