//
// DirectAction.java
// Project SOAPHelloWorld
//
// Created by ravi on Sat Feb 09 2002
//

import org.w3c.dom.Document;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSLog;

public class DirectAction extends WODirectAction {

    public DirectAction(WORequest aRequest) {
        super(aRequest);
    }

    public WOActionResults defaultAction() {
        WOComponent nextPage = pageWithName("Main");
        Document document = request().contentAsDOMDocument();
        String myName = document.getElementsByTagName("myname").item(0).getFirstChild().getNodeValue();
        
        // set the name
        nextPage.takeValueForKey(myName, "myName");

        // debug
        NSLog.debug.appendln("DirectAction: SOAP request: " + request().contentString());

        return nextPage;
    }
}