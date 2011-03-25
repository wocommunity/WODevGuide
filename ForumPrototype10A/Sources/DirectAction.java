//
// DirectAction.java
// Project UserForumTest
//
// Created by ravi on Wed Oct 03 2001
//

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSNumberFormatter;

public class DirectAction extends WODirectAction {

    public DirectAction(WORequest aRequest) {
        super(aRequest);
    }

    /*
    * actions
    */ 
    public WOActionResults defaultAction() {
        return pageWithName("Main");
    }
    
    public WOActionResults topicsAction() {
	WOComponent nextPage = pageWithName("ForumTopics");
	Number forumID = request().numericFormValueForKey("forumID", new NSNumberFormatter());
	EOEnterpriseObject forum = EOUtilities.objectWithPrimaryKeyValue(WOApplication.application().sharedEditingContext(), "Forum", forumID);
	Number index = request().numericFormValueForKey("displayBatchIndex", new NSNumberFormatter());

	// set variables
	nextPage.takeValueForKeyPath(forum, "topicsDisplayGroup.masterObject");
	if (index != null) nextPage.takeValueForKeyPath(index, "topicsDisplayGroup.currentBatchIndex");

	return nextPage;
    }
    
    public WOActionResults postsAction() {
	WOComponent nextPage = pageWithName("TopicPosts");
	Number topicID = request().numericFormValueForKey("topicID", new NSNumberFormatter());
	EOEnterpriseObject topic = EOUtilities.objectWithPrimaryKeyValue(WOApplication.application().sharedEditingContext(), "Topic", topicID);
	Number index = request().numericFormValueForKey("displayBatchIndex", new NSNumberFormatter());

	// set variables
	nextPage.takeValueForKeyPath(topic, "postsDisplayGroup.masterObject");
	if (index != null) nextPage.takeValueForKeyPath(index, "postsDisplayGroup.currentBatchIndex");

	return nextPage;
    }
}