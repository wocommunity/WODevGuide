//
// Application.java
// Project CrazyEightsTest
//
// Created by ravi on Tue Jan 22 2002
//

import com.webobjects.appserver.WOApplication;

public class Application extends WOApplication {
    
    public static void main(String argv[]) {
        WOApplication.main(argv, Application.class);
    }

    public Application() {
        super();
        System.out.println("Welcome to " + this.name() + "!");
        
        /* ** Put your application initialization code here ** */
    }
    
}
