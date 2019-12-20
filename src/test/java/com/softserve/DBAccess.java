package com.softserve;
import org.junit.Test;
import java.sql.*;

public class DBAccess {

    protected static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    // TODO - finish with it later
    @Test
    public void testUserDelete() throws ClassNotFoundException {
        Connection connection = null;
        try {Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://172.16.0.128:3306/opencart?serverTimezone=UTC",
                    "lv459",
                    DB_PASSWORD);

            Statement statement = connection.prepareStatement(
                    "select * from opencart.oc_customer");
            ResultSet rs = ((PreparedStatement) statement).executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString("surname") + " - ");
                System.out.println(rs.getInt(1));
                ResultSetMetaData meta =
                        rs.getMetaData(); // отримує метадані таблиці, тип
                // даних і т.д.
                System.out.println(meta.getColumnCount());
                System.out.println(meta.getColumnName(1)); //
                System.out.println(meta.getColumnType(1));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error" + e.getMessage());
                }
            }
        }
    }
}