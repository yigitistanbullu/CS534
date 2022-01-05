package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.UserController.User;

public class AuthorizationModel {

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

    public static boolean logIn(String email,String password) {

        ResultSet result;
        boolean a = false;
        String Query = "SELECT count(*) AS num_records FROM User WHERE user_email ='" + email +"' && user_password ='" + password + "';";
        try {

           result =  DBConnection.connection.createStatement().executeQuery(Query);
            if (result.next()) {
                // If we got 1 or more matches, this means we successfully
                // authenticated. Otherwise, we failed authentication.
                return result.getInt("num_records") > 0;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return a;
    }
    public static int getUserId(String email, String password){
        ResultSet result;
        String a = "";
        int b = 0;
        String Query = "SELECT user_id FROM User WHERE  user_email ='" + email +"' && user_password ='" + password + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            if(result.next()) {
                b = result.getInt("user_id");

            }

        } catch (SQLException e) {


            e.printStackTrace();
        }
        return b;

    }


    public static String getUserName(String email,String password){

        ResultSet result;
        String a = "";

        String Query = "SELECT user_name FROM User WHERE  user_email ='" + email +"' && user_password ='" + password + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            if(result.next()) {
                a = result.getString("user_name");
            }

        } catch (SQLException e) {


            e.printStackTrace();
        }
        return a;

    }

    public static int getUserType(String email,String password){

        ResultSet result;
        String a = "";
        int b =0;

        String Query = "SELECT user_type FROM User WHERE  user_email ='" + email +"' && user_password ='" + password + "';";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            if(result.next()) {
                b = result.getInt("user_type");
            }

        } catch (SQLException e) {


            e.printStackTrace();
        }
        return b;
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
    public static int getExamId(int id){
        ResultSet result;
        int examId = 0;
        String Query = "SELECT user_exam_id FROM User WHERE user_id = '" + id + "';  ";
        try {

            result =  DBConnection.connection.createStatement().executeQuery(Query);
            if(result.next()){
                examId = result.getInt("user_exam_id");

            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return  examId;
    }

    public static int getUserId(String name){
        int userId = 0;
        ResultSet result;
        String Query = "SELECT user_id FROM User WHERE user_name ='" + name + "';";
        try {
            result =  DBConnection.connection.createStatement().executeQuery(Query);
            result.next();
            userId = Integer.parseInt(result.getString(1));

            if(result.next()){
                userId = result.getInt("user_id");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    public ArrayList<Integer> getUserIds(){
        ResultSet result;
            ArrayList<Integer> userIds = new ArrayList<>();

        String Query = "SELECT  user_id  FROM User Where user_type ='" + 0 + "';";
        try {


            result =  DBConnection.connection.createStatement().executeQuery(Query);
            int sira = result.getMetaData().getColumnCount();

            while(result.next()){
                for(int i = 1 ; i<= sira; i++){
                    userIds.add(Integer.parseInt(result.getString(i)));
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return userIds;
    }

}
