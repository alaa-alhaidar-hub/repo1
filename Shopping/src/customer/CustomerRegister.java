package customer;

import Connectivity.myConnectSQL;
import Prog1Tools.IOTools;
import shopPackage.RegistrationException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRegister {
    static boolean isRegistered = false;
    static boolean loginSuccess = false;
    static myConnectSQL myConnectSQL = new myConnectSQL ();


    public static void register() throws SQLException, ClassNotFoundException {

        String name = IOTools.readString ( "name: " );
        String vorname = IOTools.readString ( "vorname: " );
        if (vorname.length () < 6) {
            vorname = IOTools.readString ( "vorname: " );
        }
        String email = IOTools.readString ( "email: " );
        if (email.length () < 13 || !(email.contains ( "@" ))) {
            email = IOTools.readString ( "email: " );
        }
        String password = IOTools.readString ( "psw: " );
        if (password.length () < 6) {
            password = IOTools.readString ( "Password: " );
        }
        String kontakt = IOTools.readString ( "kontakt: " );
        Connection connect = myConnectSQL.getConnect ( "customer" );

        String insertQuery =
                "INSERT INTO `customer_reg`(`c_name`,`c_vorname`,`c_email`,`c_psw`,`c_kontakt`) VALUES " +
                        "('" + name + "', '" + vorname + "','" + email + "','" + password + "','" + kontakt + "')";
        Statement statement = connect.createStatement ();
        statement.executeUpdate ( insertQuery );
        statement.close ();
        connect.close ();
        isRegistered = true;
        System.out.println ( " Danke für deine Anmeldung bei Smart Shop\n" );

    }

    public boolean isIsRegistered() {
        return isRegistered;
    }

    public static int login() throws SQLException, ClassNotFoundException, RegistrationException {
        int d = 0;
        String email = IOTools.readString ( "Bitte melden Sie sich wenn Sie bereit regestriert sind" +
                "\nemail: " );
        String password = IOTools.readString ( "psw: " );
        myConnectSQL myConnectSQL = new myConnectSQL ();
        Connection connect = myConnectSQL.getConnect ( "customer" );

        String readQuery = "SELECT * FROM `customer_reg` ";

        Statement statement = connect.createStatement ();
        ResultSet rs = statement.executeQuery ( readQuery );
        while (rs.next ()) {
            if (rs.getString ( 4 ).equals ( email ) &
                    rs.getString ( 5 ).equals ( password )) {

                d = rs.getInt ( 1 );
                isRegistered = true;
                loginSuccess=true;

            } else {
                while (loginSuccess != true) {
                    login ();
                }
            }
        }

        connect.close ();
        statement.close ();
        System.out.println ( "login ist erfolgreich\n" );
        return d;
    }

}
