package de.ragedev.example.dynamictoolbar.eventbus.utils;

import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import de.ragedev.example.dynamictoolbar.api.PluginConstants;

public class EventBusSender {
	public static void sendMessage(String messageID, Map<String, ?> properties) {
		BundleContext bundleContext = Platform.getBundle(PluginConstants.PLUGIN_ID).getBundleContext();
		ServiceReference<EventAdmin> eventAdminReference = bundleContext.getServiceReference(EventAdmin.class);
		EventAdmin eventAdmin = bundleContext.getService(eventAdminReference);
		Event event = new Event(messageID, properties);
		eventAdmin.postEvent(event);
	}
}
