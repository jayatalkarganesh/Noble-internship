package com.hiber.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    @OneToOne
    @JoinColumn(name = "stud_id")
    private stud stud;


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public stud getStud() { return stud; }
    public void setStud(stud stud) { this.stud = stud; }
}
