package de.ragedev.example.dynamictoolbar.extern;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import de.ragedev.example.dynamictoolbar.api.DynamicToolBarButtonRegistration;
import de.ragedev.example.dynamictoolbar.api.DynamicToolBarButtonRegistrationFactory;
import de.ragedev.example.dynamictoolbar.api.PluginConstants;

@Component(immediate = true, enabled = true, property = "event.topics=de/ragedev/event/addbutton")
public class AddButtonEventBusListener implements EventHandler {
	
	private static final String PATH_TO_IMG = "icons/smartmode_co.gif";
	
	private final DynamicToolBarButtonRegistration dynamicToolBarButtonRegistration = DynamicToolBarButtonRegistrationFactory.create();
	
	@Override
	public void handleEvent(Event event) {

		//Must be provided
		String name = "ScriptName";
		String buttonLabel = "MyLabel";
		String iconURI = "platform:/plugin/" + PluginConstants.PLUGIN_ID + "/" + PATH_TO_IMG;

		dynamicToolBarButtonRegistration.registerButton(name, buttonLabel, iconURI);

		// Optional: If toolbar shall be set
		// String toolbarID = "org.eclipse.ui.workbench.file";
		// DynamicToolBarButtonRegistration.registerButton(name, buttonLabel, iconURI, toolbarID);
	}

}
