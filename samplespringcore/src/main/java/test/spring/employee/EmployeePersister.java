package test.spring.employee;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.spring.aop.LogOprationCode;
import test.spring.aop.SecurityLogType;
import test.spring.aop.Verification;
import test.spring.employee.entity.Employee;
import test.spring.util.IValidator;

import java.math.BigDecimal;


@Service
public class EmployeePersister implements IEmployeePersister {

    private static final Logger LOGGER = Logger.getLogger(EmployeePersister.class);
    private IEmployeePersisterResBuilder persisterResBuilder;
    private IValidator<CreateEmployeeDTO> createEmployeeDTOIValidator;
    private IEmployeeDAO employeeDAO;

    @Override
    @Verification(getOperatinCode = LogOprationCode.EMP_CREATE, type = SecurityLogType.INSERT)
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        LOGGER.debug("EmployeePersister >> createEmployee >> request : " + request);
        CreateEmployeeDTO createEmployeeDTO = createEmployeeDTO(request);
        createEmployeeDTOIValidator.validate(createEmployeeDTO);

        Employee employee = buildEmplyeeEntity(createEmployeeDTO);
        //Employee employeeEntity = employeeDAO.saveEmployee(employee);
        LOGGER.debug("EmployeePersister >> createEmployee >> response : " + employee);
        return persisterResBuilder.createEmployee(employee);
    }

    private Employee buildEmplyeeEntity(CreateEmployeeDTO createEmployeeDTO) {
        Employee employeeEntity = new Employee();
        employeeEntity.setAge(new BigDecimal(createEmployeeDTO.getAge()));
        employeeEntity.setCity(createEmployeeDTO.getCity());
        employeeEntity.setCode("EMP01");
        employeeEntity.setCompany(createEmployeeDTO.getCompany());
        employeeEntity.setName(createEmployeeDTO.getName());
        employeeEntity.setPhoneNumber(createEmployeeDTO.getPhoneNo());
        employeeEntity.setStreet(createEmployeeDTO.getStreet());
        return employeeEntity;
    }

    private CreateEmployeeDTO createEmployeeDTO(EmployeeRequest request) {
        CreateEmployeeDTO requestDto = new CreateEmployeeDTO();
        requestDto.setAge(request.getAge());
        requestDto.setCity(request.getCity());
        requestDto.setCompany(request.getCompany());
        requestDto.setName(request.getName());
        requestDto.setPhoneNo(request.getPhoneNo());
        requestDto.setStreet(request.getStreet());
        return requestDto;
    }

    @Autowired
    public void setPersisterResBuilder(IEmployeePersisterResBuilder persisterResBuilder) {
        this.persisterResBuilder = persisterResBuilder;
    }

    @Autowired
    public void setCreateEmployeeDTOIValidator(IValidator<CreateEmployeeDTO> createEmployeeDTOIValidator) {
        this.createEmployeeDTOIValidator = createEmployeeDTOIValidator;
    }

    @Autowired
    public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
