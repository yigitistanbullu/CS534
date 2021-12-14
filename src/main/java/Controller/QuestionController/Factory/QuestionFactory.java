package Controller.QuestionController.Factory;

import Controller.QuestionController.Question;

import java.util.ArrayList;

public abstract class QuestionFactory {

    public void addQuestion(){

    }

    public void deleteQuestion(){

    }

    protected abstract Question createQuestion(int id, int examId, double grade, String question, ArrayList<String> answers);

}
