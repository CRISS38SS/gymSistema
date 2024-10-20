package com.codepulse;

public class Usuario {
    
    private String name;
    private String lastName;
    private String email;
    private String fprint;
    private String subscription;

    
    public Usuario(String name, String lastName, String email, String fprint, String subscription) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.fprint = fprint;
        this.subscription = subscription;
    }


    public Usuario() {
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getFprint() {
        return fprint;
    }


    public void setFprint(String fprint) {
        this.fprint = fprint;
    }


    public String getSubscription() {
        return subscription;
    }


    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }


}