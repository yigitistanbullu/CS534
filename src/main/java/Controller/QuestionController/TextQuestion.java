package Controller.QuestionController;

import Controller.QuestionController.Behavior.AnswerText;
import Controller.QuestionController.Behavior.GradeByInstructor;

public class TextQuestion extends Question {

    @Override
    public void display() {

    }

    @Override
    public void setGradingBehavior() {
        gradingBehavior = new GradeByInstructor();
    }

    @Override
    public void setAnswerBehavior() {
        answerBehavior = new AnswerText();
    }
}
