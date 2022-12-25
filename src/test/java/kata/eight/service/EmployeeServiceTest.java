package kata.eight.service;

import kata.eight.App;
import kata.eight.bean.Employee;
import kata.eight.config.AppConfig;
import kata.eight.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ContextConfiguration(classes = {Employee.class, EmployeeService.class, EmployeeRepository.class, App.class, AppConfig.class})
@ActiveProfiles("test")
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private Employee employee;

    @BeforeEach
    public void setUp() {
        assertThat(service).isNotNull();
        assertThat(repository).isNotNull();
        assertThat(employee).isNotNull();
        employee.setFirstName("Peter");
        employee.setLastName("Parker");
        employee.setAge(20);
        employee.setEmail("spiderman@web.com");
        employee.setId(1);
        repository.save(employee);
    }

    @Test
    public void testEmployee() {
        assertTrue(service.lastName("Parker").contains(employee));
    }

    @AfterEach
    public void destroy() {
        service = null;
        repository = null;
        employee = null;
    }


}
