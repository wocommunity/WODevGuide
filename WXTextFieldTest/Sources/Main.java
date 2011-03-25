//
// Main.java: Class file for WO Component 'Main'
// Project WXTextFieldTest
//
// Created by ravi on Mon Aug 20 2001
//
 
import java.math.BigDecimal;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

public class Main extends WOComponent {
    protected NSTimestamp date = new NSTimestamp();
    protected Number number = new BigDecimal(100.00);

    public Main(WOContext context) {
        super(context);
    }

    public void action() {
        WOComponent.debugString("Main: action");
    }

}
