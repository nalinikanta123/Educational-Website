package project.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import project.Models.Game.Game;
import project.Models.Game.GameDetails;

@Service
public class GameService {

	static ArrayList<String> templates = new ArrayList<>();
	public static ArrayList<GameDetails>listOfGameDetails = new ArrayList<GameDetails>();
	
	
	public GameService() {
		listOfGameDetails = new ArrayList<>();
	}
	public static GameDetails getGameDetails(int id) {
		for (int i = 0; i < listOfGameDetails.size(); i++) {
			if (id == listOfGameDetails.get(i).getGameID()) {
				return listOfGameDetails.get(i);
			}
		}
		return new GameDetails();
	}
	public static void addGameDetails(GameDetails gameDetails) {
		listOfGameDetails.add(gameDetails);
	}

	public static Game getGame(int id) {
		return CategoryService.getGame(id);
	}

	public static void addGame(Game game) {
		CategoryService.addGame(game);
	}
	public static void updateScore() {
		// TODO 
	}
}
