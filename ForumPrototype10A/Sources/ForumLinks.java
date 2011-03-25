//
// ForumLinks.java: Class file for WO Component 'ForumLinks'
// Project ForumPrototype7D2
//
// Created by ravi on Sun Nov 11 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSDictionary;

public class ForumLinks extends WOComponent {
    /** @TypeInfo Forum */
    protected EOEnterpriseObject forum;

    public ForumLinks(WOContext context) {
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

    /*
    * accessors
    */
    public Integer forumID() {
	NSDictionary primaryKey = EOUtilities.primaryKeyForObject(forum.editingContext(), forum);
	return (Integer) primaryKey.valueForKey("forumID");
    }
}