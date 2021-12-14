package Controller.QuestionController;

import Controller.QuestionController.Factory.MultipleChoiceQuestionFactory;

import java.util.ArrayList;

public abstract class Question {

    GradingBehavior gradingBehavior;

    public int id;
    public int examId;
    public double grade;
    public String question;
    public String type;
    public ArrayList<String> answers;
    public abstract void display();

    public GradingBehavior getGradingBehavior() {
        return gradingBehavior;
    }
    public void setGradingBehavior(GradingBehavior gradingBehavior) {
        this.gradingBehavior = gradingBehavior;
    }
    public int getId() {
        return id;
    }
    public int getExamId() {
        return examId;
    }
    public String getQuestion() {
        return question;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public ArrayList<String> getAnswers() {
        return answers;
    }


    public static class TextQuestion extends Question {
        public TextQuestion(){
            gradingBehavior = new GradeByInstructor();
        }
        @Override
        public void display() {

        }
    }

    public static class TrueFalseQuestion extends Question {
        public TrueFalseQuestion(){
            gradingBehavior = new GradeBySystem();
        }
        @Override
        public void display() {

        }
    }

    public static class MultipleChoiceQuestion extends Question {
        public MultipleChoiceQuestion(){
            gradingBehavior = new GradeBySystem();
        }
        @Override
        public void display() {
        }
    }


}
