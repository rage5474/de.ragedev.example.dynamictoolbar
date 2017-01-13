package de.ragedev.example.dynamictoolbar.extern;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import de.ragedev.example.dynamictoolbar.eventbus.ids.AddButtonMsg;
import de.ragedev.example.dynamictoolbar.eventbus.utils.EventBusPropertiesBuilder;
import de.ragedev.example.dynamictoolbar.eventbus.utils.EventBusSender;

public class EventBusTriggerHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Map<String, String> properties = new EventBusPropertiesBuilder().addParameter(AddButtonMsg.getIconParamID(), "mypath").build();
		EventBusSender.sendMessage(AddButtonMsg.getID(), properties);
		return null;
	}

}
