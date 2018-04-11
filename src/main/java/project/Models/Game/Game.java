package project.Models.Game;

import java.util.ArrayList;
import project.Models.Game.Questions.*;

public interface Game {
	public void add(TrueFalseQuestion q);
	public void add(MCQQuestion q);
	
	public GameDetails getGameDetails();
	public void setGameDetails(GameDetails gameDetails);
	
	public ArrayList<TrueFalseQuestion> getListOfTrueFalseQuestions();
	public ArrayList<MCQQuestion> getListOfMCQQuestions();
	
	public int numOfRightAnswers(ArrayList<String> answers);
	
	public String getGameType();
}