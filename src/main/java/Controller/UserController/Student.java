package Controller.UserController;

public class Student extends User {
    protected int student_number;

    public Student(Mediator mediator, String name, String lastName, String e_mail, Password password,int student_number) {
        super(mediator, name, lastName, e_mail, password, student_number );
    }

    @Override
    public String writeName(String name, String surname){
        this.name = name;
        this.lastName = surname;
        return (this.name + this.lastName);
    }

}
