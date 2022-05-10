package main.tests;

import main.model.plats.exceptions.PlatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlatExceptionTest {
    @Test
    void testPlatException()
    {
        PlatException e = new PlatException("Teste");
        Assertions.assertEquals("PlatException: Teste", e.getMessage());
    }
}