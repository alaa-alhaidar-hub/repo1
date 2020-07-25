package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnectSQL {
    public Connection getConnect(String dataBaseName) throws ClassNotFoundException, SQLException {

        Class.forName ( "com.mysql.jdbc.Driver" );

        String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
        String useraname = "root";
        String passWort = "";
        Connection connection;
        connection = DriverManager.getConnection ( url, useraname, passWort );

        return connection;
    }

}


