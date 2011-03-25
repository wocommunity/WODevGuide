//
// Application.java
// Project UserForumTest
//
// Created by ravi on Wed Oct 03 2001
//

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WORequestHandler;
import com.webobjects.appserver.WOResponse;
import com.webobjects.appserver.WOSession;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOSharedEditingContext;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSValidation;

public class Application extends WOApplication {

    public static void main(String argv[]) {
        WOApplication.main(argv, Application.class);
    }
    
    public Application() {
        super();
	
	// set direct actions as defualt
	WORequestHandler directActionRequestHandler = requestHandlerForKey("wa");
	setDefaultRequestHandler(directActionRequestHandler);
	
       // force fetching of shared EOs
	EOSharedEditingContext sharedEditingContext = EOSharedEditingContext.defaultSharedEditingContext();
 	EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("FetchAll", "Forum");
	sharedEditingContext.objectsWithFetchSpecification(fetchSpec);

        // set the log file
        statisticsStore().setLogFile("/Library/WebObjects/Logs/User.log", 10^7);
    }
    
    /*
    * session creation
    */
    public WOSession createSessionForRequest(WORequest request) {
        WOSession session = super.createSessionForRequest(request);
        
        // disable object sharing for the session ec
        session.defaultEditingContext().setSharedEditingContext(null);

        // use cookies
        session.setStoresIDsInCookies(false);
        session.setStoresIDsInURLs(true);

        // debug
        NSLog.debug.appendln("Application: new session created: " + session);
        
        return session;
    }
    
    /*
    * exception handling
    */
    public WOResponse handleException(Exception exception, WOContext context) {
        if (!(exception instanceof NSValidation.ValidationException)) {
            WOComponent errorPage = pageWithName("ErrorPage", context);
            
            // log the error
            NSLog.out.appendln("Application: " + exception); 
            
            return errorPage.generateResponse(); 
        } else return super.handleException(exception, context);
    }
}