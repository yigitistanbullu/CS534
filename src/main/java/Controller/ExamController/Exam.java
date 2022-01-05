package Controller.ExamController;


import Controller.QuestionController.Question;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public interface Exam {

    Time getStartTime();
    Time getEndTime();
    Date getDate();
    int getId();
    String getName();
    double getGrade();
    void setStartTime(Time startTime);
    void setEndTime(Time endTime);
    void setDate(Date date);
    void setId(int id);
    void setName(String name);
    void setGrade(double grade);
    ArrayList<Question> getQuestions();
    void setQuestions(ArrayList<Question> questions);

}
