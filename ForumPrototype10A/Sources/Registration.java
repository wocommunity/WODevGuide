//
// Registration.java: Class file for WO Component 'Registration'
// Project ForumPrototype5H
//
// Created by ravi on Wed Oct 31 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class Registration extends WOComponent {
    protected String username;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String _msg;

    public Registration(WOContext context) {
        super(context);
    }

    /*
    * accessors
    */
    public String onLoad() {
        String onLoad = "alert('" + _msg + "');";
        return (_msg != null) ? onLoad:null;
    }
}