import Controller.QuestionController.Factory.QuestionFactory;
import Controller.QuestionController.Factory.TextQuestionFactory;
import Controller.UserController.MediatorImp;
import Controller.UserController.Password;
import Controller.UserController.User;
import Model.AuthorizationModel;
import Model.DBConnection;
import View.EditExamFrame;
import View.LoginView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

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

        //authorizationModel.addUser(user);
        ArrayList<String> answers = new ArrayList<>(){};
        answers.add("test");
        answers.add("test2");
        answers.add("test3");
        QuestionFactory factory = new TextQuestionFactory();
        //factory.addQuestion(3,"",5,5,"test",answers);
        //factory.deleteQuestion(3);
        //factory.setPointsEarnedSystem(3);
        //factory.setPointsEarnedSystem(5,2,answers.get(0));
        //factory.setPointsEarnedInstructor(5,2,3);
        LoginView app = new LoginView();
        app.setVisible(true);

    }
}
