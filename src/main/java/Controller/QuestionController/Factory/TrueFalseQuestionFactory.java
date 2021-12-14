package Controller.QuestionController.Factory;

import Controller.QuestionController.Question;

import java.util.ArrayList;

public class TrueFalseQuestionFactory extends QuestionFactory {

    @Override
    protected Question createQuestion(int id, int examId, double grade, String question, ArrayList<String> answers) {
        return null;
    }
}
