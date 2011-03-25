//
// WOArea.java: Class file for WO Component 'WOArea'
// Project WOMappedRolloverTest
//
// Created by ravi on Fri Aug 03 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class WOArea extends WOComponent {

    public WOArea(WOContext context) {
        super(context);
    }
    
    /*
    * non synching component
    */
    public boolean synchronizesVariablesWithBindings() {
	return false;
    }

    /*
    * stateless component
    */
    public boolean isStateless() {
	return true;
    }
    
    /*
    * accesors
    */
    public String href() {
	String directActionName = (String) valueForBinding("directActionName");
	return context().directActionURLForActionNamed(directActionName, null);
    }
}