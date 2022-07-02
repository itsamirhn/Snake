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

    public void login() {
        logout();
        String username = view.showAuth();
        if (username != null) {
            User user = User.getOrCreate(username);
            model.setUser(user);
            view.getSMenuBar().setUser(user);
        }
    }

    public void logout() {
        model.setUser(null);
        view.getSMenuBar().setUser(null);
    }

    public boolean isAuthenticated() {
        return model.getUser() != null;
    }
}
