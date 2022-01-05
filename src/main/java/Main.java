import Model.DBConnection;
import Model.ExamModel;
import Model.QuestionModel;
import View.LoginView;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    public static void main(String[] args) {

        DBConnection connection = new DBConnection();
        connection.establishConnection();

       /* MediatorImp mediator = new MediatorImp();
        AuthorizationModel authorizationModel = new AuthorizationModel();
        Password password = new Password("123");
        User user = new User(mediator, "Yasemin", "Orhun", "yaso@", password, 1, 0) {
            @Override
            public String writeName(String name, String surname) {
                return null;
            }
        };

        authorizationModel.addUser(user);
        ArrayList<String> answers = new ArrayList<>(){};
        answers.add("test");
        answers.add("test2");
        answers.add("test3");
        QuestionFactory factory = new TextQuestionFactory();
        QuestionFactory multipleChoice = new MultipleChoiceQuestionFactory();
        QuestionFactory trueFalse = new TrueFalseQuestionFactory();

        trueFalse.updateQuestion(3,"testupdate",50,1,"test", answers);
       // multipleChoice.addQuestion("test",20,1,"test",answers);
       // trueFalse.addQuestion("test",20,1,"test",answers);

        //factory.deleteQuestion(3);
        //,factory.setPointsEarnedSystem(3);/factory.setPointsEarnedSystem(5,2,answers.get(0));
        //factory.setPointsEarnedInstructor(5,2,3);*/
        LoginView app = new LoginView();
        app.setVisible(true);

    }
}
