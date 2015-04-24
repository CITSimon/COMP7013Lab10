package view;

public enum PlayerType {
	STRIKER("A Striker"), 
	GOALKEEPER("A Goalkeeper");
	
	private String stringForUser;
	
	private PlayerType(String stringForUser)
	{
		this.stringForUser = stringForUser;
	}
	
	//Overriding toString from Object
	public String toString()
	{
		return this.stringForUser;
	}
}
