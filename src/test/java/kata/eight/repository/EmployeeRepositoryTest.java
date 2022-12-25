package kata.eight.repository;

import kata.eight.bean.Employee;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@DataJpaTest
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
        repository.save(employee);
    }

    @Test
    public void testEmployee() {
        assertTrue(repository.findByLastName("Parker").contains(employee));
    }

    @AfterEach
    public void destroy() {
        entityManager = null;
        repository = null;
        employee = null;
    }
}
