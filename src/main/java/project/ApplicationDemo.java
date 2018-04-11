package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import project.Models.Category;
import project.Models.Game.GameDetails;
import project.Models.Game.MCQGame;
import project.Models.Game.TrueFalseGame;
import project.Models.Game.Questions.MCQQuestion;
import project.Models.Game.Questions.TrueFalseQuestion;
import project.Services.CategoryService;
import project.Services.GameService;

@SpringBootApplication
public class ApplicationDemo {

	public static void main(String[] args) {
		
		CategoryService.addCategory(new Category("Math"));
		CategoryService.addCategory(new Category("Sience"));
		CategoryService.addCategory(new Category("Programming"));
		
		TrueFalseQuestion tfQ1 = new TrueFalseQuestion();
		tfQ1.setQuestion("Are you happy?");
		tfQ1.setAnswer(false);
		
		TrueFalseQuestion tfQ2 = new TrueFalseQuestion();
		tfQ2.setQuestion("Are you not happy?");
		tfQ2.setAnswer(true);
		
		GameDetails gameDetails = new GameDetails();
		
		gameDetails.setCategoryName("Math");
		gameDetails.setName("Math Game 1");
		gameDetails.setNumOfQuestions(2);
		gameDetails.setTemplateName("TrueFalse");
		
		TrueFalseGame trueFalseGame = new TrueFalseGame();
		trueFalseGame.setGameDetails(gameDetails);
		
		trueFalseGame.add(tfQ1);
		trueFalseGame.add(tfQ2);
		
		GameService.addGame(trueFalseGame);
		GameService.addGameDetails(gameDetails);
		
		MCQQuestion mcq1 = new MCQQuestion();
		mcq1.setQuestion("Are you happy?");
		mcq1.setAnswer('C');
		
		MCQQuestion mcq2 = new MCQQuestion();
		mcq2.setQuestion("Are you not happy?");
		mcq2.setAnswer('E');
		
		GameDetails gameDetails2 = new GameDetails();
		
		gameDetails2.setCategoryName("Science");
		gameDetails2.setName("Science Game 1");
		gameDetails2.setNumOfQuestions(2);
		gameDetails.setTemplateName("MCQ");
		
		MCQGame mcqGame = new MCQGame();
		mcqGame.setGameDetails(gameDetails2);
		
		mcqGame.add(mcq1);
		mcqGame.add(mcq2);
		
		GameService.addGame(mcqGame);
		GameService.addGameDetails(gameDetails2);
		
		SpringApplication.run(ApplicationDemo.class, args);
	}
}
