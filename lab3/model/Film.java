package model;

public final class Film
{
	private String title;
	private String description;
	private int duration;

	public Film(String title, String description, int duration)
	{
		this.title = title;
		this.description = description;
		this.duration = duration;
	}

	public String getTitle()
	{
		return title;
	}


	public String getDescription()
	{
		return description;
	}

	public int getDuration()
	{
		return duration;
	}

}
