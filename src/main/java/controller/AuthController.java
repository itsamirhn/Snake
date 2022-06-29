package controller;

import model.SModel;
import model.User;
import view.SView;

public class AuthController {

    private final SModel model;
    private final SView view;

    public AuthController(SModel model, SView view) {
        this.model = model;
        this.view = view;
    }

    public void show() {
        String username = view.showAuth();
        if (username != null) {
            User user = User.getOrCreate(username);
            model.setUser(user);
        }
    }

    public boolean isAuthenticated() {
        return model.getUser() != null;
    }
}
