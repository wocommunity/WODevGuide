//
// SearchAction.java
// Project ForumPrototype7C
//
// Created by ravi on Sat Nov 10 2001
//

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSNumberFormatter;

public class SearchAction extends WODirectAction {
    protected static NSArray keys = new NSArray(new String[]{"message", "topic", "username"});
    protected String message;
    protected String topic;
    protected String username;

    public SearchAction(WORequest aRequest) {
        super(aRequest);
        
        // take values from the request
        takeFormValuesForKeyArray(keys);
        
        // append wildcards
        if (message != null) {
            if (!message.startsWith("*")) message = "*" + message;
            if (!message.endsWith("*")) message = message + "*";
        } if (topic != null) {
            if (!topic.startsWith("*")) topic = "*" + topic;
            if (!topic.endsWith("*")) topic = topic + "*";
        } if (username != null) {
            if (!username.startsWith("*")) username = "*" + username;
            if (!username.endsWith("*")) username = username + "*";
        }
    }

    /*
    * actions
    */ 
    public WOActionResults defaultAction() {
        return pageWithName("Search");
    }
    
    public WOActionResults resultsAction() {
        SearchResults nextPage = (SearchResults) pageWithName("SearchResults");
	Number index = request().numericFormValueForKey("displayBatchIndex", new NSNumberFormatter());
        
        // set query bindings
	nextPage.takeValueForKeyPath(message, "postsDisplayGroup.queryBindings.message");
        nextPage.takeValueForKeyPath(topic, "postsDisplayGroup.queryBindings.topic");
        nextPage.takeValueForKeyPath(username, "postsDisplayGroup.queryBindings.username");
        
        // fetch
        nextPage.fetch();
                
        // set the batch index
        if (index != null) nextPage.takeValueForKeyPath(index, "postsDisplayGroup.currentBatchIndex");

        return nextPage;
    }
}