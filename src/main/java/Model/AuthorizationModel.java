package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.ExamController.Exam;
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

    public void removeUser(User user){
        String Query = "DELETE FROM User WHERE user_id =' " + user.getId() +"' ;";
        try {
            DBConnection.connection.createStatement().execute(Query);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static boolean logIn(User user) {

        ResultSet result;
        String username = user.getName();  //txtBox.Text
        String password = user.getPassword().getKey(); //txtBox2.Text
        boolean a = false;
        String Query = "SELECT * FROM User WHERE user_name ='" + username +"' && user_password ='" + password + "';";
        try {

           result =  DBConnection.connection.createStatement().executeQuery(Query);
           if(result.getMetaData().getColumnCount() >= 0){
               a = true;
           }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return a;
    }

    public static String getName(int id){
        ResultSet result;
        String name = "";
        String surname = "";
        String NameQuery = "SELECT user_name, user_surname FROM User WHERE user_id = '" + id + "';  ";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(NameQuery);
            if(result.next()){
                name = result.getString("user_name");
                surname = result.getString("user_surname");

            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return "" + name + " "+ surname;
    }


}
