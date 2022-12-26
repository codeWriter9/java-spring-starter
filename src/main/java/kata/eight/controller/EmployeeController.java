package kata.eight.controller;


import kata.eight.bean.Employee;
import kata.eight.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("EmployeeController")
@Slf4j
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employee/save")
    public @ResponseBody
    boolean saveEmployee(final @RequestBody Employee employee) {
        log.info("employee=>"+employee);
        return service.saveEmployee(employee);
    }

    @PostMapping("/employee/lastName")
    public @ResponseBody
    List<Employee> employeesByLastName(final @RequestBody String lastName) {
        log.info("lastName="+lastName);
        List<Employee> list  = service.lastName(lastName);
        log.info("list=>"+list);
        return list;
    }

    @GetMapping("/employee/all")
    public @ResponseBody List<Employee> employees() {
        return service.all();
    }
}
