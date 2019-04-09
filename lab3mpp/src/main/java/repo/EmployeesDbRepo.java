package repo;

import domain.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDbRepo implements IEmployeeRepo {
    private ConnectionFactory factory = ConnectionFactory.getFactory();
    private Connection connection =  factory.getConnection();
    private Logger logger =  LogManager.getLogger(ArtistDbRepo.class.getName());

    @Override
    public Iterable<Employee> findAll() {
        logger.traceEntry();
        List<Employee> emp = new ArrayList<>();
        String selString = "select * from Employees";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selString);
            while(resultSet.next()){
                emp.add(new Employee(resultSet.getString("ID"), resultSet.getString("Name"), resultSet.getString("Password")));
            }
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logger.traceExit(emp);
    }

    public Boolean findOne(Employee e){
        logger.traceEntry();

        Boolean found = Boolean.FALSE;
        ResultSet resultSet;
        String findString = "select * from Employees where Name='" + e.getName() +
                "' and Password='" + e.getPassword() + "'";
        try(Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(findString);
            if(resultSet.next()) {
                found = Boolean.TRUE;
            }
//            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return logger.traceExit(found);
    }
}
