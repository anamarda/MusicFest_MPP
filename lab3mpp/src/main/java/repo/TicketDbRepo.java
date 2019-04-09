package repo;

import domain.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDbRepo implements ITicketsRepo{
    private ConnectionFactory factory = ConnectionFactory.getFactory();
    private Connection connection =  factory.getConnection();
    private Logger logger =  LogManager.getLogger(ArtistDbRepo.class.getName());

    @Override
    public Iterable<Ticket> findAll() {
        logger.traceEntry();
        List<Ticket> t = new ArrayList<>();
        String selString = "select * from Tickets";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selString);
            while(resultSet.next()){
                t.add(new Ticket(resultSet.getString("ID"), resultSet.getString("IDS"), resultSet.getString("Purchaser"), Integer.parseInt(resultSet.getString("NoOfPersons"))));
            }
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logger.traceExit(t);
    }

    public void add(Ticket ticket){
        logger.traceEntry();
        String addString = "insert into Tickets(Purchaser, IDS, NoOfPersons) values ('" +
                ticket.getPurchaser() + "','" + ticket.getIDShow() + "','" + ticket.getNoOfPersons() + "')";
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(addString);
//            ResultSet rs = statement.executeQuery("Select * from Tickets");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.traceExit();
    }
}
