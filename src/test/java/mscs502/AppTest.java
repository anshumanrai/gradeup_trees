package mscs502;

import org.junit.jupiter.api.Test;
import edu.marist.ds.CONSTANTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Unit test for hello world App template.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    /**
     * Version Test.
     */
    @Test
    void testAppVersion() {
        assertNotEquals(CONSTANTS.getVersion(), "0.0.0");
    }
}
