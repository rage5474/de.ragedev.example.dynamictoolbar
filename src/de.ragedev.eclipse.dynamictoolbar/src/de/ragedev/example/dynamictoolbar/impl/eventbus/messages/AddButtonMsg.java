package de.ragedev.example.dynamictoolbar.impl.eventbus.messages;

import de.ragedev.example.dynamictoolbar.api.eventbusids.EventBusMsgConstants;

public class AddButtonMsg {

	private static final String KEYWORD = "addbutton";
	
	public static String getID() {
		return EventBusMsgConstants.MSG_PREFIX + KEYWORD;
	}
	
	public static String getIconParamID() {
		return EventBusMsgConstants.MSG_PREFIX + KEYWORD + "/iconpath";
	}
	

}
