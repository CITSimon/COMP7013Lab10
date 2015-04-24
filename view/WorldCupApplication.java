package view;

import java.util.ArrayList;

import model.Country;
import model.Player;
import controller.CountryDatabasePersistor;
import controller.CountryFilePersistor;
import controller.IPersistor;
import controller.WorldCupController;

public class WorldCupApplication {

	public static void main(String[] args) 
	{
		//CREATE THE PERSISTOR
		IPersistor persistor = new CountryDatabasePersistor();
		WorldCupController.getInstance().setPersistor(persistor);
		
		//CREATE THE MODEL
		ArrayList<Player> thePlayers = persistor.read();
		
		//CONNECT THE CONTROLLER TO THE MODEL
		Country theDataModel = new Country("");
		theDataModel.setPlayers(thePlayers);
		WorldCupController.getInstance().setDataModel(theDataModel);
		
		//CREATE THE VIEW
		WorldCupFrame wcf = new WorldCupFrame("World Cup 2015");
		wcf.setSize(600, 300);
		wcf.setVisible(true);
		
		//CONNECT THE CONTROLLER TO THE VIEW
		WorldCupController.getInstance().setGuiReference(wcf);

	}

}
