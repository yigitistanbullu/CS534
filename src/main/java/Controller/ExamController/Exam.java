package Controller.ExamController;


import java.sql.Time;
import java.util.Date;

public interface Exam {

    Time getStartTime();
    Time getEndTime();
    Date getDate();
    int getId();
    String getName();
    double getGrade();

}
