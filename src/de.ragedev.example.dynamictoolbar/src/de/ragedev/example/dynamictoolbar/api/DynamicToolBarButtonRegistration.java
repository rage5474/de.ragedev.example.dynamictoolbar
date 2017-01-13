package de.ragedev.example.dynamictoolbar.api;

import java.util.List;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class DynamicToolBarButtonRegistration {

	public static void registerButton(String name, String buttonLabel, String iconURI) {
		registerButton(name, buttonLabel, iconURI, "org.eclipse.ui.workbench.file");
	}

	public static void registerButton(String name, String buttonLabel, String iconURI, String toolbarID) {
		IEclipseContext context = PlatformUI.getWorkbench().getService(IEclipseContext.class);
		MApplication application = context.get(MApplication.class);
		EModelService modelService = (EModelService) context.get(EModelService.class.getName());
		
		MCommand command = getAddButtonCommand(application, modelService);
		
		if(command != null)
		{
			List<MToolBar> toolbars = modelService.findElements(application, null, MToolBar.class, null);
			for (MToolBar mToolBar : toolbars) {
				if (mToolBar.getElementId().equals(toolbarID)) {
					MHandledToolItem handledToolItem = MMenuFactory.INSTANCE.createHandledToolItem();
					handledToolItem.setCommand(command);
					handledToolItem.setLabel(buttonLabel);
					handledToolItem.setIconURI(iconURI);
					MParameter parameter = MCommandsFactory.INSTANCE.createParameter();
					parameter.setElementId(PluginConstants.ADD_BUTTON_COMMAND_PARAM_KEY);
					parameter.setName(PluginConstants.ADD_BUTTON_COMMAND_PARAM_KEY);
					parameter.setValue(name);
					
					handledToolItem.getParameters().add(parameter);
					Display.getDefault().asyncExec(() -> {
						mToolBar.getChildren().add(handledToolItem);
					});
					
				}
			}
		}
	}

	private static MCommand getAddButtonCommand(MApplication application, EModelService modelService) {
		List<MCommand> commands = modelService.findElements(application, null, MCommand.class, null);
		for (MCommand mCommand : commands) {
			if(mCommand.getElementId().equals(PluginConstants.ADD_BUTTON_COMMAND_KEY))
			{
				return mCommand;
			}
		}
		return null;
	}

}
