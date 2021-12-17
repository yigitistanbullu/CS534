package Controller.QuestionController.Factory;

import Controller.QuestionController.Question;
import Model.QuestionModel;

import java.util.ArrayList;

public abstract class QuestionFactory {

    public void addQuestion(int id, String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers){
       createQuestion( id, question, points, examId, keyAnswer, availableAnswers);
    }

    public void deleteQuestion(int id){
        QuestionModel model = new QuestionModel();
        model.deleteQuestion(id);
    }

    public void setSelectedQuestion(int examId, int question_id,String str) {
        QuestionModel model = new QuestionModel();
        model.setSelectedAnswer(examId, question_id, str);
    }

    public void setPointsEarnedSystem(int examId){
        setPoints(examId,0,0);
    }

    public void setPointsEarnedInstructor(int examId, int question_id, double points){
        QuestionModel model = new QuestionModel();
        setPoints(examId,question_id, points);
    }

    protected abstract void createQuestion(int id, String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers);
    protected abstract void setPoints(int examId, int question_id, double points);

}
