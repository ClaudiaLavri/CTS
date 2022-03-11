package ro.ase.acs.sql;

import ro.ase.acs.sqlConnection.SqlDbConnection;
import ro.ase.acs.sqlCrud.SqlCreateOperation;
import ro.ase.acs.sqlCrud.SqlInsertOperation;
import ro.ase.acs.sqlCrud.SqlReadOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static final String CLASS = "org.sqlite.JDBC";
	public static final String CONNECTION = "jdbc:sqlite:database.db";
	public static final String DROP_EMPLOYEES = "DROP TABLE IF EXISTS employees";
	public static final String CREATE_EMPLOYEES = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
			+ "name TEXT, address TEXT, salary REAL)";
	public static final String INSERT_EMPLOYEE = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
	public static final String INSERT_WITH_PARAMS = "INSERT INTO employees VALUES (?,?,?,?)";
	public static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employees";

	public static void main(String[] args) {
//		try {
//			Class.forName(CLASS);
//			Connection connection = DriverManager.getConnection(CONNECTION);
//			connection.setAutoCommit(false);
//
//			createTable(connection);
//			insertData(connection);
//			insertDataWithParams(connection);
//			readData(connection);
//
//			connection.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		SqlDbConnection sqlDbConnection = new SqlDbConnection();
		sqlDbConnection.connect();

		SqlCreateOperation sqlCreateOperation = new SqlCreateOperation();
		SqlInsertOperation sqlInsertOperation = new SqlInsertOperation();
		SqlReadOperations sqlReadOperations = new SqlReadOperations();

		sqlCreateOperation.operation(sqlDbConnection.connection);
		sqlInsertOperation.operation(sqlDbConnection.connection);
		sqlReadOperations.operation(sqlDbConnection.connection);


		sqlDbConnection.disconnect();
	}

	private static void createTable(Connection connection) throws SQLException {
		String sqlDrop = DROP_EMPLOYEES;
		String sqlCreate = CREATE_EMPLOYEES;
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlDrop);
		statement.executeUpdate(sqlCreate);
		statement.close();
		connection.commit();
	}
	
	private static void insertData(Connection connection) throws SQLException {
		String sqlInsert = INSERT_EMPLOYEE;
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlInsert);
		statement.close();

		String sqlInsertWithParams = INSERT_WITH_PARAMS;
		PreparedStatement preparedStatement =
				connection.prepareStatement(sqlInsertWithParams);
		preparedStatement.setInt(1, 2);
		preparedStatement.setString(2, "Ionescu Vasile");
		preparedStatement.setString(3, "Brasov");
		preparedStatement.setDouble(4, 4500);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
		connection.commit();
	}

	
	private static void readData(Connection connection) throws SQLException {
		String sqlSelect = SELECT_ALL_EMPLOYEES;
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sqlSelect);
		printResult(rs);
		rs.close();
		statement.close();
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

