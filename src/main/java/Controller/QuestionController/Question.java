package Controller.QuestionController;

import Controller.QuestionController.Behavior.GradingBehavior;

import java.util.ArrayList;

public abstract class Question {

    GradingBehavior gradingBehavior;

    public int id;
    public int examId;
    public double grade;
    public String question;
    public ArrayList<String> answers;

    public abstract void display();
    public abstract void setGradingBehavior();

}
