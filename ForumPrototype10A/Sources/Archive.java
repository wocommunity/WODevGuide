//
// Archive.java
// Project ForumPrototype10A
//
// Created by ravi on Tue Mar 12 2002
//

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSNumberFormatter;

public class Archive extends WODirectAction {

    public Archive(WORequest aRequest) {
        super(aRequest);
    }

    public WOActionResults defaultAction() {
        WOComponent nextPage = pageWithName("TopicArchive");
        Number topicID = request().numericFormValueForKey("topicID", new NSNumberFormatter());
        EOEditingContext editingContext = new EOEditingContext();
        EOEnterpriseObject topic = EOUtilities.objectWithPrimaryKeyValue(editingContext, "Topic", topicID);

        // set variables
        nextPage.takeValueForKeyPath(topic, "topic");

        return nextPage;
    }
    
}
