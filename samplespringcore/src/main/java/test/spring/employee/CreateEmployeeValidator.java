package test.spring.employee;

import org.springframework.stereotype.Component;
import test.spring.util.IValidator;

@Component
public class CreateEmployeeValidator implements IValidator<CreateEmployeeDTO> {

    @Override
    public void validate(CreateEmployeeDTO request) {

    }
}
