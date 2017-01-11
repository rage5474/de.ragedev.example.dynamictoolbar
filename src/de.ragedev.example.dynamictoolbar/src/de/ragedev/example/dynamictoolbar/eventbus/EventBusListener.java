package de.ragedev.example.dynamictoolbar.eventbus;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.Parameterization;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.services.IServiceLocator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import de.ragedev.example.dynamictoolbar.Constants;

@Component(immediate = true, enabled = true, property = "event.topics=de/ragedev/event/*")
public class EventBusListener implements EventHandler {

	@Override
	public void handleEvent(Event event) {
		ICommandService service = (ICommandService) ((IServiceLocator) PlatformUI.getWorkbench())
				.getService(ICommandService.class);

		Command command = service.getCommand(Constants.CMD_ID);

		IHandlerService handlerService = (IHandlerService) ((IServiceLocator) PlatformUI.getWorkbench())
				.getService(IHandlerService.class);

		ParameterizedCommand parametrizedCommand = new ParameterizedCommand(command, new Parameterization[] {});

		try {
			handlerService.executeCommand(parametrizedCommand, null);
		} catch (ExecutionException | NotDefinedException | NotEnabledException | NotHandledException e) {
			e.printStackTrace();
		}

	}

}
