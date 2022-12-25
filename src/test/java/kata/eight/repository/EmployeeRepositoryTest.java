package kata.eight.repository;

import kata.eight.App;
import kata.eight.bean.Employee;
import kata.eight.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@DataJpaTest
@ContextConfiguration(classes = {Employee.class, EmployeeRepository.class, App.class, AppConfig.class})
@Slf4j
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private Employee employee;

    @BeforeEach
    public void setUp() {
        assertThat(entityManager).isNotNull();
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
        assertTrue(repository.findByLastName("Parker").contains(employee));
        log.info("employee" + employee);
        log.info("Employee in Repo" + repository.findByLastName("Parker"));
    }

    @Test
    public void testNegative() {
        assertFalse(repository.findByLastName("Abigail").contains(employee));
    }

    @AfterEach
    public void destroy() {
        entityManager = null;
        repository = null;
        employee = null;
    }
}
