package com.example.royalenfield;

public class User {
    String name,email,phone,user;

    public User(String name, String email, String phone, String user) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUser() {
        return user;
    }
}
