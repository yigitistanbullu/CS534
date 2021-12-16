import Controller.ExamController.Exam;
import Controller.UserController.MediatorImp;
import Controller.UserController.Password;
import Controller.UserController.User;
import Model.AuthorizationModel;
import Model.DBConnection;
import Model.ExamModel;
import View.LoginView;
import View.RegisterView;
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
        System.out.println(examModel.listQuestions(exam));
        System.out.println(examModel.getGrade(exam));


        //authorizationModel.addUser(user);
        ArrayList<String> answers = new ArrayList<>(){};
        answers.add("test");
        answers.add("test2");
        answers.add("test3");
        //QuestionFactory factory = new TextQuestionFactory();
        //factory.addQuestion(2,"test",5,5,"test",answers);
        //factory.setSelectedQuestion(5,2,answers.get(0));
        //factory.setPointsEarnedInstructor(5,2,3);
        examModel.setExamGrade(exam);

        LoginView application = new LoginView();

    }
}
