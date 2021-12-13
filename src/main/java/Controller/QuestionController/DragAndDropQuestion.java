package Controller.QuestionController;

import Controller.QuestionController.Behavior.AnswerByDragAndDrop;
import Controller.QuestionController.Behavior.GradeBySystem;

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
