import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatExceptionTest {
    @Test
    void testPlatException()
    {
        PlatException e = new PlatException("Teste");
        Assertions.assertEquals("PlatException: Teste", e.getMessage());
    }
}