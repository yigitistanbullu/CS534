package Controller.ExamController;

import Controller.QuestionController.Question;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class NullExam implements Exam{
    public int id;
    public String name;
    public double grade;
    public Time startTime;
    public Time endTime;
    public Date date;

    public NullExam(int id, String name, double grade, Date date, Time startTime, Time endTime)  {
        this.id = id;;
        this.name = name;
        this.grade = grade;
        this.startTime =startTime;
        this.endTime =endTime;
        this.date = date;
        //this.questions = questions;
    }

    @Override
    public Time getStartTime() {
        long now = System.currentTimeMillis();
        Time sqlTime = new Time(now);
        return sqlTime;
    }

    @Override
    public Time getEndTime() {
        long now = System.currentTimeMillis();
        Time sqlTime = new Time(now);
        return sqlTime;    }

    @Override
    public Date getDate() {

        return new Date();
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return " ";
    }

    @Override
    public double getGrade() {
        return 0;
    }

    @Override
    public void setStartTime(Time startTime) {
    }

    @Override
    public void setEndTime(Time endTime) {
    }

    @Override
    public void setDate(Date date) {
    }

    @Override
    public void setId(int id) {
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public void setGrade(double grade) {
    }

    @Override
    public ArrayList<Question> getQuestions() {
        return new ArrayList<>();
    }

    @Override
    public void setQuestions(ArrayList<Question> questions) {
    }
}
