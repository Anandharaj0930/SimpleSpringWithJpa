package test.spring.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.spring.aop.LogOprationCode;
import test.spring.aop.SecurityLogType;
import test.spring.aop.Verification;

@Service
public class EmployeeFinder implements IEmployeeFinder {


    private IEmployeeFinderResponseBuilder responseBuilder;

    @Verification(getOperatinCode = LogOprationCode.EMP_GET, type = SecurityLogType.SEARCH)
    @Override
    public EmployeeResponse getEmployee() {
        return responseBuilder.getEmployee();
    }

    @Autowired
    public void setResponseBuilder(IEmployeeFinderResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }
}
