package Controller.QuestionController.Factory;

import Controller.QuestionController.Question;
import Model.QuestionModel;

import java.util.ArrayList;

public class TrueFalseQuestionFactory extends QuestionFactory {

    @Override
    protected void createQuestion(int id, String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers) {
        Question.TrueFalseQuestion newQuestion = new Question.TrueFalseQuestion();
        newQuestion.setId(id);
        newQuestion.setQuestion(question);
        newQuestion.setPoints(points);
        newQuestion.setExamId(examId);
        newQuestion.setKeyAnswer(keyAnswer);
        newQuestion.setAvailableAnswers(availableAnswers);

        QuestionModel model = new QuestionModel();
        model.addTrueFalseQuestion(newQuestion);
    }
}
