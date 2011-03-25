//
// Session.java
// Project ForumPrototype2
//
// Created by ravi on Sat Oct 13 2001
//

import com.webobjects.appserver.WOSession;
import com.webobjects.eocontrol.EOEnterpriseObject;

public class Session extends WOSession {
    /** @TypeInfo User */
    protected EOEnterpriseObject user;

    public Session() {
        super();
        
        /* ** Put your per-session initialization code here ** */
    }

    /*
     * workaround for inablility to login
     * to events page
     */
    public void validateEventsLogin(String password, String username) {
    }
}