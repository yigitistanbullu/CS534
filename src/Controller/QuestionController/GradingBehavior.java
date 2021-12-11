package Controller.QuestionController;

public interface GradingBehavior {
    void grade();
}

class GradeBySystem implements GradingBehavior {
    public void grade() {
        System.out.println("Grade automatically");
    }
}

class GradeByInstructor implements GradingBehavior {
    public void grade() {
        System.out.println("Grade by inst");
    }
}