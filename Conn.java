package electricity_bill;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "Khatri@1234");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
