//
// WXTextField.java: Class file for WO Component 'WXTextField'
// Project WXTextFieldTest
//
// Created by ravi on Mon Aug 20 2001
//

import java.text.ParseException;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSNumberFormatter;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSTimestampFormatter;

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
	 * stateless
	 */
	public boolean isStateless() {
		return true;
	}

	/*
	 * request/response
	 */
	public void takeValuesFromRequest(WORequest request, WOContext context) {
		super.takeValuesFromRequest(request, context);

		// get the value from the request
		String value = (String)request.formValueForKey(name());

		// push the value to the parent
		try {
			setValue(value);
		} catch (ParseException exception) {}
	}

	/*
	 * accessors
	 */
	public String name() {
		String name = (String) valueForBinding("name");
		return (hasBinding("name")) ? name:context().elementID();
	}

	public String value() {
		Object value = valueForBinding("value");

		// format the value
		if (value instanceof Number && hasBinding("numberFormat")) {
			String pattern = (String) valueForBinding("numberFormat");
			NSNumberFormatter formatter = new NSNumberFormatter(pattern);

			return formatter.stringForObjectValue(value);
		}
		else if (value instanceof NSTimestamp && hasBinding("dateFormat")) {
			String pattern = (String) valueForBinding("dateFormat");
			NSTimestampFormatter formatter = new NSTimestampFormatter(pattern);

			return formatter.format(value);
		}
		else return value.toString();
	}

	public void setValue(String value) throws ParseException {
		if (hasBinding("dateFormat")) {
			String pattern = (String) valueForBinding("dateFormat");
			NSTimestampFormatter formatter = new NSTimestampFormatter(pattern);
			NSTimestamp timestamp = (NSTimestamp) formatter.parseObject(value);

			// set the value
			setValueForBinding(timestamp, "value");
		} else if (hasBinding("numberFormat")) {
			String pattern = (String) valueForBinding("numberFormat");
			NSNumberFormatter formatter = new NSNumberFormatter(pattern);
			Object number = formatter.objectValueForString(value);

			// set the value
			setValueForBinding(number, "value");
		} else setValueForBinding(value, "value");
	}
}