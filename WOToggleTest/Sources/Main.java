//
// Main.java: Class file for WO Component 'Main'
// Project WOToggleTest
//
// Created by ravi on Mon Aug 06 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class Main extends WOComponent {
	protected boolean condition;

	public Main(WOContext context) {
		super(context);
	}

	public void setCondition(boolean flag) {
		condition = flag;

		// debug
		WOComponent.debugString("Main: condition set");
	}
}
