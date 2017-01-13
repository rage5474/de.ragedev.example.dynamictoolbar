package de.ragedev.example.dynamictoolbar.api;

public interface DynamicToolBarButtonRegistration {

	public void registerButton(String name, String buttonLabel, String iconURI);
	
	public void registerButton(String name, String buttonLabel, String iconURI, String toolbarID);
	
}
