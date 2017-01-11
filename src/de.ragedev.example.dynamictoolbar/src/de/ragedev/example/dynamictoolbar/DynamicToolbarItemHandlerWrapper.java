package de.ragedev.example.dynamictoolbar;

import org.eclipse.e4.tools.compat.parts.DIHandler;

@SuppressWarnings("restriction")
public class DynamicToolbarItemHandlerWrapper extends DIHandler<DynamicToolbarItemHandler> {

	public DynamicToolbarItemHandlerWrapper() {
		super(DynamicToolbarItemHandler.class);
	}
	
}
