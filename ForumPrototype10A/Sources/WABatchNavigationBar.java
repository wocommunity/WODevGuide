//
// WABatchNavigationBar.java: Class file for WO Component 'WABatchNavigationBar'
// Project WABatchNavigationBarTest
//
// Created by ravi on Mon Oct 15 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;

public class WABatchNavigationBar extends WOComponent {

    public WABatchNavigationBar(WOContext context) {
        super(context);
    }
    
    public boolean isStateless() {
        return true;
    }

    /*
    * accessors
    */
    public boolean hasObjectName() {
        return hasBinding("objectName");
    }
    
    public int nextBatchIndex() {
	int index = currentBatchIndex();
        return ++index;
    }
    
    public int previousBatchIndex() {
	int index = currentBatchIndex();
        return --index;
    }
    
    public int currentBatchIndex() {
    	WODisplayGroup displayGroup = (WODisplayGroup) valueForBinding("displayGroup");

        return displayGroup.currentBatchIndex();
    }
}