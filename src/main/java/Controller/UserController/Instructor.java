package Controller.UserController;

public class Instructor extends User {

    public Instructor(Mediator mediator, String name, String lastName, String e_mail, Password password,int id) {
        super(mediator, name, lastName, e_mail, password, id);
    }

    @Override
    public String writeName(String name, String surname){
        this.name = name;
        this.lastName = surname;
        return (this.name + this.lastName);
    }

}
