package br.bunk.certificategenerator.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id @GeneratedValue
    private Long id;
    private String description;
    private int workload;
    @OneToMany
    private List<Person> people;

    public Course() {
    }

    public Course(String description, int workload, List<Person> people) {
        this.description = description;
        this.workload = workload;
        this.people = people;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", workload=" + workload +
                ", people=" + people +
                '}';
    }
}
