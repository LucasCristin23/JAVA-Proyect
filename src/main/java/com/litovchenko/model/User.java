package com.litovchenko.model;

import lombok.Getter;

public class User {
    private String username;
    private String password;
    private String email;
    private String name;

    //Constructors
    public User (String username, String password, String email, String name){
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[username= " + username + ", password= " + password + ", email= " + email + ", name= " + name + "]";
    }
}
