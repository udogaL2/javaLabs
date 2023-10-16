package model;

public class Armchair
{
	private String name;
	private String description;
	private String type;

	public Armchair(String name, String description, String type)
	{
		this.name = name;
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

}
