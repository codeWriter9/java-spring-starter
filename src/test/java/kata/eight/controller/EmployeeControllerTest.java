package kata.eight.controller;

import kata.eight.App;
import kata.eight.bean.Employee;
import kata.eight.config.AppConfig;
import kata.eight.repository.EmployeeRepository;
import kata.eight.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = {Employee.class, EmployeeService.class,
        EmployeeController.class, EmployeeRepository.class, App.class, AppConfig.class})
@Slf4j
public class EmployeeControllerTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee.setId(1);
        employee.setFirstName("Peter");
        employee.setLastName("Parker");
        employee.setAge(20);
        employee.setEmail("spiderman@web.com");
    }

    @Test
    public void pushEmployee() throws Exception {
        assertThat(this.restTemplate
                .postForObject("http://localhost:" + port + "/employee/save",
                        employee,
                        Boolean.class)).isTrue();
        assertThat(this.restTemplate
                .postForObject("http://localhost:" + port + "/employee/lastName",
                        "Parker",
                        List.class)).isNotNull().isNotEmpty();
        assertThat(this.restTemplate
                .getForObject("http://localhost:" + port + "/employee/all",
                        List.class)).isNotNull().isNotEmpty();
    }

    @AfterEach
    public void destroy() {
        employee = null;
        restTemplate = null;
    }

}
