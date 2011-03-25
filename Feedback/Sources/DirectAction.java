//
// DirectAction.java
// Project Feedback
//
// Created by ravi on Fri Aug 10 2001
//

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WOMailDelivery;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;

public class DirectAction extends WODirectAction {
	protected static NSArray to = new NSArray("rmendis@planet.nl");

	public DirectAction(WORequest aRequest) {
		super(aRequest);
	}

	public WOActionResults defaultAction() {
		return pageWithName("Main");
	}

	public WOActionResults feedbackAction() {
		String from = (String)request().formValueForKey("from");
		String subject = (String)request().formValueForKey("subject");
		String message = (String)request().formValueForKey("contents");
		WOMailDelivery sharedInstance = WOMailDelivery.sharedInstance();

		// send email
		sharedInstance.composePlainTextEmail(from, to, null, subject, message, true);

		// log
		logString("DirectAction: email sent from: " + from);

		return pageWithName("ThankYou");
	}
}