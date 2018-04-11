package project.Models;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import project.Models.Game.Game;

public class Category {
	
	private int ID;
	private String name;
	private ArrayList<Game> listOfGames = new ArrayList<>();
	private AtomicInteger count = new AtomicInteger((int)Math.random());
	
	public Category(String name)
	{
		this.name = name ;
		ID = count.incrementAndGet() ;
	}
	public Category()
	{
		ID = count.incrementAndGet() ;
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Game> getListOfGames() {
		return listOfGames;
	}
	public void addGame(Game game) {
		listOfGames.add(game);
	}

}
