package Controller.QuestionController;

import Controller.QuestionController.AnswerText;

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
