//
// WXHyperlink.java: Class file for WO Component 'WXHyperlink'
// Project WXHyperlinkTest
//
// Created by ravi on Tue Aug 21 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSDictionary;

public class WXHyperlink extends WOComponent {

	public WXHyperlink(WOContext context) {
		super(context);
	}

	/*
	 * non sychronized component
	 */
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	/*
	 * accessors
	 */
	public String href() {
		if (hasBinding("href")) 
			return (String) valueForBinding("href");
		else if (hasBinding("action") || hasBinding("pageName")) 
			return (String) context().componentActionURL();
		else if (hasBinding("directActionName")) {
			String directActionName = (String) valueForBinding("directActionName");
			NSDictionary queryDictionary = (NSDictionary) valueForBinding("queryDictionary");

			return context().directActionURLForActionNamed(directActionName, queryDictionary);
		} else return null;
	}

	/*
	 * request/response
	 */
	public WOComponent invokeAction()  {	
		if (hasBinding("action")) {
			return (WOComponent) valueForBinding("action");
		} else if (hasBinding( "pageName") ) {
			String pageName = (String) valueForBinding("pageName");
			return pageWithName(pageName);
		} else return null;
	}
}