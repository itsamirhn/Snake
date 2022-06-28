package model;

import utilitis.SUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private static final String USERS_FILE_PATH = "./.users.toml";

    public static final ArrayList<User> allUsers = loadUsers();

    private String firstName;
    private String lastName;

    private int highestScore = 0;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        User.allUsers.add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public static ArrayList<User> loadUsers() {
        try {
            List<User> users = SUtils.loadTOML(USERS_FILE_PATH).getList("users");
            return new ArrayList<>(users);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public static void saveUsers() {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("users", User.allUsers);
            SUtils.saveToTOML(USERS_FILE_PATH, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
