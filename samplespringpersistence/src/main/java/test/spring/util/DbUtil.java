package test.spring.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.spring.SpringProPersistenceException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class DbUtil implements IDbUtil {

    private static final Logger LOGGER = Logger.getLogger(DbUtil.class);
    private DataSource dataSourceOraBE;

    @Override
    public void sequenceGenerator() {

        String createQuery = "CREATE SEQUENCE employee_seq START WITH 9999 INCREMENT BY 1";
        try (
                Connection connection = dataSourceOraBE.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(createQuery)

        ) {
            connection.setAutoCommit(false);
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Connection " +connection);
        } catch (final SQLException e) {
            LOGGER.error("sequenceGenerator>>SQLException : ", e);
            throw new SpringProPersistenceException("Technical Problem", e);
        }
    }


    @Autowired
    public void setDataSourceOraBE(DataSource dataSourceOraBE) {
        this.dataSourceOraBE = dataSourceOraBE;
    }
}