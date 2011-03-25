//
// Main.java: Class file for WO Component 'Main'
// Project CrazyEights
//
// Created by ravi on Mon Sep 10 2001
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class Main extends WOComponent {
	protected NSMutableArray deck;
	protected NSMutableArray myHand = new NSMutableArray();
	protected EOEnterpriseObject aCard;
	protected EOEnterpriseObject discard;

	public Main(WOContext context) {
		super(context);

		// fetch the Cards
		deck = new NSMutableArray((NSArray) valueForKeyPath("application.cards"));

		// deal my hand
		while (myHand.count() < 7) myHand.addObject(card());

		// start the discard pile
		discard = card();
	}

	/*
	 * actions
	 */
	public void play() {
		// check to see if the card is of the same suit or rank or an 8
		if (aCard.valueForKey("suit") == discard.valueForKey("suit") 
				|| aCard.valueForKey("rank") == discard.valueForKey("rank")
				|| aCard.valueForKey("rank") == "Eight" 
					|| discard.valueForKey("rank") == "Eight") { 
			// discard the card you selected
			discard = aCard;
			myHand.removeObject(aCard);
		}
	}

	public void draw() {
		if (deck.count() > 0) { 	    
			// draw a card
			myHand.addObject(card());
		}
	}

	private EOEnterpriseObject card() {
		int i = (int) Math.floor(Math.random()*deck.count());

		// deal a random card from the deck
		EOEnterpriseObject card = (EOEnterpriseObject) deck.objectAtIndex(i);
		deck.removeObjectAtIndex(i);

		return card;
	}
}