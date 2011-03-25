//
// Application.java
// Project CrazyEights
//
// Created by ravi on Mon Sep 10 2001
//

import com.webobjects.appserver.WOApplication;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOSharedEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class Application extends WOApplication {
	protected NSArray cards;
	protected NSMutableArray games = new NSMutableArray();

	public static void main(String argv[]) {
		WOApplication.main(argv, Application.class);
	}

	public Application() {
		super();
		System.out.println("Welcome to " + this.name() + "!");

		// fetch cards
		EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("FetchAll", "Card");
		EOSharedEditingContext.defaultSharedEditingContext().bindObjectsWithFetchSpecification(fetchSpec, "FetchAll");
	}
	
}