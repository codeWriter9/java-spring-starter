package kata.eight.controller;


import kata.eight.bean.Employee;
import kata.eight.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("EmployeeController")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employee/save")
    public @ResponseBody
    boolean saveEmployee(final @RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @PostMapping("/employee/lastName")
    public @ResponseBody
    List<Employee> employeesByLastName(final @RequestBody String lastName) {
        return service.lastName(lastName);
    }
}
