package com.bormotov.hibernate;

import com.bormotov.hibernate.service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service userService = new Service();
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        System.out.println("0: end \n"
                + "1: Add user \n"
                + "2: Delete user \n"
                + "3: All users \n"
                + "4: Add product \n"
                + "5: Delete product \n"
                + "6: All Products");

        try {
            while (!flag) {
                switch (scanner.nextInt()) {
                    case 0:
                        flag = true;
                        break;
                    case 1:
                        System.out.println("Введите имя: ");
                        userService.addUser(scanner.next());
                        break;
                    case 2:
                        System.out.println("Введите id");
                        userService.removeUser(scanner.nextLong());
                        break;
                    case 3:
                        userService.getAllUsers();
                        break;
                    case 4:
                        System.out.println("Введите name а затем price");
                        userService.addProduct(scanner.next(),scanner.nextInt());
                        break;
                    case 5:
                        System.out.println("Введите id продукта");
                        userService.removeProduct(scanner.nextInt());
                        break;
                    case 6:
                        userService.getAllProducts();
                        break;
                    case 7:
                        userService.getAllOrders();
                        break;
                }
            }
        } finally {
            scanner.close();
            userService.close();
        }
    }
}
