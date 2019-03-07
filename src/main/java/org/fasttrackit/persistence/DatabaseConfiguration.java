package org.fasttrackit.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfiguration {

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

        Properties properties = new Properties();

        // try with resources
        // patch
        try (InputStream inputStream =
                     DatabaseConfiguration.class
                             .getClassLoader()
                             .getResourceAsStream("db.properties")) {

            assert inputStream != null;
            properties.load(inputStream);

            // load driver class
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));

            return DriverManager.getConnection(
                    properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD"));
        }
    }

}

