package com.hiber.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "stud")
public class stud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "studname")
    private String studname;

    @Column(name = "college")
    private String college;

    @OneToOne(mappedBy = "stud", cascade = CascadeType.ALL)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "main_course_id")
    private Course mainCourse;

    @ManyToMany
    @JoinTable(
        name = "stud_course",
        joinColumns = @JoinColumn(name = "stud_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    public stud() {}

    public stud(long id, String studname, String college) {
        this.id = id;
        this.studname = studname;
        this.college = college;
    }


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getStudname() { return studname; }
    public void setStudname(String studname) { this.studname = studname; }

    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) {
        this.profile = profile;
        profile.setStud(this);
    }

    public Course getMainCourse() { return mainCourse; }
    public void setMainCourse(Course mainCourse) { this.mainCourse = mainCourse; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}
