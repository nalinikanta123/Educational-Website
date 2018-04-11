package project.Models.Game;

public class GameFactory {
	public static Game getGame(String templateName) {
		if (templateName == null) {
			return null;
		}
		if (templateName.equalsIgnoreCase(MCQGame.gameName)) {
			return new MCQGame();

		} else if (templateName.equalsIgnoreCase(TrueFalseGame.gameName)) {
			return new TrueFalseGame();

		}
		return null;
	}
}
