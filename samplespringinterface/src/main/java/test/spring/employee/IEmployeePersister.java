package test.spring.employee;

public interface IEmployeePersister {
    EmployeeResponse createEmployee(EmployeeRequest request);
}
