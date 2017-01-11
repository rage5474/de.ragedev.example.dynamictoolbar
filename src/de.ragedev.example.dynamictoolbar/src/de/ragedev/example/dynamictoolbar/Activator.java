package de.ragedev.example.dynamictoolbar;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	public static BundleContext context;

	@Override
	public void start(BundleContext context) throws Exception {
		Activator.context = context;
		super.start(context);
	}
}
