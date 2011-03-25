//
// Main.java: Class file for WO Component 'Main'
// Project Feedback
//
// Created by ravi on Fri Aug 10 2001
//
 
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class Main extends WOComponent {
    protected String from;
    protected String subject;
    protected String message;
    protected NSArray images = new NSArray(new String[]{"leila.jpg", "snowboard.jpg"});
    protected String image;
    protected String to;

    public Main(WOContext context) {
        super(context);
    }
}