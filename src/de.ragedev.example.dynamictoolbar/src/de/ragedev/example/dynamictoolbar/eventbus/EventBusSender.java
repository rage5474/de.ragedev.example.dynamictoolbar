package de.ragedev.example.dynamictoolbar.eventbus;

import java.util.Collections;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import de.ragedev.example.dynamictoolbar.Activator;
import de.ragedev.example.dynamictoolbar.Constants;

public class EventBusSender {
	public static void sendMessage() {
		BundleContext bundleContext = Activator.context;
		ServiceReference<EventAdmin> eventAdminReference = bundleContext.getServiceReference(EventAdmin.class);
		EventAdmin eventAdmin = bundleContext.getService(eventAdminReference);
		Event event = new Event(Constants.MESSAGE_ID, Collections.emptyMap());
		eventAdmin.postEvent(event);
	}
}
