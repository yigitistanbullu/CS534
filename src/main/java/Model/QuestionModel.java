package Model;

import Controller.QuestionController.Question;

import java.sql.SQLException;

public class QuestionModel {

    public static void addTrueFalseQuestion(Question question) {

        String Query = "INSERT into Question(question_id, user_answer1, user_answer2, question, points, exam_id, question_type) VALUES ('" + question.getId()+"','" + question.getAvailableAnswers().get(0) +"','" + question.getAvailableAnswers().get(1) +"','" + question.getQuestion()+"','" + question.getPoints()+"','" + question.getExamId()+"' ,'" + question.getType()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void addTextQuestion(Question question) {

        String Query = "INSERT into Question(question_id, user_answer1, question, points, exam_id, question_type) VALUES ('" + question.getId()+"','" + question.getAvailableAnswers().get(0) +"','" + question.getQuestion()+"','" + question.getPoints()+"','" + question.getExamId()+"' ,'" + question.getType()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void addMultipleChoiceQuestion(Question question) {

        String Query = "INSERT into Question(question_id, user_answer1, user_answer2, user_answer3, question, points, exam_id, question_type) VALUES ('" + question.getId()+"','" + question.getAvailableAnswers().get(0) +"','" + question.getAvailableAnswers().get(1) +"','" + question.getAvailableAnswers().get(2) +"','" + question.getQuestion()+"','" + question.getPoints()+"','" + question.getExamId()+"' ,'" + question.getType()+"') ;";
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

    public static void setSelectedAnswer(int id, String str){

        String Query = "UPDATE Question SET selected_answer = '" + str + "' WHERE question_id = " + id + ";";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
