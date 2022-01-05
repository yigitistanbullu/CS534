package Controller.UserController;

import Model.AuthorizationModel;

public class MediatorImp implements Mediator {

    @Override
    public void add(User user) {
        AuthorizationModel model = new AuthorizationModel();
        user.setUserType();
        model.addUser(user);
    }
}
