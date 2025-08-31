package com.ravindu.todo.entity;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //Getters and Setters
    public Long getId(){ return id;}
    public void setId(Long id){ this.id = id;}

    public String getTitle() { return title; }
    public void setTitle(String title){this.title = title;}

    public boolean isCompleted() {return completed;}
    public void setCompleted(boolean completed){this.completed = completed;}

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

}
