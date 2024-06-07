package it.polito.oop.books;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Topic {
	private String keyword;

	// keyword, Topic
	TreeMap<String, Topic> subtopics = new TreeMap<>();

	public Topic(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	@Override
	public String toString() {
		return keyword;
	}

	public boolean addSubTopic(Topic topic) {
		if (subtopics.containsKey(topic.getKeyword()))
			return false;
		subtopics.put(topic.getKeyword(), topic);
		return true;
	}

	/*
	 * Returns a sorted list of subtopics. Topics in the list *MAY* be modified
	 * without
	 * affecting any of the Book topic.
	 */
	public List<Topic> getSubTopics() {
		return subtopics.values().stream().sorted(Comparator.comparing(x->x.toString())).collect(Collectors.toList());
	}
}
