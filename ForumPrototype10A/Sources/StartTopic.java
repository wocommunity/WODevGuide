//
// StartTopic.java: Class file for WO Component 'StartTopic'
// Project ForumPrototype5C2
//
// Created by ravi on Tue Oct 30 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSValidation;

public class StartTopic extends WOComponent {
    protected WODisplayGroup topicsDisplayGroup;
    protected WODisplayGroup postsDisplayGroup;
    protected boolean useSignature;
    protected String _msg;
   
    public StartTopic(WOContext context) {
        super(context);
                
        // revert changes
        session().defaultEditingContext().revert();
    }
    
    /*
    * accessors
    */
    /** @TypeInfo Topic */
    public EOEnterpriseObject topic() {
        EOEnterpriseObject topic = (EOEnterpriseObject) topicsDisplayGroup.selectedObject();
        
        // create a new topic
        if (topic == null) {
            // insert 
            topicsDisplayGroup.insert();
            
            // set it as master object in postsDisplayGroup
            topic = (EOEnterpriseObject) topicsDisplayGroup.selectedObject();
            postsDisplayGroup.setMasterObject(topic);
        } return topic;
    }

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
        EOEnterpriseObject forum = (EOEnterpriseObject) valueForKeyPath("topic.forum");
        NSDictionary primaryKey = EOUtilities.primaryKeyForObject(forum.editingContext(), forum);
        
        return (Integer) primaryKey.valueForKey("forumID");
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
        
        // return the next page
        WOComponent nextPage = pageWithName("ForumTopics");
        
        // set the topic
        nextPage.takeValueForKeyPath(topicsDisplayGroup.masterObject(), "topicsDisplayGroup.masterObject");
        
        return nextPage;
    }
    
    public WOComponent cancel() {
        session().defaultEditingContext().revert();
        
        // return the next page
        WOComponent nextPage = pageWithName("ForumTopics");
        
        // set the topic
        nextPage.takeValueForKeyPath(topicsDisplayGroup.masterObject(), "topicsDisplayGroup.masterObject");
        
        return nextPage;
    }
}