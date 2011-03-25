//
// SenderEmail.java: Class file for WO Component 'SenderEmail'
// Project eCards
//
// Created by ravi on Wed Aug 29 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class SenderEmail extends WOComponent {
    protected String to;
    protected String subject;
    protected String message;
    protected String image;

    public SenderEmail(WOContext context) {
        super(context);
    }
}