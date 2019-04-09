package repo;

import domain.Artist;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArtistDbRepo implements IArtistRepo {
    private ConnectionFactory factory = ConnectionFactory.getFactory();
    private Connection connection =  factory.getConnection();
    private Logger logger =  LogManager.getLogger(ArtistDbRepo.class.getName());

    @Override
    public List<Artist> findAll() {
        logger.traceEntry();
        List<Artist> a = new ArrayList<>();
        String selString = "select * from Artist";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selString);
            while(resultSet.next()){
                a.add(new Artist(resultSet.getString("ID"), resultSet.getString("Name")));
            }
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logger.traceExit(a);
    }
}
