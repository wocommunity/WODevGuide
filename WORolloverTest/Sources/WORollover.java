//
// WORollover.java: Class file for WO Component 'WORollover'
// Project WORolloverTest
//
// Created by ravi on Sat Jul 28 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResourceManager;

public class WORollover extends WOComponent {
    protected String unhighlightedImage;
    protected String highlightedImage;
    protected String imageName;

    public WORollover(WOContext context) {
        super(context);
    }
    
    /*
    * accessors
    */
    public String onMouseOver() {	
        return imageName + ".src=" + imageName + "_H.src;";
    }
    
    public String onMouseOut() {
        return imageName + ".src=" + imageName + "_U.src;";
    }
    
    public String scriptString() {
    	WOResourceManager resourceManager = application().resourceManager();
	String unhighlightedImageURL = resourceManager.urlForResourceNamed(unhighlightedImage, null, session().languages(), context().request());
	String highlightedImageURL = resourceManager.urlForResourceNamed(highlightedImage, null, session().languages(), context().request());
	String scriptString = imageName + "_U = new Image();\n" +  imageName + "_U.src='" + unhighlightedImageURL + "';\n" + imageName + "_H = new Image();\n" + imageName + "_H.src='" + highlightedImageURL + "';\n";
	
        return scriptString;
    }
}