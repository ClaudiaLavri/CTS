package src.ro.ase.acs.sqlCrud;

import src.ro.ase.acs.operations.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlCreateOperation implements Operation {
    public static final String DROP_EMPLOYEES = "DROP TABLE IF EXISTS employees";
    public static final String CREATE_EMPLOYEES = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
            + "name TEXT, address TEXT, salary REAL)";

    @Override
    public void operation(Connection connection) {
        String sqlCreate = CREATE_EMPLOYEES;
        Statement statement = null;
        SqlDropOperation sqlDropOperation = new SqlDropOperation();
        try {
            sqlDropOperation.operation(connection);
            statement = connection.createStatement();
            statement.executeUpdate(sqlCreate);
            statement.close();
            connection.commit();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
