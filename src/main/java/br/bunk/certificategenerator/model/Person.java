package br.bunk.certificategenerator.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id @GeneratedValue
    private long id;
    private String name;
    @OneToMany
    private List<PersonDocument> documents;

    public Person() {}

    public Person(String name, List<PersonDocument> documents) {
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

    public List<PersonDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<PersonDocument> documents) {
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
