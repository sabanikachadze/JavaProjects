package MiniECommercePlatform.Users;

import MiniECommercePlatform.Exceptions.EcommerceExceptions;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class User {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final String userId;
    private final String name;
    private final String email;
    private final String password;
    private boolean logged;

    public User(String name, String email, String password) {
        this.userId = String.format("USR-%04d", counter.incrementAndGet());
        this.name = name;
        this.email = email;
        this.password = password;
        this.logged = false;
    }


    public void login(String email, String password) throws EcommerceExceptions {
        if (!email.equals(this.email) || !password.equals(this.password))
            throw new EcommerceExceptions("Wrong email or password");
        this.logged = true;
    }
    public void logOut() {
        this.logged = false;
    }



    public String getUserId() {return userId;}
    public String getName() {
        return name;
    }
    public boolean isLoggedIn() {
        return logged;
    }





    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }
}
