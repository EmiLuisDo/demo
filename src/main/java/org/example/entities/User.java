package org.example.entities;

import jakarta.persistence.*;

@Entity
@SecondaryTable(
        name = "user_details",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    @Column(table = "user_details")
    private String description;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
