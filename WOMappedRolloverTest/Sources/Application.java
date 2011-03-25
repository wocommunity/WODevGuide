//
// Application.java
// Project WOMappedRolloverTest
//
// Created by ravi on Sat Aug 04 2001
//

import java.io.InputStream;

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WORequestHandler;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSPropertyListSerialization;
import com.webobjects.foundation._NSUtilities;

public class Application extends WOApplication {
	protected NSDictionary imageMap;

	public static void main(String argv[]) {
		WOApplication.main(argv, Application.class);
	}

	/*
	 * constructor
	 */
	public Application() {
		super();
		System.out.println("Welcome to " + this.name() + "!");

		// make direct actions the default
		WORequestHandler directActionRequestHandler = requestHandlerForKey("wa");
		setDefaultRequestHandler(directActionRequestHandler);
	}

	/*
	 * accessors
	 */
	public NSDictionary imageMap() {
		if (imageMap == null) {	
			InputStream inputStream = resourceManager().inputStreamForResourceNamed("ImageMap.plist", null, null);

			// create the data, log exceptions
			try { 
				NSData mapData = new NSData(inputStream, inputStream.available()); 
				imageMap = (NSDictionary) NSPropertyListSerialization.propertyListFromData(mapData);
			} catch (Exception exception) {
				logString("Application:  failed to read in image map");
			}
		} return imageMap;
	}    

	public WOResponse dispatchRequest(WORequest request) {
		request.setContentEncoding(_NSUtilities.UTF8StringEncoding);
		request.setHeader("text/html; charset=UTF-8; encoding=UTF-8", "content-type");
		return super.dispatchRequest(request);
	}
}