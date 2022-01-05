package Controller.ExamController;

import java.sql.Time;
import java.util.Date;

public class ExamFactory {

    public static Exam createExam(int id, String name, double grade, Date date, Time startTime, Time endTime){

        if(id>0){
            return new Examination(id, name, grade, date, startTime, endTime);
        }
        else{
            return new NullExam();
        }

    }
}
