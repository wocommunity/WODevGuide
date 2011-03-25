//
// DirectAction.java
// Project CrazyEightsTest
//
// Created by ravi on Tue Jan 22 2002
//

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;

public class DirectAction extends WODirectAction {

    public DirectAction(WORequest aRequest) {
        super(aRequest);
    }

    public WOActionResults defaultAction() {
        return pageWithName("Main");
    }

}
