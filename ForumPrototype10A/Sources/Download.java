//
// Download.java
// Project ForumPrototype6A
//
// Created by ravi on Mon Nov 05 2001
//

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResourceManager;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSNumberFormatter;

public class Download extends WODirectAction {

    public Download(WORequest aRequest) {
        super(aRequest);
    }
    
    /*
    * actions
    */
    public WOActionResults fileAction() {
        Number postID = request().numericFormValueForKey("postID", new NSNumberFormatter());
        
        if (postID != null) {
            EOEditingContext editingContext = new EOEditingContext();
            
            // lock
            editingContext.lock();
            
            // fetch attachment + create response
            EOEnterpriseObject post = EOUtilities.objectWithPrimaryKeyValue(editingContext, "Post", postID);
            NSData data = (NSData) post.valueForKey("attachment");
            WOResponse response = new WOResponse();
            String filePath = (String) post.valueForKey("filePath");
            WOResourceManager resourceManager = WOApplication.application().resourceManager();
            String contentType = resourceManager.contentTypeForResourceNamed(filePath);
            
            // unlock
            editingContext.unlock();
            
            // set the content
            response.appendContentData(data);
            
            // set content type
            response.setHeader(contentType, "Content-Type");
            
            return response;
        } return null;
    }
        
    /*
    * request handling
    */
    public WOActionResults performActionNamed(String anActionName) {
        // all actions dowload files
        return fileAction();
    }
}
