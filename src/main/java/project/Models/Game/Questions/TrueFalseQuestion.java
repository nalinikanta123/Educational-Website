package project.Models.Game.Questions;

public class TrueFalseQuestion{
	private String question;
	private boolean answer;
	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
