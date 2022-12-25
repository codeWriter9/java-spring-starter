package kata.eight.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Employee.class)
public class EmployeeTest {

    @Autowired
    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee.setLastName("Parker");
        employee.setFirstName("Peter");
    }

    @Test
    public void testEmployee() {
        assertThat(employee).isNotNull();
        Assertions.assertTrue(employee.getLastName().equals("Parker"));
        Assertions.assertTrue(employee.getFirstName().equals("Peter"));
    }

    @AfterEach
    public void destroy() {
        employee = null;
    }
}
