//
// Main.java: Class file for WO Component 'Main'
// Project Hello
//
// Created by ravi on Sat Jul 14 2001
//
 
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class Main extends WOComponent {

    public Main(WOContext context) {
        super(context);
    }

    public WOComponent submit() {
	WOComponent nextPage = pageWithName("Greeting");
	
        return nextPage;
    }
}