package Controller.QuestionController;

public interface AnswerOptionsBehavior {
    void answer();
}

class AnswerMultipleChoice implements AnswerOptionsBehavior {
    public void answer() {
        System.out.println("mutliple choice");
    }
}

class AnswerByDragAndDrop implements AnswerOptionsBehavior {
    public void answer() {
        System.out.println("drag and drop ");
    }
}

class AnswerText implements AnswerOptionsBehavior {
    public void answer() {
        System.out.println("text ");
    }
}

class AnswerTrueFalse implements AnswerOptionsBehavior {
    public void answer() {
        System.out.println("true false ");
    }
}