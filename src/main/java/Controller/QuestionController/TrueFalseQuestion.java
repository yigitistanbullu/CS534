package Controller.QuestionController;

import Controller.QuestionController.Behavior.AnswerText;
import Controller.QuestionController.Behavior.GradeBySystem;

public class TrueFalseQuestion extends Question {

    @Override
    public void display() {

    }

    @Override
    public void setGradingBehavior() {
        gradingBehavior = new GradeBySystem();
    }

    @Override
    public void setAnswerBehavior() {
        answerBehavior = new AnswerText();
    }
}
