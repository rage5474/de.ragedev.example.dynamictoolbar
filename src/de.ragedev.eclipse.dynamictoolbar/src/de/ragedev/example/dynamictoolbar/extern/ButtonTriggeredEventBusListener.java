package de.ragedev.example.dynamictoolbar.extern;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import de.ragedev.example.dynamictoolbar.api.eventbusids.ButtonTriggeredMsg;

@Component(immediate = true, enabled = true, property = "event.topics=de/ragedev/event/buttontriggered")
public class ButtonTriggeredEventBusListener implements EventHandler {
	
	@Override
	public void handleEvent(Event event) {
		System.out.println("Button triggered: " + event.getProperty(ButtonTriggeredMsg.getNameParam()));
	}

}
