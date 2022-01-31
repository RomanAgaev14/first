package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;


public class Main {
    private static final UserService userService = new UserServiceImpl();
    private static final User us1 = new User("Vasya", "Pipkin", (byte) 17);
    private static final User us2 = new User("Alesha", "Popovich", (byte) 188);
    private static final User us3 = new User("Makson", "Galkin", (byte) 46);
    private static final User us4 = new User("Nikita", "Jigurda", (byte) 68);
    private static final User us5 = new User("Cristiano", "Ronaldo", (byte) 36);

    public static void main(String[] args) {
        userService.createUsersTable();
        userService.saveUser(us1.getName(), us1.getLastName(), us1.getAge());
        userService.saveUser(us2.getName(), us2.getLastName(), us2.getAge());
        userService.saveUser(us3.getName(), us3.getLastName(), us3.getAge());
        userService.saveUser(us4.getName(), us4.getLastName(), us4.getAge());
        userService.saveUser(us5.getName(), us5.getLastName(), us5.getAge());
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}


