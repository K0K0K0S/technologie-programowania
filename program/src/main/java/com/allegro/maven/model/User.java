package com.allegro.maven.model;

public class User
{
    private int id;
    private String username;
    private String password;
    private String role;

    public User() {}

    public User(int id, String username)
    {
        this.id = id;
        this.username = username;
    }

    // Gettery i settery
}