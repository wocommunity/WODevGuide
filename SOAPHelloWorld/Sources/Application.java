//
// Application.java
// Project SOAPHelloWorld
//
// Created by ravi on Sat Feb 09 2002
//

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WORequestHandler;

public class Application extends WOApplication {
    
    public static void main(String argv[]) {
        WOApplication.main(argv, Application.class);
    }

    public Application() {
        super();
        System.out.println("Welcome to " + this.name() + "!");
        
        /* ** Put your application initialization code here ** */
        WORequestHandler directActionRequestHandler = requestHandlerForKey("wa");
        setDefaultRequestHandler(directActionRequestHandler);
    }
}
