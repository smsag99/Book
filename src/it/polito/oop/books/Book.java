package it.polito.oop.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Book {
	// topicKeyword, Topic
	TreeMap<String, Topic> topics = new TreeMap<>();
	// title , theory
	TreeMap<String, TheoryChapter> theoryChapters = new TreeMap<>();
	// title, exercise
	TreeMap<String, ExerciseChapter> exerciseChapters = new TreeMap<>();

	/**
	 * Creates a new topic, if it does not exist yet, or returns a reference to the
	 * corresponding topic.
	 * 
	 * @param keyword the unique keyword of the topic
	 * @return the {@link Topic} associated to the keyword
	 * @throws BookException
	 */
	public Topic getTopic(String keyword) throws BookException {
		Topic topic;
		if (keyword == null || keyword.equals(""))
			throw new BookException();
		if (topics.containsKey(keyword)) {
			topic = topics.get(keyword);
		} else {
			topic = new Topic(keyword);
			topics.put(keyword, topic);
		}

		return topic;
	}

	public Question createQuestion(String question, Topic mainTopic) {
		return new Question(question, mainTopic);
	}

	public TheoryChapter createTheoryChapter(String title, int numPages, String text) {
		TheoryChapter t = new TheoryChapter(title, numPages, text);
		theoryChapters.put(title, t);
		return t;
	}

	public ExerciseChapter createExerciseChapter(String title, int numPages) {
		ExerciseChapter e = new ExerciseChapter(title, numPages);
		exerciseChapters.put(title, e);
		return e;
	}

	public List<Topic> getAllTopics() {
		return topics.values().stream().toList();
	}

	public boolean checkTopics() {
		Set<Topic> t = theoryChapters.values().stream().flatMap(x -> x.getTopics().stream())
				.collect(Collectors.toSet());
		Set<Topic> e = exerciseChapters.values().stream().flatMap(x -> x.getTopics().stream())
				.collect(Collectors.toSet());
		return t.containsAll(e);
	}

	public Assignment newAssignment(String ID, ExerciseChapter chapter) {
		return new Assignment(ID, chapter);
	}

	/**
	 * builds a map having as key the number of answers and
	 * as values the list of questions having that number of answers.
	 * 
	 * @return
	 */
	public Map<Long, List<Question>> questionOptions() {
		TreeMap<Long, List<Question>> numAns = new TreeMap<>();
		Set<Question> allQuestions = exerciseChapters.values().stream().flatMap(x -> x.getQuestions().stream())
				.collect(Collectors.toSet());
		for (Question q : allQuestions) {
			if (!numAns.containsKey(q.numAnswers())) {
				numAns.put(q.numAnswers(), new ArrayList<Question>());
			}
			numAns.get(q.numAnswers()).add(q);
		}
		return numAns;
	}
}
