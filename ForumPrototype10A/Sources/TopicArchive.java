//
// TopicArchive.java: Class file for WO Component 'TopicArchive'
// Project ForumPrototype10A
//
// Created by ravi on Tue Mar 12 2002
//

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEnterpriseObject;

public class TopicArchive extends FO2PDFSerializer {
    /** @TypeInfo Post */
    protected EOEnterpriseObject post;
    /** @TypeInfo Topic */
    protected EOEnterpriseObject topic;
    
    public TopicArchive(WOContext context) {
        super(context);
    }

    /*
     * request/response
     */
    public void appendToResponse(WOResponse response, WOContext context) {
        response.setHeader("attachment;filename=\"" + "Archive.pdf" + "\"", "Content-Disposition");

        // generate PDF response
        super.appendToResponse(response, context);
    }

    public String message() {
        String message = (String) post.valueForKey("message");
        return message.trim();
    }    
}
