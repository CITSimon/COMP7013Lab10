package model;
public class Striker extends Player
{
	private double height;
	
	public Striker(String name, int age, 
					int internationalCaps, int noOfGoals, double height)
	{
		super(name, age, internationalCaps, noOfGoals);
		this.height = height;		
	}
	
	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public double getHeight()
	{
		return this.height;
	}
}
