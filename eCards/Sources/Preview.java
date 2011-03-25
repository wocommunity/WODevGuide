//
// Preview.java: Class file for WO Component 'Preview'
// Project eCards
//
// Created by ravi on Wed Aug 29 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSDictionary;

public class Preview extends WOComponent {
    protected String image;
    protected String subject;
    protected String message;

    public Preview(WOContext context) {
        super(context);
    }
    
    public NSDictionary queryDictionary() {
	return new NSDictionary(image, "image");
    }
}