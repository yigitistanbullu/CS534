import Model.DBConnection;
import Model.ExamModel;
import Model.QuestionModel;
import View.LoginView;


public class Main {

    public static void main(String[] args) {

        DBConnection connection = new DBConnection();
        connection.establishConnection();

        LoginView app = new LoginView();
        app.setVisible(true);


    }
}
