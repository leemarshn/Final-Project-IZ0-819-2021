package jdbcs;

import java.sql.*;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Tuesday 25 January 2022 - 6:29 AM
 */
public class FirstJDBC {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/hirespot";

        try(Connection conn = DriverManager.getConnection(url)){

            PreparedStatement ps = conn.prepareStatement(
                    "SELECT name FROM animal");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                System.out.println(rs.getString(1));
        }

    }

}
