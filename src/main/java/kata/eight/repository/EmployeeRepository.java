package kata.eight.repository;

import kata.eight.bean.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByLastName(String lastName);

    List<Employee> findByAge(int age);

    Employee findByEmail(String email);
}
