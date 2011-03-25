//
// Main.java: Class file for WO Component 'Main'
// Project UserForumTestC
//
// Created by ravi on Sat Oct 13 2001
//

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.misc.BASE64Decoder;
import biz.forum.model.User;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSTimestampFormatter;

public class Main extends WOComponent {
	protected Forum forum;
	protected Moderator moderator;
	protected String _msg;
	protected boolean authorize;

	public Main(WOContext context) {
		super(context);
	}

	/*
	 * accessors
	 */
	public Integer forumID() {
		NSDictionary primaryKey = EOUtilities.primaryKeyForObject(forum.editingContext(), forum);
		return (Integer) primaryKey.valueForKey("forumID");
	}

	public boolean hasSession() {
		String sessionID = context().request().cookieValueForKey("wosid");
		return (super.hasSession() || sessionID != null);
	}

	public String onLoad() {
		String onLoad = "alert('" + _msg + "');";
		return (_msg != null) ? onLoad:null;
	}    

	/*
	 * request/response
	 */
	public void appendToResponse(WOResponse response, WOContext context) {
		if (authorize) {
			// request authorization
			String realm = context.request().applicationName();
			response.setStatus(401); 
			response.setHeader("Basic realm=\"" + realm + "\"" , "WWW-Authenticate");
			String encode = context.request().headerForKey("authorization");
			NSArray inputs = new NSArray();

			// decode the username/password text and validate
			if (encode != null) {
				encode = encode.substring(6);      // remove the "Basic " prefix

				// try decoding the authorization
				try {
					BASE64Decoder decoder = new BASE64Decoder();
					InputStream inputStream = new ByteArrayInputStream(encode.getBytes());
					String authorization = new String(decoder.decodeBuffer(inputStream));

					// partition the username from passwords
					inputs = NSArray.componentsSeparatedByString(authorization, ":");
				} catch (IOException exception) {
					NSLog.err.appendln("Main: failed to decode authorization: " + encode);
				}

				// set username & password from the login
				String username = (String) inputs.objectAtIndex(0);
				EOEditingContext editingContext = new EOEditingContext();
				NSArray results = EOUtilities.rawRowsMatchingKeyAndValue(editingContext, "User", "name", username);

				// log the user and referer
				String clientIP = context.request().headerForKey("remote_addr");
				NSTimestampFormatter formatter = new NSTimestampFormatter("[%d/%b/%Y:%H:%M:%S %z]");
				application().statisticsStore().logString(clientIP + " " + username + " " + formatter.format(new NSTimestamp()) + "\n");

				// if there are user(s) matching the username
				if (results.count() > 0) {
					NSDictionary result = (NSDictionary) results.objectAtIndex(0);
					String _password = (String) result.valueForKey("password");
					String password = (String) inputs.objectAtIndex(1);

					// check that the passwords match
					if (_password.equals(User.encrypt(password))) {
						EOEnterpriseObject user = EOUtilities.objectMatchingKeyAndValue(session().defaultEditingContext(), "User", "name", username);
						String url = context().completeURLWithRequestHandlerKey("wa", null, null, false, 0);

						// set the session.user
						session().takeValueForKey(user, "user");

						// set the redirect url and headers
						response.setHeader(url, "location");
						response.setHeader("text/html", "content-type");
						response.setHeader("0", "content-length");
						response.setStatus(302);                        
					} else _msg = "Incorrect password. Try again.";
				} else _msg = "No user match. Try again.";
			}
		} super.appendToResponse(response, context);
	}
}