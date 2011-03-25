//
// WOSVG.java: Class file for WO Component 'WOSVG'
// Project eCards
//
// Created by ravi on Thu Aug 30 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSDictionary;

public class WOSVG extends WOComponent {

    public WOSVG(WOContext context) {
        super(context);
    }
    
    /*
    * non synching variable
    */
    public boolean synchronizesVariablesWithBindings() {
	return false;
    }
    
    /*
    * accessors
    */
    public String src() {
	String directActionName = (String) valueForBinding("directActionName");
	NSDictionary queryDictionary = (NSDictionary) valueForBinding("queryDictionary");
	
        return context().directActionURLForActionNamed(directActionName, queryDictionary);
    }
}