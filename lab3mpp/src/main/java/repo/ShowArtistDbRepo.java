package repo;

import domain.Artist;
import domain.Show;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowArtistDbRepo {
    private ConnectionFactory factory = ConnectionFactory.getFactory();
    private Connection connection =  factory.getConnection();
    private Logger logger =  LogManager.getLogger(ArtistDbRepo.class.getName());

    public List<String> findAll() {
        logger.traceEntry();
        List<String> a = new ArrayList<>();
        String selString = "select * from ShowArtist";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selString);
            while(resultSet.next()){
                a.add(resultSet.getString("IDS") + "-" + resultSet.getString("IDA"));
            }
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logger.traceExit(a);
    }
}
