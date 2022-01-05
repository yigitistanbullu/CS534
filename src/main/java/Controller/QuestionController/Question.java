package Controller.QuestionController;

import Controller.QuestionController.Factory.MultipleChoiceQuestionFactory;

import java.util.ArrayList;

public abstract class Question {
    QuestionTypeBehavior questionType;

    public int id;
    public String question;
    public double points;
    public int examId;
    public String type;
    public boolean isTrue;
    public String keyAnswer;
    public String selectedAnswer;
    public ArrayList<String> availableAnswers;

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
            questionType = new TextQuestionBehavior();
            this.type = questionType.setQuestionType();
        }
    }

    public static class TrueFalseQuestion extends Question {
        public TrueFalseQuestion(){
            questionType = new TrueFalseQuestionBehavior();
            this.type = questionType.setQuestionType();
        }
    }

    public static class MultipleChoiceQuestion extends Question {
        public MultipleChoiceQuestion(){
            questionType = new MultipleChoiceQuestionBehavior();
            this.type = questionType.setQuestionType();
        }
    }


}
