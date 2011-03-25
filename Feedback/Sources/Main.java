//
// Main.java: Class file for WO Component 'Main'
// Project Feedback
//
// Created by ravi on Fri Aug 10 2001
//
 
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class Main extends WOComponent {
    protected String from;
    protected String subject;
    protected String contents;

    public Main(WOContext context) {
        super(context);
    }

}
