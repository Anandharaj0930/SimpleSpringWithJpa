package test.spring.employee;

import org.springframework.stereotype.Repository;
import test.spring.employee.entity.Employee;

@Repository
public class EmployeePersisterResBuilder implements IEmployeePersisterResBuilder {

    @Override
    public EmployeeResponse createEmployee(Employee employeeEnity) {
        EmployeeResponse response = new EmployeeResponse();
        response.setAge(String.valueOf(employeeEnity.getAge()));
        response.setCity(employeeEnity.getCity());
        response.setName(employeeEnity.getName());
        response.setPhoneNo(employeeEnity.getPhoneNumber());
        response.setStreet(employeeEnity.getStreet());
        response.setCode(employeeEnity.getCode());
        return response;
    }
}
