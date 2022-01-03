package Controller.QuestionController.Factory;

import Controller.QuestionController.Question;
import Model.QuestionModel;

import java.util.ArrayList;

public class TrueFalseQuestionFactory extends QuestionFactory {

    @Override
    protected void createQuestion(String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers) {
        Question.TrueFalseQuestion newQuestion = new Question.TrueFalseQuestion();
        newQuestion.setQuestion(question);
        newQuestion.setPoints(points);
        newQuestion.setExamId(examId);
        newQuestion.setKeyAnswer(keyAnswer);
        newQuestion.setAvailableAnswers(availableAnswers);

        QuestionModel model = new QuestionModel();
        model.addTrueFalseQuestion(newQuestion);
    }

    @Override
    protected void editQuestion(int questionId, String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers){
        Question.TrueFalseQuestion newQuestion = new Question.TrueFalseQuestion();
        newQuestion.setId(questionId);
        newQuestion.setQuestion(question);
        newQuestion.setPoints(points);
        newQuestion.setExamId(examId);
        newQuestion.setKeyAnswer(keyAnswer);
        newQuestion.setAvailableAnswers(availableAnswers);

        QuestionModel model = new QuestionModel();
        model.updateTrueFalseQuestion(newQuestion);
    }

    protected void setPoints(int examId,int question_id, double points){
        QuestionModel Model = new QuestionModel();
        Model.setPointsBySystem( examId);
    };
}
