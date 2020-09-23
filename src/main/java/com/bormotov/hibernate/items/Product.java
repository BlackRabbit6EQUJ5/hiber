package com.bormotov.hibernate.items;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

   @OneToMany(mappedBy = "product")
    private List<Orders> orders;

    public Product(){

    }

    public Product(String name, int price) {
        this.name = name;
        this.price =price;
    }

    public Product(long id){
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Orders> getOrders() {
        return orders;
    }


    @Override
    public String toString() {
        return  "\n" + "id: " + id + "\n"
                + "name: " + name + "\n"
                + "price: " + price + "\n"
                + "_________________________\n";
    }
}
