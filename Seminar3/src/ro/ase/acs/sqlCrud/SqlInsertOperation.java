package ro.ase.acs.sqlCrud;

import ro.ase.acs.operations.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInsertOperation implements Operation {
    public static final String INSERT_EMPLOYEE = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
    public static final String INSERT_WITH_PARAMS = "INSERT INTO employees VALUES (?,?,?,?)";

    @Override
    public void operation(Connection connection) {
        String sqlInsert = INSERT_EMPLOYEE;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlInsert);
            statement.close();

            String sqlInsertWithParams = INSERT_WITH_PARAMS;
            preparedStatement =
                    connection.prepareStatement(sqlInsertWithParams);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Ionescu Vasile");
            preparedStatement.setString(3, "Brasov");
            preparedStatement.setDouble(4, 4500);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
