package Controller.QuestionController;

import Controller.QuestionController.Behavior.AnswerOptionsBehavior;
import Controller.QuestionController.Behavior.GradingBehavior;

public abstract class Question {

    AnswerOptionsBehavior answerBehavior;
    GradingBehavior gradingBehavior;

    public abstract void display();

    public abstract void setAnswerBehavior();

    public abstract void setGradingBehavior();


}
