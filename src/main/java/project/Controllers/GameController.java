package project.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.Models.Game.*;
import project.Models.Game.Questions.TrueFalseQuestion;
import project.Services.*;

@Controller
public class GameController {

	@RequestMapping(method = RequestMethod.GET, value = "game/new")
	public String createGameDetails(ModelMap model) {
		model.put("gameDetails", new GameDetails());
		return "game/fillGameDetails";
	}

	@RequestMapping(method = RequestMethod.POST, value = "game/new")
	public String createGame(@ModelAttribute(value = "gameDetails") GameDetails gameDetails) {
		GameService.addGameDetails(gameDetails);
		return "redirect:/game/new/" + gameDetails.getGameID();
	}

	@RequestMapping(method = RequestMethod.GET, value = "game/new/{gameDetailsID}")
	public String createGame(ModelMap model, @PathVariable int gameDetailsID) {
		GameDetails gameDetails = GameService.getGameDetails(gameDetailsID);
		String templateName = gameDetails.getTemplateName();

		Game game = GameFactory.getGame(templateName);

		model.put("game", game);
		return "game/template/create/{templateName}";
	}

	@RequestMapping(method = RequestMethod.POST, value = "game/new/{gameDetailsID}/TrueFalse/{numOfQuestions}")
	public String createTrueFalseGame(@ModelAttribute(value = "questions") ArrayList<TrueFalseQuestion> questions,
			@PathVariable int gameDetailsID, @PathVariable int numOfQuestions) {
		Game game = new TrueFalseGame();
		GameDetails gameDetails = GameService.getGameDetails(gameDetailsID);
		game.setGameDetails(gameDetails);

		int i = 0;
		while (i < numOfQuestions) {
			game.add(questions.get(i));
			++i;
		}
		GameService.addGame(game);
		return "redirect:/category/view/" + gameDetails.getCategoryName();
	}

	@RequestMapping(method = RequestMethod.GET, value = "game/{categoryName}/{gameID}")
	public String playGame(ModelMap model, @PathVariable String categoryName, @PathVariable int gameID) {
		Game game = GameService.getGame(gameID);
		
		int n = game.getGameDetails().getNumOfQuestions();
		ArrayList<String> answers = new ArrayList<String>();
		
		while(n --> 0) {
			answers.add("");
		}
		
		model.put("game", game);
		model.put("answers", answers);

		return "game/template/view/" +  game.getGameDetails().getTemplateName();
	}

	@RequestMapping(method = RequestMethod.POST, value = "game/{categoryName}/{gameID}")
	public String play(ModelMap model, @ModelAttribute(value = "game") Game game,
			@ModelAttribute(value = "answers") ArrayList<String> answers) {
		
		
		GameService.updateScore();
		return "redirect:/home";
	}

}
