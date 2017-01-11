package de.ragedev.example.dynamictoolbar.eventbus.sender;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class EventBusTriggerHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EventBusSender.sendMessage();
		return null;
	}

}
