package kata.eight.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import org.junit.jupiter.api.Test;

@SpringBootTest
@ContextConfiguration(classes = {AppConfig.class, TestConfig.class})
public class AppConfigTest {


	@Autowired
	private AppConfig config;

	@Test
	public void contextLoads() {}
}
