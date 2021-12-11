package Controller.QuestionController;

import Controller.QuestionController.AnswerByDragAndDrop;

public class DragAndDropQuestion extends Question {

    @Override
    public void display() {

    }

    @Override
    public void setGradingBehavior() {
        gradingBehavior = new GradeBySystem();
    }

    @Override
    public void setAnswerBehavior() {
        answerBehavior = new AnswerByDragAndDrop();
    }
}
