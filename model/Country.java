package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Country implements Serializable
{
	private String nameOfCountry;
	private ArrayList<Player> countryPlayers;
	
	public Country(String nameOfCountry)
	{
		this.nameOfCountry = nameOfCountry;
		this.countryPlayers = new ArrayList<Player>();
		//It is better to initialize the ArrayList
		//here in the constructor rather than pass in a populated
		//ArrayList. That way we start off with an empty
		//container (i.e. Country) into which we can add Players
		//one by one.
	}
	
	public void addPlayer(Player p)
	{
		this.countryPlayers.add(p);
	}
	
	public ArrayList<Player> getPlayers()
	{
		return this.countryPlayers;
	}
	
	public void setPlayers(ArrayList<Player> players)
	{
		this.countryPlayers = players;
	}
	
}
