package com.hiber.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String courseName;

    @OneToMany(mappedBy = "mainCourse")
    private List<stud> students;

    @ManyToMany(mappedBy = "courses")
    private List<stud> enrolledStudents;


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public List<stud> getStudents() { return students; }
    public void setStudents(List<stud> students) { this.students = students; }

    public List<stud> getEnrolledStudents() { return enrolledStudents; }
    public void setEnrolledStudents(List<stud> enrolledStudents) { this.enrolledStudents = enrolledStudents; }
}
