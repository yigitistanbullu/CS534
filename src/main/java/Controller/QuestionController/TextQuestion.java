package Controller.QuestionController;

import Controller.QuestionController.AnswerText;

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
