/*
 ErrorPage.java
 [ThinkMovies Project]
 
 Copyright (c) 1998-2001, Apple Computer, Inc.
 All rights reserved.

 You may freely copy, distribute and reuse the code in this example.
 Apple disclaims any warranty of any kind, expressed or implied,
 as to its fitness for any particular use.
 */

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;


/*
 This class and the associated component creates an error page for handling
 and problems which may occur in the application.  This page displays a 
 simple error message which is passed into the page when something goes
 awry.
 */
 
public class ErrorPage extends WOComponent {

    // Instance variable for the error message
    protected String message;


    /**
     * Constructor
     */
     
    public ErrorPage( WOContext context ) {
        super( context );
    }


    /**
     * Accessor method to return the value of the error message
     */
     
    public String message() {
        return message;
    }


    /**
     * Accessor method to set the value of the error message
     */
     
    public void setMessage( String aMessage ) {
        message = aMessage;
    }

}
