// Generated by the WebObjects Assistant Tue Jan 22 14:13:41 Etc/GMT 2002

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.foundation.NSLog;

public class Main extends WOComponent {

	protected Card card;
	// This WODisplayGroup is initialized from the .woo archive in the component's constructor method
	protected WODisplayGroup cardDisplayGroup;

	public Main(WOContext context) {
		super(context);
	}

	public void selectObject() {
		cardDisplayGroup.selectObject(card);
	}

	public void saveChanges() throws Exception {
		try {
			this.session().defaultEditingContext().saveChanges();
		} catch (Exception exception) {
			// An error occurred during the save. You could present an error page which
			// explains the reason for the save failure.
			// The default is to raise an exception which presents a diagnostic page.
			NSLog.err.appendln("Cannot save changes ");
			throw exception;
		}
	}

}