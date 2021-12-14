package Controller.QuestionController;

import Controller.QuestionController.Factory.MultipleChoiceQuestionFactory;

import java.util.ArrayList;

public abstract class Question {

    GradingBehavior gradingBehavior;

    public int id;
    public String question;
    public double points;
    public int examId;
    public String type;
    public boolean isTrue;
    public String keyAnswer;
    public String selectedAnswer;
    public ArrayList<String> availableAnswers;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public String getKeyAnswer() {
        return keyAnswer;
    }

    public void setKeyAnswer(String keyAnswer) {
        this.keyAnswer = keyAnswer;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public ArrayList<String> getAvailableAnswers() {
        return availableAnswers;
    }

    public void setAvailableAnswers(ArrayList<String> availableAnswers) {
        this.availableAnswers = availableAnswers;
    }

    public static class TextQuestion extends Question {
        public TextQuestion(){
            gradingBehavior = new GradeByInstructor();
            type = "text";
        }
        @Override
        public void display() {

        }
    }

    public static class TrueFalseQuestion extends Question {
        public TrueFalseQuestion(){
            gradingBehavior = new GradeBySystem();
            type = "true_false";
        }
        @Override
        public void display() {

        }
    }

    public static class MultipleChoiceQuestion extends Question {
        public MultipleChoiceQuestion(){
            gradingBehavior = new GradeBySystem();
            type = "multiple_choice";
        }
        @Override
        public void display() {
        }
    }


}
