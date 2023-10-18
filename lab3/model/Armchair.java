package model;

public class Armchair
{
	private String title;
	private int number;
	private String description;
	private String type;

	public Armchair(String title, String description, String type)
	{
		this.title = title;
		this.description = description;
		this.type = type;
	}

	public String getTitle()
	{
		return title;
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

	public void setNumber(int number)
	{
		this.number = number;
	}
}
