package de.ragedev.example.dynamictoolbar.dynamictoolbarhandler;

import java.util.List;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.swt.widgets.Display;

import de.ragedev.example.dynamictoolbar.Constants;

public class DynamicToolbarItemHandler {

	@Execute
	public void execute(MApplication application) {
		EModelService modelService = (EModelService) application.getContext().get(EModelService.class.getName());
		List<MToolBar> toolbars = modelService.findElements(application, null, MToolBar.class, null);
		for (MToolBar mToolBar : toolbars) {
			if (mToolBar.getElementId().equals("org.eclipse.ui.workbench.file")) {
				MDirectToolItem toolItem = MMenuFactory.INSTANCE.createDirectToolItem();
				toolItem.setLabel("Hello World");
				toolItem.setIconURI("platform:/plugin/" + Constants.PLUGIN_ID + "/" + Constants.PATH_TO_IMG);

				Display.getDefault().asyncExec(() -> {
					mToolBar.getChildren().add(toolItem);
				});
			}
		}
	}

}
