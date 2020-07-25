package analyse;

import Connectivity.myConnectSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalesAnalyse {

    Connectivity.myConnectSQL myConnectSQL = new myConnectSQL ();

    public int getTotalSales() throws SQLException, ClassNotFoundException {
        int total_sales = 0;
        Connection connect = myConnectSQL.getConnect ("stock");
        String readQuery = "SELECT * FROM `transactions` ";
        Statement statement = connect.createStatement ();
        ResultSet rs = statement.executeQuery ( readQuery );
        while (rs.next ()) {
            total_sales += rs.getInt ( 2 );
        }
        statement.close ();
        rs.close ();

        return total_sales;
    }
}
