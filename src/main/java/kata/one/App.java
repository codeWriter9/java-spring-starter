package kata.one;

import lombok.extern.java.Log;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Log
public class App implements CommandLineRunner
{
    public static void main( String[] args )
    {
	    SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception 
    {
        log.info("Hello World!");
    }
}
