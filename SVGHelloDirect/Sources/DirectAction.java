//
// DirectAction.java
// Project HelloDirect
//
// Created by ravi on Wed Aug 08 2001
//

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;

public class DirectAction extends WODirectAction {

    public DirectAction(WORequest aRequest) {
        super(aRequest);
    }

    public WOActionResults defaultAction() {
	WOComponent nextPage = pageWithName("Main");
	String username = request().stringFormValueForKey("username");
	
	// set values
	nextPage.takeValueForKey(username, "username");
	
	return nextPage;
    }
    
    public WOActionResults greetingAction() {
	WOComponent nextPage = pageWithName("Greeting");
	String username = request().stringFormValueForKey("username");
	String style = request().stringFormValueForKey("style");

	// set values
	nextPage.takeValueForKey(username, "username");
	nextPage.takeValueForKey(style, "style");

	return nextPage;
    }
}