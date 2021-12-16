package Model;

import Controller.QuestionController.Question;

import java.sql.SQLException;

public class QuestionModel {

    public static void addTrueFalseQuestion(Question question) {

        String Query = "INSERT into Question(question_id, user_answer1, user_answer2, question, points, exam_id, question_type, key_answer) VALUES ('" + question.getId()+"','" + question.getAvailableAnswers().get(0) +"','" + question.getAvailableAnswers().get(1) +"','" + question.getQuestion()+"','" + question.getPoints()+"','" + question.getExamId()+"' ,'" + question.getType()+"','" + question.getKeyAnswer()+"') ;";
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
}
