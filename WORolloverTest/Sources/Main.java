//
// Main.java: Class file for WO Component 'Main'
// Project WORolloverTest
//
// Created by ravi on Fri Jul 27 2001
//
 
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class Main extends WOComponent {
    protected String unhighlightedImage = "home.gif";
    protected String highlightedImage = "homeH.gif";
    protected String imageName = "home";

    public Main(WOContext context) {
        super(context);
    }

}
