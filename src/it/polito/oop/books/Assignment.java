package it.polito.oop.books;

import java.util.List;
import java.util.Set;

public class Assignment {
    private String Id;
    private ExerciseChapter e;
    Double totalScore = 0.0;

    public Assignment(String Id, ExerciseChapter e) {
        this.Id = Id;
        this.e = e;
    }

    public String getID() {
        return Id;
    }

    public ExerciseChapter getChapter() {
        return e;
    }

    public double addResponse(Question q, List<String> answers) {
        
        Set<String> correct = q.getCorrectAnswers();
        int N = (int)q.numAnswers();
        int TP =0;
        for (int i = 0; i < answers.size(); i++) {
            if (correct.contains(answers.get(i)))
                TP++;
        }
        int FP = answers.size() - TP;
        int FN = correct.size() - TP;
        Double score = (double) (N - FP - FN) / (double) N;
        totalScore += score;
        return score;

        //  return (N-FP-FN)/1;
    }

    public double totalScore() {
        return totalScore;
    }

}
