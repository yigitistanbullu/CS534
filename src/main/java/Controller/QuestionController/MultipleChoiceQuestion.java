package Controller.QuestionController;

import Controller.QuestionController.AnswerMultipleChoice;

public class MultipleChoiceQuestion extends Question{

    @Override
    public void display() {

    }

    @Override
    public void setGradingBehavior() {
        gradingBehavior = new GradeBySystem();
    }

    @Override
    public void setAnswerBehavior() {
        answerBehavior = new AnswerMultipleChoice();
    }

}
