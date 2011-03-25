//
// WOCollapsibleList.java: Class file for WO Component 'WOCollapsibleList'
// Project WOCollapsibleListTest
//
// Created by ravi on Mon Aug 06 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class WOCollapsibleList extends WOComponent {
    protected boolean condition;
    protected String label;

    public WOCollapsibleList(WOContext context) {
        super(context);
    }
    
    /*
    * actions
    */
    public void toggle() {
        condition = !condition;
    }
}