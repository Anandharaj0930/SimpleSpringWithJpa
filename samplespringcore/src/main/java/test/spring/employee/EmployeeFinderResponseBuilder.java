package test.spring.employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFinderResponseBuilder implements IEmployeeFinderResponseBuilder {

    @Override
    public EmployeeResponse getEmployee() {
        EmployeeResponse response = new EmployeeResponse();
        response.setStreet("4/9");
        response.setPhoneNo("9787");
        response.setName("ANandh");
        response.setCity("Chennai");
        response.setAge("28");
        return response;
    }
}
