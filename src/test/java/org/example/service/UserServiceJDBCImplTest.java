package org.example.service;


import org.example.bean.User;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceJDBCImplTest {
    private final UserService userService = new UserServiceJDBCImpl();
    private final String testName = "Igor";
    private final String testLastName = "Ivanov";
    private final byte testAge = 12;

    @BeforeEach
    void testTuning() {
        userService.dropUserTable();
        userService.createUserTable();
        userService.saveUser(testName, testLastName, testAge);
    }

    @Test
    void createUserTable() {
//        userService.dropUserTable();
//        assertDoesNotThrow(userService::createUserTable);
        try {
            userService.dropUserTable();
            userService.createUserTable();
        } catch (Exception e) {
            fail("При тестировании создания таблицы произошла ошибка" + e.getMessage());
        }

    }

    @Test
    void dropUserTable() {
        try {
            userService.dropUserTable();
        } catch (Exception e) {
            fail("При удалении таблицы произошла ошибка" + e.getMessage());
        }
    }

    @Test
    void saveUser() {
        try {
            User user = userService.getAllUsers().get(0);
            if (!user.getName().equals(testName) || !user.getLastName().equals(testLastName) || user.getAge() != testAge ) {
                 fail("Пользователь некооректно добавлен в базу");
            }
        } catch (Exception e) {
            fail("При сохранении пользователя произошла ошибка" + e.getMessage());
        }
    }

    @Test
    void removeUserById() {
        try {
            userService.removeUserById(1L);
            assertTrue(userService.getAllUsers().size() != 1);
        } catch (Exception e) {
            fail("При удалении пользователя произошла ошибка" + e.getMessage());
        }
    }

    @Test
    void getAllUsers() {
        try {
            List<User> userList = userService.getAllUsers();
            if (userList.size() != 1) {
                fail("Проверьте корректность сохранения пользователя в таблице");
            }
        } catch (Exception e) {
            fail("При получении пользователя произошла ошибка" + e.getMessage());
        }
    }

    @Test
    void clearUserTable() {
        try {
            userService.clearUserTable();
            if (!userService.getAllUsers().isEmpty()) {
                fail("Метод отчистки реализован некорректно");
            }
        } catch (Exception e) {
            fail("При отчистке таблицы произошла ошибка" + e.getMessage());
        }
    }
}