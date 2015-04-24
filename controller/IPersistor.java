package controller;

import java.util.ArrayList;

import model.Player;

public interface IPersistor 
{
	//The reason I've changed to ArrayList<Player>
	//here is to allow us to write the full list of Players
	//from a Country in the case of file serialization.
	//In the case of database we have the freedom to send down
	//only the Player objects which need to be updated in the
	//database.
	public void write(ArrayList<Player> players);

	public ArrayList<Player> read();

}
