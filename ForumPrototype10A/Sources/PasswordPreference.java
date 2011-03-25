//
// PasswordPreference.java: Class file for WO Component 'PasswordPreference'
// Project ForumPrototype5E
//
// Created by ravi on Wed Oct 31 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class PasswordPreference extends WOComponent {
    protected String oldPassword;
    protected String password1;
    protected String password2;
    protected String _msg;

    public PasswordPreference(WOContext context) {
        super(context);
                
        // revert changes
        session().defaultEditingContext().revert();
    }

    /*
    * actions
    */
    public void change() {
        String _oldPassword = (String) valueForKeyPath("session.user.password");
        
        // check the passwords match
        if (_oldPassword.equals(oldPassword)) {
            if (password1.equals(password2)) {
                takeValueForKeyPath(password1, "session.user.password");
                session().defaultEditingContext().saveChanges();
                _msg = "Your password has been changed";
            } else _msg = "New passwords do not match";
        } else _msg = "The Current password is incorrect";
    }
}