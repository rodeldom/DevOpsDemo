package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    public void testTooShort() {
        assertFalse(PasswordValidator.isValid("Ab1"));
    }

    @Test
    public void testNoUppercase() {
        assertFalse(PasswordValidator.isValid("abcdefg1"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123"));
    }

}
