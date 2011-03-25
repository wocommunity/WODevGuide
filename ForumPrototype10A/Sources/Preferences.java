//
// Preferences.java: Class file for WO Component 'Preferences'
// Project ForumPrototype5E
//
// Created by ravi on Wed Oct 31 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class Preferences extends WOComponent {
    protected NSArray tabs = new NSArray(new String[]{"Password", "Signature"});
    protected String selectedTab;
    protected String _msg;

    public Preferences(WOContext context) {
        super(context);
    }
    
    /*
    * accessors
    */
    public String componentName() {
        return selectedTab() + "Preference";
    }
    
    public String selectedTab() {
        return (selectedTab != null) ? selectedTab: (String) tabs.objectAtIndex(0); 
    }
    
    public String onLoad() {
        String onLoad = "alert('" + _msg + "');";
        return (_msg != null) ? onLoad:null;
    }
}
