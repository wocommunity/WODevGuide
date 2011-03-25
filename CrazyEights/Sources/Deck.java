//
// Deck.java
// Project CrazyEights
//
// Created by ravi on Wed Sep 12 2001
//

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOSharedEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class Deck extends Object {
	NSMutableArray cards = new NSMutableArray((NSArray) EOSharedEditingContext.defaultSharedEditingContext().objectsByEntityName().valueForKey("Cards"));

	/*
	 * accessors
	 */
	public EOEnterpriseObject card() {
		int i = (int) Math.floor(Math.random()*cards.count()); 

		// deal a random card from the deck
		EOEnterpriseObject card = (EOEnterpriseObject) cards.objectAtIndex(i);
		cards.removeObjectAtIndex(i);

		return card;
	}
}