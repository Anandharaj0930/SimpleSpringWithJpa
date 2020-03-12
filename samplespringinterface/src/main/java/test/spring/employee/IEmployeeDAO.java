package test.spring.employee;

import test.spring.employee.entity.Employee;

public interface IEmployeeDAO {
    Employee saveEmployee(Employee employee);
}
