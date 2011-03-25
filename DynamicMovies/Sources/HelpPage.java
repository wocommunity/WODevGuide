/*
 HelpPage.java
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
 This class and the associated component displays help information for 
 the user, with the help divided into the same sections as the toolbar.
 This is a page of basically static information.
 */
 
public class HelpPage extends WOComponent {

    /**
     * Constructor
     */
     
    public HelpPage( WOContext context ) {
        super( context );
    }

}
