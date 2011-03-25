//
// WXImage.java: Class file for WO Component 'WXImage'
// Project HelloDirectX
//
// Created by ravi on Fri Aug 17 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResourceManager;

public class WXImage extends WOComponent {

	public WXImage(WOContext context) {
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
	 * accessors
	 */
	public String src() {
		WOResourceManager resourceManager = application().resourceManager();

		if (hasBinding("filename")) {
			String filename = (String) valueForBinding("filename");
			String framework = (String) valueForBinding("framework");

			return resourceManager.urlForResourceNamed(filename, framework, null, context().request());
		} else return (String) valueForBinding("src");
	}

}