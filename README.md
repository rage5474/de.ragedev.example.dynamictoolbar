This Eclipse Plug-in shows how the main toolbar can be extend via a EventBus message. 

To play with it import the project into a Eclipse for RCP Developers (Neon v2) and run it as an Eclipse Application. 
Then you can find click in the main menu on Ragedev -> Trigger Event Bus. If everything runs fine, a new symbol should be shown in the main toolbar. 

Important classes are:
- de.ragedev.example.dynamictoolbar.eventbus.receiver.EventListener
- de.ragedev.example.dynamictoolbar.dynamictoolbarhandler.DynamicToolbarItemHandler/DynamicToolbarItemHandlerWrapper

EventListener listens for a specific event and is calling an Eclipse command by code.
DynamicToolbarItemHandler is modifying the application model and adding the toolbar element. 
