package project.Models.Game;

import java.util.concurrent.atomic.AtomicInteger;

public class GameDetails {
	private String name;
	private String resources;
	private String description;
	private String templateName;
	private int gameID;
	private int numOfRates;
	private int numOfQuestions;
	private int creatorID;
	private String categoryName;
	private double score;
	private double rate;
	private double ratingSum;
	private byte[] photo;

	private static AtomicInteger count = new AtomicInteger(0);

	public GameDetails() {
		gameID = count.incrementAndGet();
	}

	public void updateRating(double rate) {

		numOfRates++;
		ratingSum += rate;
		this.rate = ratingSum / (numOfRates * 1.0);
	}

	public int getGameID() {
		return gameID;
	}

	public double getRating() {
		return rate;
	}

	public int getCreator() {
		return creatorID;
	}

	public void setCreator(int id) {
		creatorID = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {

		this.categoryName = categoryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getNumOfQuestions() {
		return numOfQuestions;
	}

	public void setNumOfQuestions(int numOfQuestions) {
		this.numOfQuestions = numOfQuestions;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String type) {
		this.templateName = type;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}