//
// SearchBar.java: Class file for WO Component 'SearchBar'
// Project ForumPrototype7D2
//
// Created by ravi on Sun Nov 11 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class SearchBar extends WOComponent {

    public SearchBar(WOContext context) {
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
