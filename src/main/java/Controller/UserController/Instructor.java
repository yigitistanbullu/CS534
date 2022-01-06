package Controller.UserController;

public class Instructor extends User {

    public Instructor(Mediator mediator, String name, String lastName, String e_mail, Password password,int id) {
        super(mediator, name, lastName, e_mail, password, id);
    }

    @Override
    public void addUser(User user) {
        this.mediator.add(this);
    }

    @Override
    public void setUserType() {
        this.userType = 1;
    }

}
