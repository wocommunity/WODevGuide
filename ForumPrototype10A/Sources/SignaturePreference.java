//
// SignaturePreference.java: Class file for WO Component 'SignaturePreference'
// Project ForumPrototype5E
//
// Created by ravi on Wed Oct 31 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class SignaturePreference extends WOComponent {
    protected String _msg;

    public SignaturePreference(WOContext context) {
        super(context);
                
        // revert changes
        session().defaultEditingContext().revert();
    }

}
