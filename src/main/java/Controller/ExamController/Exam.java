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

}
