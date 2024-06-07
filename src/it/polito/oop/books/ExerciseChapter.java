package it.polito.oop.books;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class ExerciseChapter {
    private String title;
    private int numPages;
    List<Question> questions = new ArrayList<>();

    public ExerciseChapter(String title, int numPages) {
        this.title = title;
        this.numPages = numPages;
    }


    public List<Topic> getTopics() {
        Set<Topic> topics = new LinkedHashSet<>();
        for (int i = 0; i < questions.size(); i++) {
            topics.add(questions.get(i).getMainTopic());
        }
        return topics.stream().sorted(Comparator.comparing(x->x.toString())).toList();
	};
	

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public int getNumPages() {
        return numPages;
    }
    
    public void setNumPages(int newPages) {
        this.numPages = newPages;
    }
    

    public void addQuestion(Question question) {
        questions.add(question);
    }
    public List<Question> getQuestions() {
        return questions;   
	}	
}
