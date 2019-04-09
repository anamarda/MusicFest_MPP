package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory factory = new ConnectionFactory();
    private List<Connection> connections = new ArrayList<>();
    private Properties props;

    private ConnectionFactory() {
        props = new Properties();
        try {
            props.load(new FileInputStream("src/main/resources/db.props"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        createConnections();
    }

    private void createConnections() {
        for (int i = 0; i < 5; i++) {
            try {
                if (props.getProperty("jdbc.user") == null) {
                    connections.add(DriverManager.getConnection(props.getProperty("jdbc.url")));
                }else{
                    connections.add(DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.user"), props.getProperty("jdbc.pass")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ConnectionFactory getFactory() {
        return factory;
    }

    public Connection getConnection() {
        for (Connection conn : connections) {
            try {
                if (!conn.isClosed()) {
                    return conn;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //alte connexiuni de creat
        throw new IllegalArgumentException();
    }
}
