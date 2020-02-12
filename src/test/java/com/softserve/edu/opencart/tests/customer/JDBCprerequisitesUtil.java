package com.softserve.edu.opencart.tests.customer;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;

import java.sql.*;

public class JDBCprerequisitesUtil {
    private static Connection con = null;
    private static String URL = "jdbc:mysql://172.16.0.131:3306/opencart";

    private static String username = "lv459";
    private static String password = "Lv459_Taqc";


    public static boolean prerequisitesFindUser(IUser user) throws SQLException {
        boolean result = false;
        con = DriverManager.getConnection(URL, username, password);
        if (con != null) {
            System.out.println("Connection Successful! \n");
        } else {
            System.out.println("Connection ERROR \n");
            System.exit(1);
        }
        Statement st = con.createStatement();

        String query = String.format("select * from oc_customer where email like '%s';", user.getEmail());
        ResultSet rs = st.executeQuery(query);

        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(rs.getString(i));
                String line = rs.getString(i);
                if (line!=null && line.equalsIgnoreCase(user.getEmail())) {
                    result = true;
                }
            }

        }
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }

        return result;
    }

    public static void prerequisitesDeleteUser(IUser user) throws SQLException {

        con = DriverManager.getConnection(URL, username, password);
        if (con != null) {
            System.out.println("Connection Successful! \n");
        } else {
            System.out.println("Connection ERROR \n");
            System.exit(1);
        }
        Statement st = con.createStatement();

        //this won't work as password is encrypted - so will create user only by means of page object.
        //        String query = String.format("insert into oc_customer where email like '%s';", user.getEmail());
        String request = String.format("INSERT INTO oc_customer " +
                        "(firstname," +
                        " lastname," +
                        " email," +
                        " telephone," +
                        " fax," +
                        " password) " +
                        "VALUES ('%s','%s','%s',%s, %s);",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getTelephone(),
                user.getFax(),
                user.getPassword());

        String query = String.format("delete from oc_customer where email like '%s';", user.getEmail());
        ResultSet rs = null;
        st.execute(query);

        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
