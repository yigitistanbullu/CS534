package Controller.QuestionController.Factory;

import Controller.QuestionController.Question;
import Model.QuestionModel;

import java.util.ArrayList;

public class GapFillingQuestionFactory extends QuestionFactory {
    @Override
    protected void createQuestion( String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers) {
        Question.GapFillingQuestion newQuestion = new Question.GapFillingQuestion();
        newQuestion.setQuestion(question);
        newQuestion.setPoints(points);
        newQuestion.setExamId(examId);
        newQuestion.setKeyAnswer(keyAnswer);
        newQuestion.setAvailableAnswers(availableAnswers);

        QuestionModel model = new QuestionModel();
        model.addGapFillingQuestion(newQuestion);
    }

    @Override
    protected void editQuestion(int questionId, String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers){
        Question.GapFillingQuestion newQuestion = new Question.GapFillingQuestion();
        newQuestion.setId(questionId);
        newQuestion.setQuestion(question);
        newQuestion.setPoints(points);
        newQuestion.setExamId(examId);
        newQuestion.setKeyAnswer(keyAnswer);
        newQuestion.setAvailableAnswers(availableAnswers);

        QuestionModel model = new QuestionModel();
        model.updateGapFillingQuestion(newQuestion);
    }
}
