package Controller.ExamController;

import Controller.QuestionController.Question;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Exam {
    public Exam(int id,String name, double grade, Date date, Time startTime, Time endTime) {
        this.id = id;;
        this.name = name;
        this.grade = grade;
        this.startTime =startTime;
        this.endTime =endTime;
        this.date = date;
        //this.questions = questions;
    }

    public int id;
    public String name;
    public double grade;
    public Time startTime;
    public Time endTime;
    public Date date;

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
