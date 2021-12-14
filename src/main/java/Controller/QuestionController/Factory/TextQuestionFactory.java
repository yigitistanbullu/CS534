package Controller.QuestionController.Factory;

import Controller.QuestionController.Question;

import java.util.ArrayList;

public class TextQuestionFactory extends QuestionFactory {

    @Override
    protected Question createQuestion(int id, int examId, double grade, String question, ArrayList<String> answers) {
        Question.TextQuestion qu = new Question.TextQuestion();
        return qu;


    }
}
