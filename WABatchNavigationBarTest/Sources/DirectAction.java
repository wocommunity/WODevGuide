//
// DirectAction.java
// Project WABatchNavigationBarTest
//
// Created by ravi on Mon Oct 15 2001
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
		return pageWithName("Main");
	}

	public WOActionResults mainAction() {
		WOComponent nextPage = pageWithName("Main");
		String index = (String)request().formValueForKey("displayBatchIndex");

		// set values
		nextPage.takeValueForKeyPath(new Integer(index), "movieDisplayGroup.currentBatchIndex");

		return nextPage;
	}
}