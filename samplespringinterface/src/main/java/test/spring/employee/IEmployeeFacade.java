package test.spring.employee;


public interface IEmployeeFacade {
    EmployeeResponse createEmployee(EmployeeRequest request);
    EmployeeResponse getEmployee();
}
