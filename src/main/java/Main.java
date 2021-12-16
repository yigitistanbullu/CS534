import Controller.ExamController.Exam;
import Controller.QuestionController.Factory.QuestionFactory;
import Controller.QuestionController.Factory.TextQuestionFactory;
import Controller.QuestionController.Factory.TrueFalseQuestionFactory;
import Controller.UserController.MediatorImp;
import Controller.UserController.Password;
import Controller.UserController.User;
import Model.AuthorizationModel;
import Model.DBConnection;
import Model.ExamModel;
import Model.QuestionModel;
import View.LoginView;
import View.RegisterView;
import View.StudentsQuestion.QuestionsPage;
import View.TeachersHomePage;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        DBConnection connection = new DBConnection();
        connection.establishConnection();

        MediatorImp mediator = new MediatorImp();
        AuthorizationModel authorizationModel = new AuthorizationModel();
        Password password = new Password("123");
        User user = new User(mediator, "Yasemin", "Orhun", "yaso@", password, 1, 0) {
            @Override
            public String writeName(String name, String surname) {
                return null;
            }
        };
        System.out.println(authorizationModel.logIn(user));
        Exam exam = new Exam(5,"math",100);
        ExamModel examModel = new ExamModel();


        //authorizationModel.addUser(user);
        ArrayList<String> availableAnswers = new ArrayList<>();
        availableAnswers.add("nothing");
        QuestionFactory factory = new TrueFalseQuestionFactory();
        factory.setSelectedQuestion(5,2,"True");
        factory.setPointsEarnedInstructor(5,2,3);
        examModel.setExamGrade(exam);



        QuestionsPage page = new QuestionsPage(exam,"Yaso");


    }
}
