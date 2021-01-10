package br.bunk.certificategenerator.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {

    @Id @GeneratedValue
    private long id;
    private String name;
    @OneToMany
    private Set<PersonDocument> documents;
    @ManyToMany
    private Set<Course> course;

    public Person() {}

    public Person(String name, Set<PersonDocument> documents, Set<Course> course) {
        this.name = name;
        this.documents = documents;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PersonDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<PersonDocument> documents) {
        this.documents = documents;
    }

    public Set<Course> getCourses() {
        return course;
    }

    public void setCourses(Set<Course> courses) {
        this.course = courses;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", documents=" + documents +
                ", courses=" + course +
                '}';
    }
}
