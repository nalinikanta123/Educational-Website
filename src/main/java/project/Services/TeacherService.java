package project.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import project.Models.Teacher;
import project.Models.Game.Game;

@Service
public class TeacherService extends UserService {

	public ArrayList<Game> getCreatedGames(int userID) {
		Teacher teacher = (Teacher) getUser(userID);
		ArrayList<Integer> games = teacher.getCreatedGamesID();

		ArrayList<Game> listOfGames = new ArrayList<Game>();

		for (int i = 0; i < games.size(); i++) {
			int gameID = games.get(i);
			listOfGames.add(CategoryService.getGame(gameID));
		}

		return listOfGames;
	}

}
