package Controller.QuestionController.Factory;

import Controller.QuestionController.Question;
import Model.QuestionModel;

import java.util.ArrayList;

public class MultipleChoiceQuestionFactory extends QuestionFactory {

    @Override
    protected void createQuestion( String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers) {
        Question.MultipleChoiceQuestion newQuestion = new Question.MultipleChoiceQuestion();
        newQuestion.setQuestion(question);
        newQuestion.setPoints(points);
        newQuestion.setExamId(examId);
        newQuestion.setKeyAnswer(keyAnswer);
        newQuestion.setAvailableAnswers(availableAnswers);

        QuestionModel model = new QuestionModel();
        model.addMultipleChoiceQuestion(newQuestion);
    }

    @Override
    protected void editQuestion(int questionId, String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers) {
        Question.MultipleChoiceQuestion newQuestion = new Question.MultipleChoiceQuestion();
        newQuestion.setId(questionId);
        newQuestion.setQuestion(question);
        newQuestion.setPoints(points);
        newQuestion.setExamId(examId);
        newQuestion.setKeyAnswer(keyAnswer);
        newQuestion.setAvailableAnswers(availableAnswers);

        QuestionModel model = new QuestionModel();
        model.updateMultipleChoiceQuestion(newQuestion);
    }

    protected void setPoints(int examId,int question_id, double points){
        QuestionModel Model = new QuestionModel();
        Model.setPointsBySystem(examId);
    };
}
