package it.polito.oop.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question {
	private String question;
	private Topic mainTopic;
	private List<String> positiveAnswers = new ArrayList<>();
	private List<String> negativeAnswers = new ArrayList<>();

	public Question(String question, Topic mainTopic) {
		this.question = question;
		this.mainTopic = mainTopic;
	}

	public String getQuestion() {
		return question;
	}

	public Topic getMainTopic() {
		return mainTopic;
	}

	public void addAnswer(String answer, boolean correct) {
		if (correct)
			positiveAnswers.add(answer);
		else
			negativeAnswers.add(answer);
	}

	@Override
	public String toString() {
		return question + " (" + mainTopic.getKeyword() + ")";
	}

	public long numAnswers() {
		return negativeAnswers.size()+positiveAnswers.size();
	}

	public Set<String> getCorrectAnswers() {
		return positiveAnswers.stream().collect(Collectors.toSet());
	}

	public Set<String> getIncorrectAnswers() {
		return negativeAnswers.stream().collect(Collectors.toSet());
	}
}
