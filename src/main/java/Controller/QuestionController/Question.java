package Controller.QuestionController;

public abstract class Question {

    AnswerOptionsBehavior answerBehavior;
    GradingBehavior gradingBehavior;

    public abstract void display();

    public abstract void setAnswerBehavior();

    public abstract void setGradingBehavior();


}
