package it.polito.oop.books;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TheoryChapter {
    private String text, title;
    private int numPages;
    // keyword , Topic
    private TreeMap<String, Topic> topics = new TreeMap<>();

    public TheoryChapter(String title, int numPages, String text) {
        this.title = title;
        this.numPages = numPages;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public List<Topic> getTopics() {
        return topics.values().stream().toList();
    }

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
    }

    public void Recursive(Topic t) {
        if(!topics.containsKey(t.getKeyword()))
            topics.put(t.getKeyword(), t);
        if (t.getSubTopics().isEmpty())
            return;
        for (int i = 0; i < t.getSubTopics().size();i++)
            Recursive(t.getSubTopics().get(i));
}

    public void addTopic(Topic topic) {
        Recursive(topic);
    }

}
