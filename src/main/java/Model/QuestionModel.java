package Model;

import Controller.ExamController.Exam;
import Controller.QuestionController.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionModel {

    public static void addTrueFalseQuestion(Question question) {

        String Query = "INSERT into Question(question_id, question, points, exam_id, question_type, key_answer) VALUES ('" + question.getId()+"','" + question.getQuestion()+"','" + question.getPoints()+"','" + question.getExamId()+"' ,'" + question.getType()+"','" + question.getKeyAnswer()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void addTextQuestion(Question question) {

        String Query = "INSERT into Question(question_id, user_answer1, question, points, exam_id, question_type, key_answer) VALUES ('" + question.getId()+"','" + question.getAvailableAnswers().get(0) +"','" + question.getQuestion()+"','" + question.getPoints()+"','" + question.getExamId()+"' ,'" + question.getType()+"','" + question.getKeyAnswer()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void addMultipleChoiceQuestion(Question question) {

        String Query = "INSERT into Question(question_id, user_answer1, user_answer2, user_answer3, question, points, exam_id, question_type, key_answer) VALUES ('" + question.getId()+"','" + question.getAvailableAnswers().get(0) +"','" + question.getAvailableAnswers().get(1) +"','" + question.getAvailableAnswers().get(2) +"','" + question.getQuestion()+"','" + question.getPoints()+"','" + question.getExamId()+"' ,'" + question.getType()+"','" + question.getKeyAnswer()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void deleteQuestion(int id) {

        String Query = "DELETE FROM Question WHERE question_id = " + id+ " ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void setSelectedAnswer(int examId, int question_id, String str){

        String Query = "UPDATE Question SET selected_answer = '" + str + "' WHERE exam_id = " + examId + " AND question_id = "  + question_id + ";";
        try {
            DBConnection.connection.createStatement().execute(Query);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void setPointsBySystem(int examId){

        String Query = "UPDATE Question SET points_earned = points WHERE selected_answer = key_answer AND exam_id = " + examId + ";";

        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void setPointsByInstructor(int examId, int question_id, double points){

        String Query = "UPDATE Question SET points_earned = '" + points + "' WHERE exam_id = " + examId + " AND question_id = "  + question_id + ";";

        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public String getQuestionType(int questionId){
        String type = "";
        ResultSet result;
        String str ="";
            String Query = "SELECT question_type FROM Question WHERE question_id ='" + questionId + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            type = result.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    public String getQuestion(int questionId){
        String question = "";
        ResultSet result;
        String Query = "SELECT question FROM Question WHERE question_id ='" + questionId + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            question = result.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public ArrayList<String> getQuestionAnswers(int question_id){
        ResultSet result;
        ArrayList<String> questions = new ArrayList<>();

        String Query = "SELECT  user_answer1 , user_answer2 , user_answer3  FROM Question Where question_id ='" + question_id + "';";
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

        public ArrayList<Integer> getQuestionIds(int exam_id){
        ResultSet result;
        ArrayList<Integer> questions = new ArrayList<>();

        String Query = "SELECT  question_id  FROM Question Where exam_id ='" + exam_id + "';";
        try {


            result =  DBConnection.connection.createStatement().executeQuery(Query);
            int sira = result.getMetaData().getColumnCount();

            while(result.next()){
                for(int i = 1 ; i<= sira; i++){
                    questions.add(Integer.parseInt(result.getString(i)));
                }
            }



        } catch (SQLException e) {

            e.printStackTrace();
        }

        return questions;
    }

    public String getSelectedAnswer(int questionId){
        String selectedAnswer = "";
        ResultSet result;
        String Query = "SELECT selected_answer FROM Question WHERE question_id ='" + questionId + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            selectedAnswer = result.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectedAnswer;
    }

    public String getKeyAnswer(int questionId){
        String keyAnswer = "";
        ResultSet result;
        String Query = "SELECT key_answer FROM Question WHERE question_id ='" + questionId + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            keyAnswer = result.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return keyAnswer;
    }
    public String getAvailablePoints(int questionId){
        String points = "";
        ResultSet result;
        String Query = "SELECT points FROM Question WHERE question_id ='" + questionId + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            points = result.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return points;
    }

}
