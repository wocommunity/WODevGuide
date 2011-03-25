//
// SearchResults.java: Class file for WO Component 'SearchResults'
// Project ForumPrototype7B
//
// Created by ravi on Fri Nov 09 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.foundation.NSDictionary;

public class SearchResults extends WOComponent {
    protected WODisplayGroup postsDisplayGroup;
    /** @TypeInfo Post */
    protected NSDictionary post;

    public SearchResults(WOContext context) {
        super(context);
    }
    
    /*
    * actions
    */    
    public void fetch() {
        postsDisplayGroup.qualifyDataSource();
    }
}