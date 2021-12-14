package Model;

import Controller.QuestionController.Question;

import java.sql.SQLException;

public class QuestionModel {

    public static Question question;

    public static void addTrueFalseQuestion(Question question) {

        String Query = "INSERT into Question(question_id, answer1, answer2, question, grade, exam_id, question_type) VALUES ('" + question.getId()+"','" + question.getAnswers().get(0) +"','" + question.getAnswers().get(1) +"','" + question.getQuestion()+"','" + question.getExamId()+"' ,'" + question.getType()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void addTextQuestion(Question question) {

        String Query = "INSERT into Question(question_id, answer1, answer2, question, grade, exam_id, question_type) VALUES ('" + question.getId()+"','" + question.getAnswers().get(0) +"','" + question.getQuestion()+"','" + question.getExamId()+"' ,'" + question.getType()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void addMultipleChoiceQuestion(Question question) {

        String Query = "INSERT into Question(question_id, answer1, answer2, question, grade, exam_id, question_type) VALUES ('" + question.getId()+"','" + question.getAnswers().get(0) +"','" + question.getAnswers().get(1) +"','" + question.getAnswers().get(2) +"','" + question.getQuestion()+"','" + question.getExamId()+"' ,'" + question.getType()+"') ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public static void deleteQuestion(Question question) {

        String Query = "DELETE FROM Question WHERE question_id = " + question.getId()+ " ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
