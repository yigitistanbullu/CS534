package Controller.QuestionController.Factory;

import Controller.QuestionController.Question;
import Model.QuestionModel;

import java.util.ArrayList;

public class TextQuestionFactory extends QuestionFactory {

    @Override
    protected void createQuestion(int id, String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers) {
        Question.TextQuestion newQuestion = new Question.TextQuestion();
        newQuestion.setId(id);
        newQuestion.setQuestion(question);
        newQuestion.setPoints(points);
        newQuestion.setExamId(examId);
        newQuestion.setKeyAnswer(keyAnswer);
        newQuestion.setAvailableAnswers(availableAnswers);

        QuestionModel model = new QuestionModel();
        model.addTextQuestion(newQuestion);
    }
}
