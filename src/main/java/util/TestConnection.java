package util;

import exceptions.ConnectionEstablishException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {

    private Properties props;

    public TestConnection() {
        loadProperties();
    }

    public Connection establishConnection() throws ConnectionEstablishException {
        try {
            Class.forName(props.getProperty("db.driver"));
        } catch (ClassNotFoundException e) {
            throw new ConnectionEstablishException(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.username"), props.getProperty("db.password"));
            return connection;
        } catch (SQLException e) {
            throw new ConnectionEstablishException(e.getMessage());
        }
    }


    private void loadProperties() {
        props = new Properties();
        try (InputStream stream = getClass().getResourceAsStream("/database.properties")) {
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}