//
// WXTextField.java: Class file for WO Component 'WXTextField'
// Project XHelloDirect
//
// Created by ravi on Sat Aug 18 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;

public class WXTextField extends WOComponent {

	public WXTextField(WOContext context) {
		super(context);
	}

	/*
	 * non synchronizing component
	 */
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	/*
	 * accessors
	 */
	public String name() {
		String name = (String) valueForBinding("name");
		return (name != null) ? name:context().elementID();
	}

	/*
	 * request/response
	 */
	public void takeValuesFromRequest(WORequest request, WOContext context) {
		super.takeValuesFromRequest(request, context);

		if (context.elementID().equals(context.senderID())) {
			Object value = request.formValueForKey(name());

			// push the textfield value
			setValueForBinding(value, name());
		}

		// debug
		WOComponent.debugString("WXTextField: elementID: " + context().elementID());
		WOComponent.debugString("WXTextField: senderID: " + context().senderID());
	}
}