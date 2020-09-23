package com.bormotov.hibernate.service;

import com.bormotov.hibernate.items.Product;
import com.bormotov.hibernate.items.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Service {

    private Product product;
    private User user;
    private static Session session = null;
    private static SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();

    public void addUser(String name) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        user = new User(name);
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        System.out.println("new Person: " + user.getName());

    }

    public void getAllUsers() {
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.getTransaction();
        List<User> users = session.createQuery("select c from User c").getResultList();
        for (User user :
                users) {
            System.out.print(user);
        }
        session.getTransaction().commit();
    }

    public void removeUser(long id) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        user = new User(id);
        session.remove(user);
        session.getTransaction().commit();
        System.out.println("person is delete");

    }

    public void addProduct(String name, int price) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        product = new Product(name, price);
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        System.out.println("new product" + product);
    }

    public void removeProduct(long id) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        product = new Product(id);
        session.remove(product);
        session.getTransaction().commit();
        System.out.println("DELETED \n" + product);
    }

    public void getAllProducts(){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("select p from Product p").getResultList();
        for (Product product:
             products) {
            System.out.println(product);
        }
        session.getTransaction().commit();
    }

    public void close() {
        factory.close();
        if (session != null) {
            session.close();
        }
    }

    public void getAllOrders(){
        System.out.printf(product.getOrders().toString());
    }
}
