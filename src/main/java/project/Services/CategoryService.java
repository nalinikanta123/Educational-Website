package project.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import project.Models.Category;
import project.Models.Game.Game;
import project.Models.Game.GameDetails;

@Service
public class CategoryService {

	private static ArrayList<Category> listOfCategories = new ArrayList<Category>();

	public static ArrayList<Category> getCategories() {
		return listOfCategories;
	}

	public static void addCategory(Category category) {
		listOfCategories.add(category);
	}

	public static Category getCategory(int id) {
		for (int i = 0; i < listOfCategories.size(); i++) {
			if (listOfCategories.get(i).getID() == id)
				return listOfCategories.get(i);
		}
		return null;
	}

	public static Game getGame(int id) {
		for (int i = 0; i < listOfCategories.size(); i++) {
			Category ith_Category = listOfCategories.get(i);

			for (int j = 0; j < ith_Category.getListOfGames().size(); j++) {
				Game jth_Game = ith_Category.getListOfGames().get(j);

				if (jth_Game.getGameDetails().getGameID() == id)
					return jth_Game;
			}
		}
		return null;
	}

	public static ArrayList<Game> getCategoryGames(int id) {
		for (int i = 0; i < listOfCategories.size(); i++) {
			Category ith_Category = listOfCategories.get(i);

			if (ith_Category.getID() == id)
				return ith_Category.getListOfGames();
		}
		return null;
	}

	public static ArrayList<Game> getCategoryGames(String categoryName) {
		for (int i = 0; i < listOfCategories.size(); i++) {
			Category ith_Category = listOfCategories.get(i);

			if (ith_Category.getName().equals(categoryName))
				return ith_Category.getListOfGames();
		}
		return null;
	}

	public static void addGame(Game game) {
		String categoryName = game.getGameDetails().getCategoryName();

		for (int i = 0; i < listOfCategories.size(); i++) {
			Category ith_Category = listOfCategories.get(i);

			if (ith_Category.getName().equals(categoryName)) {
				listOfCategories.get(i).addGame(game);
			}
		}
	}
	
	public static ArrayList<GameDetails> getGameDetailsOfCategory(String categoryName) {
		for (int i = 0; i < listOfCategories.size(); i++) {
			Category ith_Category = listOfCategories.get(i);
			if (ith_Category.getName().equals(categoryName)) {
				
				ArrayList<GameDetails> listOfGameDetails = new ArrayList<>();
				
				for (int j = 0; j < ith_Category.getListOfGames().size(); j++) {
					Game game = ith_Category.getListOfGames().get(j);
					
					listOfGameDetails.add(game.getGameDetails());
				}
				return listOfGameDetails;
			}
		}
		return new ArrayList<>();
	}
}
