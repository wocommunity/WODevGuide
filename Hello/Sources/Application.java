//
// Application.java
// Project Hello
//
// Created by ravi on Sat Jul 14 2001
//

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation._NSUtilities;

public class Application extends WOApplication {
    
    public static void main(String argv[]) {
        WOApplication.main(argv, Application.class);
    }

    public Application() {
        super();
        System.out.println("Welcome to " + this.name() + "!");
        /* ** Put your application initialization code here ** */
	//setPageRefreshOnBacktrackEnabled(true);
	//setPageCacheSize(1);
    }
    
	public WOResponse dispatchRequest(WORequest request) {
		request.setContentEncoding(_NSUtilities.UTF8StringEncoding);
		request.setHeader("text/html; charset=UTF-8; encoding=UTF-8", "content-type");
		return super.dispatchRequest(request);
	}
    
}
