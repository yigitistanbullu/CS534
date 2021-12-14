import Controller.UserController.MediatorImp;
import Controller.UserController.Password;
import Controller.UserController.User;
import Model.AuthorizationModel;
import Model.DBConnection;

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


        //authorizationModel.addUser(user);



    }
}
