package Model;

import java.sql.SQLException;
import Controller.UserController.User;

public class AuthorizationModel {

    public static User user;

    public static void addUser(User user) {

        String Query = "INSERT into User(user_name, user_surname, user_email, user_password, user_type, user_exam_id) VALUES (" +"'" + user.getName()+"'" + ", "+"'" + user.getLastName() +"'" +" ," +"'" + user.getE_mail()+"'" + ", " +"'" + user.getPassword().getKey()+ "'" +", " +"'" + user.getUserType() +"'" +", " +"'" + 0 +"'" + ") ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}
