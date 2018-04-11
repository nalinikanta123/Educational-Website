package project.Models;

import java.util.ArrayList;
import java.util.Map;

public interface User{

	public Account getAccount();
	public void setAccount(Account account);

	//Student
	public double getScore();
	public void setScore(double score);
	double getGameScore(int gameID);
	public void updateScore(double score);
	public void addGame(int gameID, double score);
	public Map<Integer, Double> getPlayedgames();
	public void setPlayedgames(Map<Integer, Double> playedgames);
	
	//Teacher
	public void addGame(int gameID);
	public void setCreatedGamesID(ArrayList<Integer> createdGames);
	public ArrayList<Integer> getCreatedGamesID();
	
}
