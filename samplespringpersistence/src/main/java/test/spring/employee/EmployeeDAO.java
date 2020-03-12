package test.spring.employee;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test.spring.SpringProPersistenceException;
import test.spring.employee.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Repository
public class EmployeeDAO implements IEmployeeDAO {

    // private IDbUtil dbUtil;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Employee saveEmployee(Employee employee) {
        try {
            // dbUtil.sequenceGenerator();
            entityManager.persist(employee);
        } catch (final PersistenceException e) {
            throw new SpringProPersistenceException("Empleyee save failed", e);
        }
        return employee;
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    /*@Autowired
    public void setDbUtil(IDbUtil dbUtil) {
        this.dbUtil = dbUtil;
    }*/
}
