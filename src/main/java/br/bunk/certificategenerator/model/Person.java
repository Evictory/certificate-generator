package br.bunk.certificategenerator.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id @GeneratedValue
    private long id;
    private String name;
    @OneToMany
    private Set<PersonDocument> documents = new HashSet<PersonDocument>();

    public Person() {}

    public Person(String name, Set<PersonDocument> documents) {
        this.name = name;
        this.documents = documents;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", documents=" + documents +
                '}';
    }
}
