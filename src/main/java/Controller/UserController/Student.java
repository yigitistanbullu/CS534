package Controller.UserController;

public class Student extends User {
    protected int student_number;

    public Student(Mediator mediator, String name, String lastName, String e_mail, Password password,int student_number) {
        super(mediator, name, lastName, e_mail, password, student_number );
    }

    @Override
    public void addUser(User user) {
        this.mediator.add(this);
    }

    @Override
    public void setUserType() {
        this.userType = 0;
    }


}
