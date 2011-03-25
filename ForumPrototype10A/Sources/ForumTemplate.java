//
// ForumTemplate.java: Class file for WO Component 'ForumTemplate'
// Project ForumPrototype7D
//
// Created by ravi on Sun Nov 11 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class ForumTemplate extends WOComponent {

    public ForumTemplate(WOContext context) {
        super(context);
    }

    /*
    * non-synchronizing component
    */
    public boolean synchronizesVariablesWithBindings() {
        return false;
    }
    
    /*
    * stateless
    */
    public boolean isStateless() {
        return true;
    }
}