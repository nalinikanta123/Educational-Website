package project.Models.Game;

import java.util.ArrayList;

import project.Models.Game.Questions.*;


public class MCQGame implements Game{
	private ArrayList<MCQQuestion> questions;
	private GameDetails gameDetails = new GameDetails();
	public final static String gameName = "MCQ";
	public MCQGame() {
		questions = new ArrayList<MCQQuestion>();
		int i = 0;
		while(i < gameDetails.getNumOfQuestions()) {
			questions.add(new MCQQuestion());
			++i;
		}
	}
	public void add(MCQQuestion q) {
		questions.add(q);
	}

	@Override
	public ArrayList<TrueFalseQuestion> getListOfTrueFalseQuestions() {
		return null;
	}
	@Override
	public ArrayList<MCQQuestion> getListOfMCQQuestions() {
		return questions;
	}
	@Override
	public void add(TrueFalseQuestion q) {
	}
	@Override
	public int numOfRightAnswers(ArrayList<String> answers) {
		/*
		int size = questions.size();
		int rightAnswers = 0;
		for (int i = 0; i < size; i++) {
			String rightAnswer = questions.get(i).getAnswer();
			if (answers.get(i).equals(rightAnswer)) {
				++rightAnswers;
			}
		}
		return rightAnswers;
		*/
		// TODO calculate 
		return 0;
	}
	@Override
	public GameDetails getGameDetails() {
		return gameDetails;
	}
	@Override
	public void setGameDetails(GameDetails gameDetails) {
		this.gameDetails = gameDetails;
	}
	@Override
	public String getGameType() {
		return gameName;
	}
}
