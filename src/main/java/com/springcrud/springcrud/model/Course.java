package com.springcrud.springcrud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    String name;
    @Column
    long price;
    @Column
    String instructor;

    public Course() {
    }

    public Course(String name, long price, String instructor) {
        this.name = name;
        this.price = price;
        this.instructor = instructor;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}
