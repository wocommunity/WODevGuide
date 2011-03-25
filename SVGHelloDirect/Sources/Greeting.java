//
// Greeting.java: Class file for WO Component 'Greeting'
// Project Hello
//
// Created by ravi on Mon Jul 16 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;

public class Greeting extends WOComponent {
    protected String username;
    protected String style;

    public Greeting(WOContext context) {
        super(context);
    }
    
    /*
    * request/response
    */
    public void appendToResponse(WOResponse response, WOContext context) {
	super.appendToResponse(response, context);

	// set the header
	response.setHeader("image/svg-xml", "Content-Type");
    }
    
    /*
    * accessors
    */
    public String componentName() {
	return "SVG" + style + "Text";
    }
}