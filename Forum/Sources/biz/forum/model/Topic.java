// Topic.java
// Created on Sun Jan 27 23:11:54 Etc/GMT 2002 by Apple EOModeler Version 5.0

package biz.forum.model;

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

public class Topic extends EOGenericRecord {

    /*
    * derived attribute accessors
    */
    public Number postsCount() {
        Number postsCount = (Number) storedValueForKey("postsCount");
        return (postsCount != null) ? postsCount: (Number) valueForKeyPath("posts.count"); 
    }

    public NSTimestamp timeOfLastPost() {
        NSTimestamp timeOfLastPost = (NSTimestamp) storedValueForKey("timeOfLastPost");
        return (timeOfLastPost != null) ? timeOfLastPost: (NSTimestamp) valueForKeyPath("posts.@max.timestamp"); 
    }

    public String lastPostMadeBy() {
        String lastPostMadeBy = (String) storedValueForKey("lastPostMadeBy");
        if (lastPostMadeBy == null) {
            NSArray posts = (NSArray) valueForKey("posts");
            EOEnterpriseObject lastPost = (EOEnterpriseObject) posts.lastObject();
            
            lastPostMadeBy = (String) lastPost.valueForKeyPath("user.name");
        } return lastPostMadeBy;
    }

    public String starter() {
        String starter = (String) storedValueForKey("starter");
        if (starter == null) {
            NSArray posts = (NSArray) valueForKey("posts");
            EOEnterpriseObject firstPost = (EOEnterpriseObject) posts.objectAtIndex(0);
            
            starter = (String) firstPost.valueForKeyPath("user.name");
        } return starter;
    }
}