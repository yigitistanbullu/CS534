package Model;

import Controller.ExamController.Exam;
import Controller.QuestionController.Question;
import Controller.UserController.User;

import java.sql.SQLException;

public class ExamModel {

    public static Exam exam;

    public static void addExam(Exam exam) {

        String Query = "INSERT into Exam(exam_id, exam_name, exam_grade) VALUES (" +"'" + exam.getId()+"'" + ", "+"'" + exam.getName() +"'" +" ," +"'" + exam.getGrade()+"'" + ") ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void setGrade(Exam exam) {

        String Query = "UPDATE tables SET exam_grade = " + exam.getGrade() + " WHERE exam_id = " + exam.getId() + ";";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
