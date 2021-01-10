package br.bunk.certificategenerator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Image {

    @Id @GeneratedValue
    private Long id;
    private String description;
    private String path;

    public Image() {}

    public Image(String description, String path) {
        this.description = description;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) && Objects.equals(description, image.description) && Objects.equals(path, image.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, path);
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
