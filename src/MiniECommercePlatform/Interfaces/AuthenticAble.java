package MiniECommercePlatform.Interfaces;

import MiniECommercePlatform.Exceptions.EcommerceExceptions;

public interface AuthenticAble {
    void login(String email, String password) throws EcommerceExceptions;
    void logOut();
}
