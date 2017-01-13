package de.ragedev.example.dynamictoolbar.handler;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import de.ragedev.example.dynamictoolbar.api.eventbusids.ButtonTriggeredMsg;
import de.ragedev.example.dynamictoolbar.eventbus.utils.EventBusPropertiesBuilder;
import de.ragedev.example.dynamictoolbar.eventbus.utils.EventBusSender;

public class ButtonTriggeredHandler extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EventBusSender.sendMessage(ButtonTriggeredMsg.getID(), extractProperties(event));
		return null;
	}

	private Map<String, String> extractProperties(ExecutionEvent event) {
		String name = event.getParameter("mycommand.buttonname");
		return new EventBusPropertiesBuilder().addParameter(ButtonTriggeredMsg.getNameParam(), name).build();
	}
	
}
