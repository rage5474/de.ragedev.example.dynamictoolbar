package de.ragedev.example.dynamictoolbar.api.eventbusids;

public class ButtonTriggeredMsg {
	
	private static final String KEYWORD = "buttontriggered";

	public static String getID() {
		return EventBusMsgConstants.MSG_PREFIX + KEYWORD;
	}
	
	public static String getNameParam() {
		return EventBusMsgConstants.MSG_PREFIX + KEYWORD + "/name";
	}
}
