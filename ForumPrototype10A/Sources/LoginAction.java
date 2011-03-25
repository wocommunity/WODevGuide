//
// LoginAction.java
// Project ForumPrototype5A
//
// Created by ravi on Sun Oct 28 2001
//

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;

public class LoginAction extends WODirectAction {

    public LoginAction(WORequest aRequest) {
        super(aRequest);
    }
    
    /*
    * actions
    */
    public WOActionResults defaultAction() {
        WOComponent nextPage = pageWithName("Main");
        nextPage.takeValueForKey(new Integer(1), "authorize");
        return nextPage;
    }
}