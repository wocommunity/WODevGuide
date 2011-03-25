//
// ForumTopics.java: Class file for WO Component 'ForumTopics'
// Project ForumPrototype2
//
// Created by ravi on Sat Oct 13 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSDictionary;

public class ForumTopics extends WOComponent {
    protected WODisplayGroup topicsDisplayGroup;
    /** @TypeInfo Topic */
    protected EOEnterpriseObject topic;
    public ForumTopics(WOContext context) {
        super(context);
    }

    /*
    * accessors
    */    
    public Integer topicID() {
    	NSDictionary primaryKey = EOUtilities.primaryKeyForObject(topic.editingContext(), topic);
	return (Integer) primaryKey.valueForKey("topicID");
    }
    
    public NSDictionary forumKey() {
    	EOEnterpriseObject forum = (EOEnterpriseObject) topicsDisplayGroup.masterObject();
	return EOUtilities.primaryKeyForObject(forum.editingContext(), forum);	
    }

    public boolean hasSession() {
        String sessionID = context().request().cookieValueForKey("wosid");
        return (super.hasSession() || sessionID != null);
    }
    
    /*
    * actions
    */
    public WOComponent startTopic() {
        WOComponent nextPage = pageWithName("StartTopic");
        EOEnterpriseObject _forum = (EOEnterpriseObject) topicsDisplayGroup.masterObject();
        EOEnterpriseObject forum = EOUtilities.localInstanceOfObject(session().defaultEditingContext(), _forum);

	// set the master object
	nextPage.takeValueForKeyPath(forum, "topicsDisplayGroup.masterObject");

        return nextPage;
    }
}