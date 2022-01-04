package Model;

import Controller.ExamController.Exam;
import Controller.ExamController.User_Exam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class ExamModel {

    public static Exam exam;

    public static void addExam(String examName, double examGrade, Time startTime, Time endTime, Date date) {

        String Query = "INSERT into Exam(exam_name, exam_grade, exam_start_time, exam_end_time, exam_date) VALUES (" + "'"  + examName + "'" + " ," + "'" + examGrade+ "'"+ " ," + "'" + startTime+ " '," + "'" + endTime + " '," + "'" + date + "') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void addUserExam(Exam exam, int user_id) {

        String Query = "INSERT into User_Exam(user_id, exam_id) VALUES (" +  "'" + user_id + "'" + " ," + "'" + exam.getId() + "'" + ") ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void setGrade(double grade, int examId, int userId) {

        String Query = "UPDATE User_Exam SET exam_grade = '" + grade + "' WHERE exam_id = '" + examId + "' AND user_id = '"+ userId + "';";
        String Query2 = "UPDATE User_Exam SET has_graded = 1 WHERE exam_id = '" + examId + "' AND user_id = '"+ userId + "';";

        try {
            DBConnection.connection.createStatement().execute(Query);
            DBConnection.connection.createStatement().execute(Query2);


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public int getUserExamExamId(User_Exam userExam){
        int id = 0;
        ResultSet result;
        String str ="";
        String Query = "SELECT exam_id FROM UserExam WHERE id ='" + userExam.getId() + "';";

        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            id = result.getInt(1);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return id ;

    }

    public double getGrade(int userId, int examId){
        double grade = 0;
        ResultSet result;
        String str ="";
        String Query = "SELECT exam_grade FROM User_Exam WHERE exam_id = " + examId+ " AND user_id = "+ userId + ";";

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

    public void removeUserExam(int id){
        String Query = "DELETE FROM User_Exam WHERE exam_id =' " + id +"' ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void setExamGrade(int examId){
        String Query = "UPDATE User_Exam SET exam_grade =(SELECT SUM(points_earned) FROM Question WHERE exam_id = " +examId + " ) WHERE exam_id =" + exam.getId() + " ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Exam getExam(int examId){
        ResultSet result;
        ArrayList<String> exam = new ArrayList<>();

        String Query = "SELECT  exam_id , exam_name , exam_grade , exam_start_time, exam_end_time, exam_date FROM Exam Where exam_id ='" + examId + "';";
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
        Exam newExam = new Exam(examId, exam.get(1),Double.parseDouble(exam.get(2)),java.sql.Date.valueOf(exam.get(5)),Time.valueOf(exam.get(3)),Time.valueOf(exam.get(4)));
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

    public int getExamIdFromName(String name){
        int examId = 0;
        ResultSet result;
        String str ="";
        String Query = "SELECT  exam_id  FROM Exam Where exam_name =" + "'" +name + "'" + ";";

        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            examId = result.getInt(1);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return examId ;
    }

    public ArrayList<Integer> getUserExamIds(int userId){
        ResultSet result;
        ArrayList<Integer> examIds = new ArrayList<>();

        String Query = "SELECT exam_id FROM User_Exam Where user_id ='" + userId + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            int sira = result.getMetaData().getColumnCount();

            while(result.next()){
                for(int i = 1 ; i<= sira; i++){
                    examIds.add(Integer.parseInt(result.getString(i)));
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return examIds;
    }

    public ArrayList<Integer> getUserIdsFromExamId(int examId){
        ResultSet result;
        ArrayList<Integer> userIds = new ArrayList<>();

        String Query = "SELECT user_id FROM User_Exam Where exam_id ='" + examId + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            int sira = result.getMetaData().getColumnCount();

            while(result.next()){
                for(int i = 1 ; i<= sira; i++){
                    userIds.add(Integer.parseInt(result.getString(i)));
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return userIds;
    }

    public boolean hasAttendedExam(int userId, int examId){
        ResultSet result;
        boolean hasAttended = false;
        String Query = "SELECT has_attended FROM User_Exam Where exam_id ='" +examId + "' AND user_id = '"+ userId + "';";

        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            hasAttended = result.getBoolean(1);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return hasAttended ;
    }

    public static void attendExam(int userId, int examId){
        String Query = "UPDATE User_Exam SET has_attended = 1 WHERE exam_id = " + examId+ " AND user_id = "+ userId + ";";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}