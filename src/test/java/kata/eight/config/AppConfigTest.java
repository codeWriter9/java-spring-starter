package kata.eight.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import org.junit.jupiter.api.Test;

@Slf4j
@SpringBootTest
@ContextConfiguration(classes = {AppConfig.class, TestConfig.class})
public class AppConfigTest {


	@Autowired
	private AppConfig config;

	@Test
	@DisplayName("Check if the Context loads")
	public void contextLoads() {
		log.info( " The context Loads! " );
	}
}
