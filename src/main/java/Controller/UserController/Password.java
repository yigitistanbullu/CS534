package Controller.UserController;

public class Password {
    private final static Password password = new Password();

    public Password() {
        System.out.println("Password is created");
    }

    public static Password getPassword() {
        return password;
    }
}
