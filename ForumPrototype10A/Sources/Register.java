//
// Register.java
// Project ForumPrototype5H
//
// Created by ravi on Wed Oct 31 2001
//

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;

public class Register extends WODirectAction {
    protected static NSArray keys = new NSArray(new String[]{"username", "firstName", "lastName", "email", "password1", "password2"});
    protected String username;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password1;
    protected String password2;

    public Register(WORequest aRequest) {
        super(aRequest);
        takeFormValuesForKeyArray(keys);
    }
    
    /*
    * actions
    */
    public WOActionResults defaultAction() {
        return pageWithName("Registration");
    }
    
    public WOActionResults userAction() {        
        // check that the user has typed something in
        if (username != null) {
            EOEditingContext editingContext = new EOEditingContext();
            editingContext.setSharedEditingContext(null);
            NSArray results = EOUtilities.rawRowsMatchingKeyAndValue(editingContext, "User", "name", username);
    
            // check that the username isn't already taken
            if (results.count() == 0) {
                // check that passwords match
                if (password1 != null && password2 != null && password1.equals(password2)) {
                    // lock ec
                    editingContext.lock();
                    
                    // create user
                    EOEnterpriseObject user = EOUtilities.createAndInsertInstance(editingContext, "NormalUser");
    
                    // set values
                    user.takeValueForKey(username, "name");
                    user.takeValueForKey(password1, "password");
                    user.takeValueForKey(firstName, "firstName");
                    user.takeValueForKey(lastName, "lastName");
                    user.takeValueForKey(email, "email");
    
                    // save changes
                    editingContext.saveChanges();
                    
                    // unlock ec
                    editingContext.unlock();
                    
                    return pageWithName("Login");
                } else return passwordsDontMatchAction();
            } else return userExistsAction();
        } else return defaultAction();
    }
    
    /*
    * private actions
    */
    private WOActionResults userExistsAction() {
        WOComponent nextPage = pageWithName("Registration");
        
        // pass values
        nextPage.takeValueForKey("A user already exists with that username.", "msg");
        nextPage.takeValueForKey(firstName, "firstName");
        nextPage.takeValueForKey(lastName, "lastName");
        nextPage.takeValueForKey(email, "email");

        return nextPage;
    }
    
    private WOActionResults passwordsDontMatchAction() {
        WOComponent nextPage = pageWithName("Registration");

        // pass values
        nextPage.takeValueForKey("The passwords don't match.", "msg");
        nextPage.takeValueForKey(username, "username");
        nextPage.takeValueForKey(firstName, "firstName");
        nextPage.takeValueForKey(lastName, "lastName");
        nextPage.takeValueForKey(email, "email");

        return nextPage;
    }
}