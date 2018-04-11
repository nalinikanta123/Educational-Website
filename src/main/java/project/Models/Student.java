package project.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Student implements User {

	private double score;
	Account account = new Account();
	public static String className = "Student";
	private Map<Integer, Double> playedGames = new HashMap<Integer, Double>();// gameID,Score

	@Override
	public Account getAccount() {
		return account;
	}

	@Override
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public void addGame(int gameID, double score) {
		playedGames.put(gameID, score);
	}

	@Override
	public double getGameScore(int gameID) {
		return playedGames.get(gameID);
	}

	@Override
	public void updateScore(double score) {
		this.score += score;
	}

	@Override
	public double getScore() {
		return score;
	}

	@Override
	public Map<Integer, Double> getPlayedgames() {
		return playedGames;
	}

	@Override
	public void setPlayedgames(Map<Integer, Double> playedgames) {
		this.playedGames = playedgames;
	}

	@Override
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public void addGame(int gameID) {
	}

	@Override
	public void setCreatedGamesID(ArrayList<Integer> createdGames) {
	}

	@Override
	public ArrayList<Integer> getCreatedGamesID() {
		return null;
	}
}
