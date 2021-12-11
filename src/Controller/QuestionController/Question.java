package Controller.QuestionController;

public abstract class Question {

    AnswerOptionsBehavior answerBehavior;
    GradingBehavior gradingBehavior;

    public abstract void display();

    public void grade() {
        gradingBehavior.grade();
    }

    public void answer() {
        answerBehavior.answer();
    }


    public void setAnswerBehavior(AnswerOptionsBehavior answerBehavior) {
        this.answerBehavior = answerBehavior;
    }

    public void setGradingBehavior(GradingBehavior gradingBehavior) {
        this.gradingBehavior = gradingBehavior;
    }

    class MultipleChoice extends Question {
        MultipleChoice(){
            gradingBehavior = new GradeBySystem();
            answerBehavior = new AnswerMultipleChoice();
        }
        public void display(){};

    }

    class DragAndDrop extends Question {
        DragAndDrop(){
            gradingBehavior = new GradeBySystem();
            answerBehavior = new AnswerByDragAndDrop();
        }
        public void display(){};

    }

    class TextQuestion extends Question {
        TextQuestion(){
            gradingBehavior = new GradeByInstructor();
            answerBehavior = new AnswerText();
        }
        public void display(){};

    }

    class TrueFalse extends Question {
        TrueFalse(){
            gradingBehavior = new GradeBySystem();
            answerBehavior = new AnswerTrueFalse();
        }
        public void display(){};

    }


}
