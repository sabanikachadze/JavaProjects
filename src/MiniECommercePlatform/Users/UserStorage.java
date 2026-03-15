package MiniECommercePlatform.Users;

import MiniECommercePlatform.Exceptions.EcommerceExceptions;
import MiniECommercePlatform.Exceptions.UnauthorizedActionException;

import java.util.ArrayList;

public class UserStorage {
    private final ArrayList<User> users = new ArrayList<>();

    public void addUser(User u) throws EcommerceExceptions {
        if (u == null)
            throw new EcommerceExceptions("User not found");

        for (User user : users) {
            if (user.equals(u))
                throw new EcommerceExceptions("User already exists");
        }

        users.add(u);
        System.out.println("User added");
    }

    public void removeUser(User u) throws EcommerceExceptions {
        if (u == null)
            throw new UnauthorizedActionException("Wrong user");

        for (User user : users) {
            if (user.equals(u)) {
                users.remove(u);
                System.out.println("User removed");
                return;
            }
        }
        throw new EcommerceExceptions("User not found");
    }


    public User findById(String id) throws EcommerceExceptions {
        for (User user : users) {
            if (user.getUserId().equals(id)) return user;
        }
        throw new EcommerceExceptions("User not found: " + id);
    }

    public void printAll() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}

