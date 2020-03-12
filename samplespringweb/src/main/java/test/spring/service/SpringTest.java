package test.spring.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import test.spring.employee.EmployeeRequest;
import test.spring.employee.EmployeeResponse;
import test.spring.employee.IEmployeeFacade;

@RestController
@RequestMapping("/testspring")
public class SpringTest {
    private static final Logger LOGGER = Logger.getLogger(SpringTest.class);

    IEmployeeFacade employeeFacade;

    @PostMapping(path = "/emp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest request) {
        LOGGER.debug("SpringTest >> createEmployee >> request : " + request);
        EmployeeResponse response = employeeFacade.createEmployee(request);
        LOGGER.debug("SpringTest >> createEmployee >> response : " + response);
        return response;
    }

    @GetMapping(path = "/emp", produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeResponse getEmployee() {
        EmployeeResponse employee = employeeFacade.getEmployee();
        LOGGER.debug("Response : " + employee);
        return employee;
    }

    @Autowired
    public void setEmployeeFacade(IEmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }
}
