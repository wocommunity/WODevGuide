//
// WXImage.java: Class file for WO Component 'WXImage'
// Project HelloDirectX
//
// Created by ravi on Fri Aug 17 2001
//

import java.util.Enumeration;

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOAssociation;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODynamicElement;
import com.webobjects.appserver.WOElement;
import com.webobjects.appserver.WOResourceManager;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

public class WXImage extends WODynamicElement {
	private NSMutableDictionary associations;
	private WOAssociation srcAssociation;
	private WOAssociation filenameAssociation;
	private WOAssociation frameworkAssociation;

	/*
	 * constructors
	 */
	public WXImage(String _name, NSDictionary _associations, WOElement _element) {
		super(_name, _associations, _element);

		// set the associations
		associations = new NSMutableDictionary(_associations);

		// remove the public bindings/associations
		filenameAssociation = (WOAssociation) associations.removeObjectForKey("filename");
		frameworkAssociation = (WOAssociation) associations.removeObjectForKey("framework");
		srcAssociation = (WOAssociation) associations.removeObjectForKey("src");
	}

	/*
	 * request/response
	 */
	public void appendToResponse(WOResponse response, WOContext context) {
		WOComponent component = context.component();
		String src = null;

		// src
		if (srcAssociation != null)
			src = (String) srcAssociation.valueInComponent(component);

		// filename
		else if (filenameAssociation != null) {
			WOResourceManager resourceManager = WOApplication.application().resourceManager();
			String filename = (String) filenameAssociation.valueInComponent(component);
			String framework = null;

			// set the url
			if (frameworkAssociation != null)
				framework = (String) frameworkAssociation.valueInComponent(component);

			src = resourceManager.urlForResourceNamed(filename, framework, null, context.request());
		}

		// open tag
		response.appendContentString("<img");

		// append image src
		response.appendContentString(" src=" + "\"" + src + "\"");

		// append other bindings
		if (associations.count() > 0) {
			Enumeration keyEnumerator = associations.keyEnumerator();

			while (keyEnumerator.hasMoreElements()) {
				String key = (String) keyEnumerator.nextElement();
				WOAssociation association = (WOAssociation) associations.objectForKey(key);
				Object value = association.valueInComponent(component);

				// append attribute
				if (value != null)
					response.appendContentString(" " + key + "=" + "\"" + value + "\"");
			}
		}

		// terminate tag
		response.appendContentString("/>");
	}
}