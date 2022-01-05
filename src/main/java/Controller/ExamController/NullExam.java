package Controller.ExamController;

import java.sql.Time;
import java.util.Date;

public class NullExam implements Exam{

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
}
