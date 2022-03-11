package src.ro.ase.acs.sql;


import src.ro.ase.acs.sqlConnection.SqlDbConnection;
import src.ro.ase.acs.sqlCrud.SqlCreateOperation;
import src.ro.ase.acs.sqlCrud.SqlInsertOperation;
import src.ro.ase.acs.sqlCrud.SqlReadOperations;


public class Main {

	public static void main(String[] args) {
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

}

