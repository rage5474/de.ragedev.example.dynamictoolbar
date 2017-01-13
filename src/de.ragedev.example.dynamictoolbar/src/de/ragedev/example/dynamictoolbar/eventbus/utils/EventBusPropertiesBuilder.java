package de.ragedev.example.dynamictoolbar.eventbus.utils;

import java.util.HashMap;
import java.util.Map;

public class EventBusPropertiesBuilder {

	private Map<String, String> properties;
	
	public EventBusPropertiesBuilder() {
		properties = new HashMap<>();
	}
	
	public EventBusPropertiesBuilder addParameter(String paramID, String paramValue)
	{
		properties.put(paramID, paramValue);
		return this;
	}
	
	public Map<String, String> build()
	{
		return properties;
	}
	
}
