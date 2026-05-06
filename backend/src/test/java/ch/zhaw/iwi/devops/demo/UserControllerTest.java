package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserControllerTest {

    private UserController controller;

    @BeforeEach
    public void setUp() {
        controller = new UserController();
        controller.init();
    }

    @Test
    public void testGetAllUsers() {
        var users = controller.user();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    public void testGetUserById() {
        User user = controller.getUser(1);
        assertNotNull(user);
        assertEquals("Dominic", user.getName());
    }

    @Test
    public void testCreateUser() {
        User newUser = new User(null, "Anna", "anna@zhaw.ch");
        controller.createUser(newUser);
        assertNotNull(controller.getUser(3));
        assertEquals("Anna", controller.getUser(3).getName());
    }

    @Test
    public void testUpdateUser() {
        User updated = new User(1, "Dom Updated", "dom@zhaw.ch");
        controller.updateUser(1, updated);
        assertEquals("Dom Updated", controller.getUser(1).getName());
    }

    @Test
    public void testDeleteUser() {
        User deleted = controller.deleteUser(1);
        assertNotNull(deleted);
        assertNull(controller.getUser(1));
    }
}