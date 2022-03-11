package src.ro.ase.acs.nosqlCrud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import src.ro.ase.acs.nosqlOperations.NoSqlOperations;

public class NoSqlInsertOperation implements NoSqlOperations {
    @Override
    public void operation(MongoDatabase mongoDb) {
        Document employee1 = new Document().append("name", "Popescu Ion").
                append("address", "Bucharest").append("salary", 4000);

        MongoCollection<Document> collection = mongoDb.getCollection("employees");

        collection.insertOne(employee1);

        Document employee2 = new Document().append("name", "Ionescu Vasile").
                append("salary", 4500);
        collection.insertOne(employee2);
    }
}
