package project.Models;

import java.util.ArrayList;
import java.util.Map;

public class Teacher implements User {

	Account account = new Account();
	public static String className = "Teacher";
	private ArrayList<Integer> createdGamesID = new ArrayList<Integer>();

	@Override
	public Account getAccount() {
		return account;
	}

	@Override
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public ArrayList<Integer> getCreatedGamesID() {
		return createdGamesID;
	}

	@Override
	public void addGame(int gameID) {
		createdGamesID.add(gameID);
	}

	@Override
	public void setCreatedGamesID(ArrayList<Integer> createdGames) {
		this.createdGamesID = createdGames;
	}

	@Override
	public void addGame(int gameID, double score) {
	}

	@Override
	public double getGameScore(int gameID) {
		return 0;
	}

	@Override
	public void updateScore(double score) {
	}

	@Override
	public void setScore(double score) {
	}

	@Override
	public double getScore() {
		return 0;
	}

	@Override
	public void setPlayedgames(Map<Integer, Double> playedgames) {
	}

	@Override
	public Map<Integer, Double> getPlayedgames() {
		return null;
	}

}