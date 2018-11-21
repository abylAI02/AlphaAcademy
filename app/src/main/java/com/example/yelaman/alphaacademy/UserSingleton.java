package com.example.yelaman.alphaacademy;

public class UserSingleton {
    private static final UserSingleton ourInstance = new UserSingleton();

    public static UserSingleton getInstance() {
        return ourInstance;
    }

    private User mUser;

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    private UserSingleton() {
    }

    public static UserSingleton getOurInstance() {
        return ourInstance;
    }

}
