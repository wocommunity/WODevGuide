//
// Picture.java: Class file for WO Component 'Picture'
// Project eCards
//
// Created by ravi on Thu Aug 30 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;

public class Picture extends WOComponent {
    protected String image;

    public Picture(WOContext context) {
        super(context);
    }

    public void appendToResponse(WOResponse response, WOContext context) {
        super.appendToResponse(response, context);

        response.setHeader("image/svg-xml", "Content-Type");
    }
}
