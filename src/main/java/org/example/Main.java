package org.example;

import org.example.bean.User;
import org.example.service.UserService;
import org.example.service.UserServiceJDBCImpl;
import org.example.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        script(new UserServiceJDBCImpl());

    }
    public static void script(UserService userService) {
        userService.createUserTable();
        userService.saveUser("Иван" , "Иванов1" , (byte) 17);
        userService.saveUser("Петр" , "Иванов2" , (byte) 16);
        userService.saveUser("Сергей" , "Иванов3" , (byte) 20);
        userService.saveUser("Марк" , "Иванов4" , (byte) 41);

        userService.getAllUsers().forEach(System.out::println);
        userService.removeUserById(4);
        System.out.println("------------");
        userService.getAllUsers().forEach(System.out::println);
        System.out.println("------------");
        userService.clearUserTable();
        userService.getAllUsers().forEach(System.out::println);
        userService.dropUserTable();


    }
}