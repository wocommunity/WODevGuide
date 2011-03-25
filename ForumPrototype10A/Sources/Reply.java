//
// Reply.java: Class file for WO Component 'Reply'
// Project ForumPrototype5C
//
// Created by ravi on Mon Oct 29 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSValidation;

public class Reply extends WOComponent {
    protected WODisplayGroup postsDisplayGroup;
    protected boolean useSignature;
    protected String _msg;
    
    public Reply(WOContext context) {
        super(context);
        
        // revert changes
        session().defaultEditingContext().revert();
    }
    
    /*
    * accessors
    */
    /** @TypeInfo Post */
    public EOEnterpriseObject post() {
        EOEnterpriseObject post = (EOEnterpriseObject) postsDisplayGroup.selectedObject();

        // create a new post on demand
        if (post == null) {
            EOEnterpriseObject user = (EOEnterpriseObject) valueForKeyPath("session.user");
                
            // insert a new post
            postsDisplayGroup.insert();
            
            // assign the user
            post = (EOEnterpriseObject) postsDisplayGroup.selectedObject();
            post.addObjectToBothSidesOfRelationshipWithKey(user, "user");
        } return post;
    }
    
    public Number forumID() {
        EOEnterpriseObject forum = (EOEnterpriseObject) valueForKeyPath("post.topic.forum");
        NSDictionary primaryKey = EOUtilities.primaryKeyForObject(forum.editingContext(), forum);
        
        return (Integer) primaryKey.valueForKey("forumID");
    }
    
    public Number topicID() {
        EOEnterpriseObject topic = (EOEnterpriseObject) valueForKeyPath("post.topic");
        NSDictionary primaryKey = EOUtilities.primaryKeyForObject(topic.editingContext(), topic);
        
        return (Integer) primaryKey.valueForKey("topicID");
    }
    
    public String onLoad() {
        String onLoad = "alert('" + _msg + "');";
        return (_msg != null) ? onLoad:null;
    }
    
    /*
    * actions
    */
    public WOComponent save() {        
        // append signature
        if (useSignature) {
            String message = (String) post().valueForKey("message");
            String signature = (String) valueForKeyPath("session.user.signature");
            post().takeValueForKey(message + "<p>" + signature, "message");
        }
        
        // try to save changes
        try { session().defaultEditingContext().saveChanges(); }
        catch (NSValidation.ValidationException exception) {
            _msg = exception.getMessage();
            return this;
        }

        // return the topics page
        WOComponent nextPage = pageWithName("TopicPosts");
        
        // set the topic
        nextPage.takeValueForKeyPath(postsDisplayGroup.masterObject(), "postsDisplayGroup.masterObject");
        
        return nextPage;
    }
    
    public WOComponent cancel() {
        WOComponent nextPage = pageWithName("TopicPosts");
                
        // discard save changes
        session().defaultEditingContext().revert();

        // set the topic
        nextPage.takeValueForKeyPath(postsDisplayGroup.masterObject(), "postsDisplayGroup.masterObject");
        
        return nextPage;
    }
}