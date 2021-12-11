package Controller.QuestionController;

public interface AnswerOptionsBehavior {
    void setAnswer();
}

class AnswerMultipleChoice implements AnswerOptionsBehavior {
    public void setAnswer() {
        System.out.println("mutliple choice");
    }
}

class AnswerByDragAndDrop implements AnswerOptionsBehavior {
    public void setAnswer() {
        System.out.println("drag and drop ");
    }
}

class AnswerText implements AnswerOptionsBehavior {
    public void setAnswer() {
        System.out.println("text ");
    }
}

class AnswerTrueFalse implements AnswerOptionsBehavior {
    public void setAnswer() {
        System.out.println("true false ");
    }
}