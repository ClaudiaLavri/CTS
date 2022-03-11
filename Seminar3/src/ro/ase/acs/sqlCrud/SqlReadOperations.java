package src.ro.ase.acs.sqlCrud;

import src.ro.ase.acs.operations.Operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlReadOperations implements Operation {
    public static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employees";

    @Override
    public void operation(Connection connection) {
        String sqlSelect = SELECT_ALL_EMPLOYEES;
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sqlSelect);
            printResult(rs);
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(ResultSet rs) throws SQLException {
        while(rs.next()) {
            int id = rs.getInt("id");
            System.out.println("id: " + id);
            String name = rs.getString(2);
            System.out.println("name: " + name);
            String address = rs.getString("address");
            System.out.println("address: " + address);
            double salary = rs.getDouble("salary");
            System.out.println("salary: " + salary);
        }
    }
}
