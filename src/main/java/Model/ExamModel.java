package Model;

import Controller.ExamController.Exam;
import Controller.QuestionController.Question;
import Controller.UserController.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExamModel {

    public static Exam exam;

    public static void addExam(Exam exam) {

        String Query = "INSERT into Exam(exam_id, exam_name, exam_grade) VALUES (" + "'" + exam.getId() + "'" + ", " + "'" + exam.getName() + "'" + " ," + "'" + exam.getGrade() + "'" + ") ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void setGrade(Exam exam) {

        String Query = "UPDATE Exam SET exam_grade = " + exam.getGrade() + " WHERE exam_id = " + exam.getId() + ";";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }



    public double getGrade(Exam exam){
        double grade = 0;
        ResultSet result;
        String str ="";
        String Query = "SELECT exam_grade FROM Exam WHERE exam_id ='" + exam.getId() + "';";

        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            grade = result.getDouble(1);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return grade ;
    }


    public ArrayList<String> listQuestions(int exam){
        ResultSet result;
        ArrayList<String> questions = new ArrayList<>();

        String Query = "SELECT  question_id , user_answer1 , user_answer2 , user_answer3 , question FROM Question Where exam_id ='" + exam + "';";
        try {


            result =  DBConnection.connection.createStatement().executeQuery(Query);
            int sira = result.getMetaData().getColumnCount();

            while(result.next()){
                for(int i = 1 ; i<= sira; i++){
                    questions.add(result.getString(i));
                }
            }



        } catch (SQLException e) {

            e.printStackTrace();
        }

        return questions;
    }

    public void removeExam(Exam exam){
        String Query = "DELETE FROM Exam WHERE exam_id =' " + exam.getId() +"' ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void setExamGrade(Exam exam){
        String Query = "UPDATE Exam SET exam_grade = (SELECT SUM(points_earned) FROM Question WHERE exam_id = " + exam.getId() + " ) WHERE exam_id =" + exam.getId() + " ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Exam getExam(int examId){
        ResultSet result;
        ArrayList<String> exam = new ArrayList<>();

        String Query = "SELECT  exam_id , exam_name , exam_grade FROM Exam Where exam_id ='" + examId + "';";
        try {


            result =  DBConnection.connection.createStatement().executeQuery(Query);
            int sira = result.getMetaData().getColumnCount();

            while(result.next()){
                for(int i = 1 ; i<= sira; i++){
                    exam.add(result.getString(i));
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        Exam newExam = new Exam(examId, exam.get(1),Double.parseDouble(exam.get(2)));
        return newExam;
    }
    public ArrayList<Integer> getExamIds(int user_Id){
        ResultSet result;
        ArrayList<Integer> exams = new ArrayList<>();
        int sira;

        String Query = "SELECT  user_exam_id  FROM User Where user_id =" + user_Id + ";";
        try {


            result =  DBConnection.connection.createStatement().executeQuery(Query);
            sira = result.getMetaData().getColumnCount();

            while(result.next()){
                for(int i = 1 ; i<= sira; i++){
                    exams.add(i);
                }
            }



        } catch (SQLException e) {

            e.printStackTrace();
        }

        return exams;
    }


}
