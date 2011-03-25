//
// RecipientEmail.java: Class file for WO Component 'RecipientEmail'
// Project eCards
//
// Created by ravi on Wed Aug 29 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class RecipientEmail extends WOComponent {
    protected String from;
    protected String subject;
    protected String message;
    protected String image;

    public RecipientEmail(WOContext context) {
        super(context);
    }

}
