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

    public void setAnswer(int id, String str){
        QuestionModel model = new QuestionModel();
        model.setSelectedAnswer(id,str);
    }


    protected abstract void createQuestion(int id, String question, double points, int examId, String keyAnswer, ArrayList<String> availableAnswers);

}
