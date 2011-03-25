//
// WOToggle.java: Class file for WO Component 'WOToggle'
// Project WOToggleTest
//
// Created by ravi on Mon Aug 06 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class WOToggle extends WOComponent {
    protected boolean condition = false;

    public WOToggle(WOContext context) {
        super(context);
    }

    /*
    * actions
    */
    public void toggle() {
        condition = !condition;
    }

}
