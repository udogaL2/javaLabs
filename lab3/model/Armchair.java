package model;

public class Armchair
{
	private String name;
	private int number;
	private String description;
	private String type;

	public Armchair(String name, int number, String description, String type)
	{
		this.name = name;
		this.number = number;
		this.description = description;
		this.type = type;
	}

	public String getName()
	{
		return name;
	}


	public String getDescription()
	{
		return description;
	}

	public String getType()
	{
		return type;
	}

	public int getNumber()
	{
		return number;
	}
}
