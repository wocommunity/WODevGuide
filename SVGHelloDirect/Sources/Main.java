//
// Main.java: Class file for WO Component 'Main'
// Project Hello
//
// Created by ravi on Sat Jul 14 2001
//
 
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class Main extends WOComponent {
    protected String username;
    protected NSArray styles = new NSArray(new String[]{"Stripes", "Gradient"});
    protected String style;

    public Main(WOContext context) {
        super(context);
    }
}