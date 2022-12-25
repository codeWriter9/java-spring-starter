package kata.eight.repository;

import kata.eight.bean.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    public List<Employee> findByLastName(String lastName);
    public List<Employee> findByAge(int age);
    public Employee findByEmail(String email);
}
