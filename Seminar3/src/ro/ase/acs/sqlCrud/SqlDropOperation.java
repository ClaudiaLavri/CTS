package src.ro.ase.acs.sqlCrud;

import src.ro.ase.acs.operations.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDropOperation implements Operation {
    public static final String DROP_EMPLOYEES = "DROP TABLE IF EXISTS employees";

    @Override
    public void operation(Connection connection) {
        String sqlDrop = DROP_EMPLOYEES;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlDrop);
            statement.close();
            connection.commit();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
