package src.ro.ase.acs.nosql;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import src.ro.ase.acs.nosqlConnection.NoSqlDBConnection;
import src.ro.ase.acs.nosqlCrud.NoSqlDropOperation;
import src.ro.ase.acs.nosqlCrud.NoSqlInsertOperation;

public class Main {

	public static void main(String[] args) {
		NoSqlDBConnection noSqlDBConnection = new NoSqlDBConnection();
		noSqlDBConnection.connect();


		NoSqlDropOperation noSqlDropOperation = new NoSqlDropOperation();
		noSqlDropOperation.operation(noSqlDBConnection.mongoDb);


		noSqlDBConnection.mongoDb.createCollection("employees");
		
		Document employee1 = new Document().append("name", "Popescu Ion").
				append("address", "Bucharest").append("salary", 4000);
		
		MongoCollection<Document> collection = noSqlDBConnection.mongoDb.getCollection("employees");
		collection.insertOne(employee1);
		
		Document employee2 = new Document().append("name", "Ionescu Vasile").
				append("salary", 4500);
		collection.insertOne(employee2);

		NoSqlInsertOperation noSqlInsertOperation = new NoSqlInsertOperation();
		noSqlInsertOperation.operation(noSqlDBConnection.mongoDb);
		
		FindIterable<Document> result = collection.find();
		for(Document doc : result) {
			System.out.println(doc);
		}

		noSqlDBConnection.disconnect();
	}

}
