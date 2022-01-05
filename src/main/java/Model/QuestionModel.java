package Model;
import Controller.QuestionController.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionModel {

    public static void addTrueFalseQuestion(Question question) {

        String Query = "INSERT into Question(question, points, exam_id, question_type, key_answer) VALUES ('" + question.getQuestion()+"','" + question.getPoints()+"','" + question.getExamId()+"' ,'" + question.getType()+"','" + question.getKeyAnswer()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void updateTrueFalseQuestion(Question question) {
        String Query = "UPDATE Question SET question = '" + question.getQuestion()+"', points = '" + question.getPoints()+"', key_answer ='" + question.getKeyAnswer()+"' WHERE question_id = " + question.getId() + ";";
        try {
            DBConnection.connection.createStatement().execute(Query);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void addTextQuestion(Question question) {

        String Query = "INSERT into Question(question, points, exam_id, question_type, key_answer) VALUES ('"+ question.getQuestion()+"','" + question.getPoints()+"','" + question.getExamId()+"' ,'" + question.getType()+"','" + question.getKeyAnswer()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void updateTextQuestion(Question question) {
        String Query = "UPDATE Question SET question = '" + question.getQuestion()+"', points = '" + question.getPoints()+"', key_answer ='" + question.getKeyAnswer()+"' WHERE question_id = " + question.getId() + ";";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    public static void addMultipleChoiceQuestion(Question question) {

        String Query = "INSERT into Question(user_answer1, user_answer2, user_answer3, question, points, exam_id, question_type, key_answer) VALUES ('" + question.getAvailableAnswers().get(0) +"','" + question.getAvailableAnswers().get(1) +"','" + question.getAvailableAnswers().get(2) +"','" + question.getQuestion()+"','" + question.getPoints()+"','" + question.getExamId()+"' ,'" + question.getType()+"','" + question.getKeyAnswer()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void updateMultipleChoiceQuestion(Question question) {
        String Query = "UPDATE Question SET user_answer1 = '" + question.getAvailableAnswers().get(0)+"',user_answer2 = '" + question.getAvailableAnswers().get(1)+"',user_answer3 = '" + question.getAvailableAnswers().get(2)+"',question = '" + question.getQuestion()+"', points = '" + question.getPoints()+"', key_answer ='" + question.getKeyAnswer()+"' WHERE question_id = " + question.getId() + ";";

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

    public static String getKeyAnswer(int questionId){
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
    public static String getAvailablePoints(int questionId){
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


    //create User_Answer
    public static void addUserAnswer(String answer, int userId, int questionId, int examId){

        String Query = "INSERT into User_Answer(user_id, question_id, selected_answer, exam_id) VALUES (" + userId+"," + questionId+",'" + answer+"','" + examId+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //create User_Answer
    public static String getUserAnswer(int userId, int questionId){
        String userAnswer = "";
        ResultSet result;
        String Query = "SELECT selected_answer FROM User_Answer WHERE user_id ='" + userId + "' AND question_id ='" + questionId + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            userAnswer = result.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAnswer;
    }

    public static void setPointsBySystem(int user_id, int question_id){

        String key_answer = getKeyAnswer(question_id);
        System.out.println(key_answer);
        String selected_answer = getUserAnswer(user_id,question_id);
        System.out.println(selected_answer);
        double available_points = 0;

        if(key_answer.equals(selected_answer)){
            available_points = Double.parseDouble(getAvailablePoints(question_id));
        }

        String Query = "UPDATE User_Answer SET points_earned =" + available_points + "WHERE user_id = " + user_id + " AND question_id = "  + question_id + ";";

        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void setPointsByInstructor(int user_id, int question_id, double points){

        String Query = "UPDATE User_Answer SET points_earned = '" + points + "' WHERE user_id = " + user_id + " AND question_id = "  + question_id + ";";

        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static String getPointsEarned(int user_id, int question_id){
        String keyAnswer = "";
        ResultSet result;
        String Query = "SELECT points_earned FROM User_Answer WHERE user_id ='" + user_id + "' AND question_id ='" + question_id + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            keyAnswer = result.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return keyAnswer;
    }

}
