package com.bormotov.hibernate.items;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;




    public User() {

    }

    public User( long id){
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    @Override
    public String toString() {
        return "\n" +"id: " + id + "\n" +
                "name: " + name + "\n"
                +"--------------------------- \n";
    }
}
