package Controller.UserController;

public abstract class User {

    protected Mediator mediator;
    protected String name;
    protected String lastName;
    protected String e_mail;
    protected Password password;
    protected int userType;
    protected int id;

    public User(String name,String lastName,String e_mail,Password password,int id,int userType){
        this.name = name;
        this.lastName = lastName;
        this.e_mail = e_mail;
        this.password = password;
        this.id = id;
        this.userType = userType;
    }

    public User(Mediator mediator, String name, String lastName, String e_mail, Password password, int id) {
        this.mediator = mediator;
        this.name = name;
        this.lastName = lastName;
        this.e_mail = e_mail;
        this.password = password;
        this.id = id;
    }

    public int getUserType() {
        return userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public abstract void addUser(User user);
    public abstract void setUserType();

}
