package repo;

import domain.Show;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ShowDbRepo implements IShowRepo {
    private ConnectionFactory factory = ConnectionFactory.getFactory();
    private Connection connection =  factory.getConnection();
    private Logger logger =  LogManager.getLogger(ArtistDbRepo.class.getName());

    @Override
    public List<Show> findAll() {
        logger.traceEntry();
        List<Show> s = new ArrayList<>();
        String selString = "select * from Show";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selString);
            while(resultSet.next()) {

                String dateString = resultSet.getString("Date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate date = LocalDate.parse(dateString, formatter);

                s.add(new Show(resultSet.getString("ID"), resultSet.getString("Location"), date, Integer.parseInt(resultSet.getString("NoAvailableTickets")), Integer.parseInt(resultSet.getString("NoSoldTickets"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logger.traceExit(s);
    }

    public void modify(Show show){
        logger.traceEntry();
        try {
            String updString = "UPDATE Show SET NoAvailableTickets=?, NoSoldTickets=? where ID="+show.getID();

            PreparedStatement stmt = connection.prepareStatement(updString);
            stmt.setInt(1, show.getNoAvailableTickets());
            stmt.setInt(2, show.getNoSoldTickets());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
