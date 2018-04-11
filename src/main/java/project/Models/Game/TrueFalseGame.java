package project.Models.Game;

import java.util.ArrayList;
import project.Models.Game.Questions.*;

public class TrueFalseGame implements Game{
	private ArrayList<TrueFalseQuestion> questions;
	private GameDetails gameDetails = new GameDetails();
	public final static String gameName = "TrueFalse";
	public TrueFalseGame() {
		questions = new ArrayList<>();
		int i = 0;
		while(i < gameDetails.getNumOfQuestions()) {
			questions.add(new TrueFalseQuestion());
			++i;
		}
	}
	@Override
	public void add(TrueFalseQuestion q) {
		questions.add(q);
	}

	@Override
	public ArrayList<TrueFalseQuestion> getListOfTrueFalseQuestions() {
		return questions;
	}

	@Override
	public ArrayList<MCQQuestion> getListOfMCQQuestions() {
		return null;
	}

	@Override
	public void add(MCQQuestion q) {		
	}
	@Override
	public int numOfRightAnswers(ArrayList<String> answers) {
		int size = questions.size();
		int rightAnswers = 0;
		for (int i = 0; i < size; i++) {
			boolean rightAnswer = questions.get(i).isAnswer();
			if (answers.get(i).equals("true") && rightAnswer) {
				++rightAnswers;
			}
			if (answers.get(i).equals("false") && !rightAnswer) {
				++rightAnswers;
			}
		}
		return rightAnswers;
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