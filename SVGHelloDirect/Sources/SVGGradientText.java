//
// SVGGradientText.java: Class file for WO Component 'SVGGradientText'
// Project SVGHelloDirect
//
// Created by ravi on Tue Aug 28 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class SVGGradientText extends WOComponent {

    public SVGGradientText(WOContext context) {
        super(context);
    }
    
    public boolean synchronizesVariablesWithBindings() {
	return false;
    }
}