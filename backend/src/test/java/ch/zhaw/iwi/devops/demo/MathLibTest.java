package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MathLibTest {

    @Test
    public void testIsEven() {
        boolean result1 = MathLib.isEven(30);
        assertTrue(result1, "30 should be even");
    }

    @Test
    public void testIsNotEven() {
        boolean result2 = MathLib.isEven(3);
        assertFalse(result2, "3 should not be even");
    }
}
