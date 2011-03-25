//
// Greeting.java: Class file for WO Component 'Greeting'
// Project Hello
//
// Created by ravi on Mon Jul 16 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class Greeting extends WOComponent {
    protected String username;

    public Greeting(WOContext context) {
        super(context);
    }

}
