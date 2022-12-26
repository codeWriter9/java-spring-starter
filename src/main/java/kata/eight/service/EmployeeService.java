package kata.eight.service;

import kata.eight.bean.Employee;
import kata.eight.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;


    public boolean saveEmployee(Employee e) {
        try {
            log.info("employee=>"+e);
            repository.save(e);
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return false;
        }
        return true;
    }

    public List<Employee> lastName(String lastName) {
        List<Employee> list = null;
        try {
            log.info("lastName=>"+lastName);
            list = repository.findByLastName(lastName);
            log.info("list=>"+list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return list;
    }

    public List<Employee> all() {
        return (List<Employee>) repository.findAll();
    }
}
