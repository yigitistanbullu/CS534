package Controller.UserController;

public class MediatorImp implements Mediator {
    @Override
    public void write(User user, String string){
        System.out.println(user.getName());
    }
}
