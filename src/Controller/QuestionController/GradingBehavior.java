package Controller.QuestionController;

public interface GradingBehavior {
    void setGrade();
}

class GradeBySystem implements GradingBehavior {
    public void setGrade() {
        System.out.println("Grade automatically");
    }
}

class GradeByInstructor implements GradingBehavior {
    public void setGrade() {
        System.out.println("Grade by inst");
    }
}