package Controller.UserController;

public class Password {
    private static String key;
    private final static Password instance = new Password(key);

    public Password(String str) {
        this.key = str;
    }

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        Password.key = key;
    }

    public static Password getInstance() {
        return instance;
    }
}
