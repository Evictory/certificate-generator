package br.bunk.certificategenerator.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {

    @Id @GeneratedValue
    private Long id;
    private String description;
    private int workload;
    @ManyToMany
    private Set<Person> person;

    public Course() {
    }

    public Course(String description, int workload, Set<Person> person) {
        this.description = description;
        this.workload = workload;
        this.person = person;
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

    public Set<Person> getPeople() {
        return person;
    }

    public void setPeople(Set<Person> people) {
        this.person = people;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", workload=" + workload +
                ", people=" + person +
                '}';
    }
}
