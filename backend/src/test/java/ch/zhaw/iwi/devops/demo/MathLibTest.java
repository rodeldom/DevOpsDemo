package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MathLibTest {

    @Test
    void testIsEven() {
        assertTrue(MathLib.isEven(30), "30 should be even");
    }

    @Test
    void testIsNotEven() {
        assertFalse(MathLib.isEven(3), "3 should not be even");
    }

    @Test
    void testAdd() {
        assertEquals(10, MathLib.add(3, 7));
    }

    @Test
    void testSubtract() {
        assertEquals(5, MathLib.subtract(10, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(12, MathLib.multiply(3, 4));
    }

    @Test
    void testDivide() {
        assertEquals(5, MathLib.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            MathLib.divide(10, 0);
        });
    }
}