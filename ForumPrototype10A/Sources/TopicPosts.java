//
// TopicPosts.java: Class file for WO Component 'TopicPosts'
// Project ForumPrototype3B
//
// Created by ravi on Sun Oct 14 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSDictionary;

public class TopicPosts extends WOComponent {
    protected WODisplayGroup postsDisplayGroup;
    protected Post post;
    protected int index;

    public TopicPosts(WOContext context) {
        super(context);
    }
    
    /*
    * accessors
    */
    public NSDictionary topicKey() {
	EOEnterpriseObject topic = (EOEnterpriseObject) postsDisplayGroup.masterObject();
	return EOUtilities.primaryKeyForObject(topic.editingContext(), topic);
    }
    
    public Integer forumID() {
    	EOEnterpriseObject forum = (EOEnterpriseObject) valueForKeyPath("postsDisplayGroup.masterObject.forum");
	NSDictionary primaryKey = EOUtilities.primaryKeyForObject(forum.editingContext(), forum);
        
        return (Integer) primaryKey.valueForKey("forumID");
    }
    
    public Integer postID() {
        NSDictionary primaryKey = EOUtilities.primaryKeyForObject(post.editingContext(), post);

        return (Integer) primaryKey.valueForKey("postID");
    }
    
    public boolean hasSession() {
        String sessionID = context().request().cookieValueForKey("wosid");
        return (super.hasSession() || sessionID != null);
    }
    
    public String mailTo() {
        String email = (String) valueForKeyPath("post.user.email");
        return "mailto:" + email;
    }
    
    /*
    * actions
    */
    public WOComponent reply() {
        WOComponent nextPage = pageWithName("Reply");
        EOEnterpriseObject _topic = (EOEnterpriseObject) postsDisplayGroup.masterObject();
        EOEnterpriseObject topic = EOUtilities.localInstanceOfObject(session().defaultEditingContext(), _topic);

        // set topic
        nextPage.takeValueForKeyPath(topic, "postsDisplayGroup.masterObject");

        return nextPage;
    }
}