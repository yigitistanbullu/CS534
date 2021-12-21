package Controller.ExamController;

import Controller.QuestionController.Question;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Exam {
    public Exam(int id,String name, double grade) {
        this.id = id;;
        this.name = name;
        this.grade = grade;
        //this.questions = questions;
    }

    public int id;
    public String name;
    public double grade;
    public ArrayList<Question> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }


}
