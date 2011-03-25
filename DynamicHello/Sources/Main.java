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

    /*
    * actions
    */
    public WOComponent submit() {
	//WOComponent nextPage = pageWithName("Greeting");
	// return nextPage;
	return this;
    }
    
    /*
    * accessors
    */
    public String onLoad() {
	String username = (String) valueForKeyPath("session.username"); 
	String onLoad = "javascript: alert('Hello " + username + "!');"; 
	
	return (username != null) ? onLoad:null;
    }
}