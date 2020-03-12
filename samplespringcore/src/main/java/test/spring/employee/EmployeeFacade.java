package test.spring.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFacade implements IEmployeeFacade {


    private IEmployeeFinder employeeFinder;

    private IEmployeePersister employeePersister;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        return employeePersister.createEmployee(request);
    }

    @Override
    public EmployeeResponse getEmployee() {
        return employeeFinder.getEmployee();
    }

    @Autowired
    public void setEmployeeFinder(IEmployeeFinder employeeFinder) {
        this.employeeFinder = employeeFinder;
    }

    @Autowired
    public void setEmployeePersister(IEmployeePersister employeePersister) {
        this.employeePersister = employeePersister;
    }
}
