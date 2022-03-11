package ro.ase.acs.sqlConnection;

import ro.ase.acs.connection.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDbConnection implements DbConnection {
    public static final String CLASS = "org.sqlite.JDBC";
    public static final String CONNECTION = "jdbc:sqlite:database.db";
    public Connection connection;

    @Override
    public void connect() {
        this.connection = null;
        try {
            Class.forName(CLASS);
            this.connection = DriverManager.getConnection(CONNECTION);
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
