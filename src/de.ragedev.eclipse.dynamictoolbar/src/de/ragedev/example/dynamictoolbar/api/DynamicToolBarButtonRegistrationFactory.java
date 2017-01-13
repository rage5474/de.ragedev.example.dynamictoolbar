package de.ragedev.example.dynamictoolbar.api;

import de.ragedev.example.dynamictoolbar.impl.DynamicToolBarButtonRegistrationImpl;

public class DynamicToolBarButtonRegistrationFactory {

	public static final DynamicToolBarButtonRegistration create()
	{
		return new DynamicToolBarButtonRegistrationImpl();
	}
}
