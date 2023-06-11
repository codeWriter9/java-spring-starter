package kata.eight;

import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

/**
 * Unit test for simple App.
 */
@Slf4j
@ActiveProfiles("test")
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    @DisplayName("Dummy Test")
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
	    log.info( "AppTest Loaded" );
    }
}
