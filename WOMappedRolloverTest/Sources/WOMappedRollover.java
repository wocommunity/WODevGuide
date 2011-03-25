//
// WOMappedRollover.java: Class file for WO Component 'WOMappedRollover'
// Project WOMappedRolloverTest
//
// Created by ravi on Sat Aug 04 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResourceManager;
import com.webobjects.foundation.NSDictionary;

public class WOMappedRollover extends WOComponent {
	protected NSDictionary area;
	protected int index;

	public WOMappedRollover(WOContext context) {
		super(context);

		// debug
		WOComponent.debugString("WOMappedRollover: init");
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
		return false;
	}

	/*
	 * accessors
	 */
	public String scriptString() {
		WOResourceManager resourceManager = application().resourceManager();
		String filename = (String) area.valueForKey("imageOnMouseOver");
		String url = resourceManager.urlForResourceNamed(filename, null, null, context().request());
		String imageName = (String) valueForBinding("imageName");

		// image pre-loading
		return imageName + index + " = new Image();\n" + imageName + index + ".src = '" + url + "';\n";
	}

	public String onMouseOver() {
		String imageName = (String) valueForBinding("imageName");
		return imageName + ".src=" + imageName + index + ".src;"; 
	}

	public String onMouseOut() {
		String imageName = (String) valueForBinding("imageName");
		return imageName + ".src='" + src() + "';"; 
	}

	public String usemap() {
		NSDictionary imageMap = (NSDictionary) valueForBinding("imageMap");
		String mapName = (String) imageMap.valueForKey("name");

		return "#" + mapName;
	}

	public String src() {
		WOResourceManager resourceManager = application().resourceManager();
		String imageFile = (String) valueForBinding("imageFile");

		return resourceManager.urlForResourceNamed(imageFile, null, null, context().request());
	}
}