package model;

import java.io.Serializable;
import java.util.Calendar;

public class Player implements Serializable
{
	private String name;
	private int age;
	private int internationalCaps;
	private int noOfGoals;
	private Calendar dateAdded;
	
	public Player(String name, int age, int internationalCaps, int noOfGoals)
	{
		this.name = name;
		this.age = age;
		this.internationalCaps = internationalCaps;
		this.noOfGoals = noOfGoals;
		this.dateAdded = Calendar.getInstance();		
	}
	
	public Calendar getDateAdded()
	{
		return this.dateAdded;
	}
	
	public void setDateAdded(Calendar dateAdded)
	{
		this.dateAdded = dateAdded;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void setInternationalCaps(int internationalCaps)
	{
		this.internationalCaps = internationalCaps;
	}
	
	public int getInternationalCaps()
	{
		return this.internationalCaps;
	}
	
	public void setNoOfGoals(int noOfGoals)
	{
		this.noOfGoals = noOfGoals;
	}
	
	public int getNoOfGoals()
	{
		return this.noOfGoals;
	}
}
