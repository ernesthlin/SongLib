package model;

public class Song 
{
	public String name; 
	public String artist;
	public String year;
	public String album;
	
	public Song(String name, String artist)
	{
		this.name = name;
		this.artist = artist;
		year = "";
		album = "";
	}
	public Song(String name, String artist, String year, String album)
	{
		this.name = name;
		this.artist = artist;
		this.year = year;
		this.album = album;
	}
	
	public String toString()
	{
		return this.name + "\n" + this.artist + "\n" + this.year + "\n" + this.album + "\n";
	}
	
	public String listString()
	{
		return this.name + " - " + this.artist;
	}
}


