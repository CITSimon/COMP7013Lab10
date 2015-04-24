package model;
public class Goalkeeper extends Player
{
	private int noOfCleanSheets;
	
	public Goalkeeper(String name, int age, 
						int internationalCaps, int noOfGoals, int noOfCleanSheets)
	{
		//This is a call to the superclass constructor 
		//(i.e. Player).
		//The Player part of Goalkeeper gets created first, then
		//the rest (i.e. this subclass)
		super(name, age, internationalCaps, noOfGoals);
		this.noOfCleanSheets = noOfCleanSheets;
	}
	public void setNoOfCleanSheets(int noOfCleanSheets)
	{
		this.noOfCleanSheets = noOfCleanSheets;				
	}
	
	public int getNoOfCleanSheets()
	{
		return this.noOfCleanSheets;
	}
	
}
