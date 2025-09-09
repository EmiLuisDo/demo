package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "view_unique_students")
public class DistinctStudent {

    @Id
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
