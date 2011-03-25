/*
 HomePage.java
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
 This class and the associated component is the "start" page for the application.
 This is made possible by setting the default request handler to the directAction
 handler and setting the defaultAction() to return this page (rather than "Main").
 */
 
public class HomePage extends WOComponent {

    /**
     * Constructor
     */
     
    public HomePage( WOContext context ) {
        super( context );
    }

}
