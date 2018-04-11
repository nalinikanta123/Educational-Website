package project.Services;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import project.Models.*;
import project.Models.Game.*;

@Service
public class StudentService extends UserService {

	public ArrayList<Game> getPlayedGames(int userID) {
		Student student = (Student) getUser(userID);
		Map<Integer, Double> games = student.getPlayedgames();

		ArrayList<Game> listOfGames = new ArrayList<Game>();

		for (Entry<Integer, Double> entry : games.entrySet()) {
			int gameID = entry.getKey();
			listOfGames.add(CategoryService.getGame(gameID));
		}

		return listOfGames;
	}

}
