package test.spring.employee;

import test.spring.employee.entity.Employee;

public interface IEmployeePersisterResBuilder {
    EmployeeResponse createEmployee(Employee employeeEntity);
}
