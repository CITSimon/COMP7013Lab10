package controller;

import java.util.ArrayList;

import model.Country;
import model.Goalkeeper;
import model.Player;
import model.Striker;

public class WorldCupController 
{	
	//THIS IS THE STATIC PART
	//This is the static variable which will point at the
	//instance of WorldCupController once created.
	private static WorldCupController instance = null;
	
	//This is the static method which "manages" the static 
	//instance. A static method is required to access a static 
	//variable.
	//If the instance is not created it will be created. If it is
	//already created then we don't need to create another instance.
	//Either way the one and only instance gets returned.
	public static WorldCupController getInstance()
	{
		if(instance == null)
		{
			instance = new WorldCupController();
		}
		return instance;
	}
	
	/////EVERYTHING BELOW THIS IS THE "INSTANCE PART"
	private ArrayList<Player> newlyAddedPlayers;
	
	//Reference to the data model
	private Country dataModel;
	
	//Reference to the GUI
	//Any GUI which implements this interface can be 
	//communicated with by this controller.
	//If we had just put private WorldCupFram gui then
	//we would be restricting this controller to only being
	//capable of connecting to a Swing GUI.
	private IWorldCupGUI gui;
	
	//Add a reference to the persistor.
	private IPersistor persistor;
		
	//Default constructor
	//Making this private means that it can only be called 
	//from inside this class (i.e. Only our getInstance() 
	//method can call this now. Nobody outside this class
	//can create an instance of it.
	private WorldCupController()
	{
		this.newlyAddedPlayers = new ArrayList<Player>();
	}
	
	public void setDataModel(Country dataModel)
	{
		this.dataModel = dataModel;
	}
	
	public Country getDataModel()
	{
		return this.dataModel;
	}
	
	public void setGuiReference(IWorldCupGUI gui)
	{
		this.gui = gui;
	}
	
	public IWorldCupGUI getGuiReference()
	{
		return this.gui;
	}
	
	public void setPersistor(IPersistor persistor)
	{
		this.persistor = persistor;
	}
	
	public IPersistor getPersistor()
	{
		return this.persistor;
	}
	
	
	//This method will be called by the VIEW layer and pass 
	//the information filled in in the Add Player dialog of the 
	//GUI.
//	public void createPlayer(String name, int age, 
//									 int caps, int goalsScored)
//	{
//		Player p = new Player(name, age, caps, goalsScored);
//		this.dataModel.addPlayer(p);
//		//Inform the GUI that the data model has been updated.
//		//This means the GUI will refresh itself.
//		this.gui.refreshGUI();
//	}
	
	public void createGoalkeeper(String name, int age, int caps, 
									int goalsScored, int noOfCleanSheets)
	{
		Goalkeeper g = 
				new Goalkeeper(name, age, caps, goalsScored, noOfCleanSheets);
		this.dataModel.addPlayer(g);
		this.newlyAddedPlayers.add(g);
		this.gui.refreshGUI();
	}
	public void createStriker(String name, int age, int caps, 
			int goalsScored, double height)
	{

		Striker s = 
				new Striker(name, age, caps, goalsScored, height);
		this.dataModel.addPlayer(s);
		this.newlyAddedPlayers.add(s);
		this.gui.refreshGUI();
	}
	
	
	public void save()
	{
		this.persistor.write(this.newlyAddedPlayers);
		this.newlyAddedPlayers.clear();
	}
		
}
