package src.ro.ase.acs.nosqlConnection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import src.ro.ase.acs.connection.DbConnection;

public class NoSqlDBConnection implements DbConnection {
    public MongoClient mongoClient;
    public MongoDatabase mongoDb;

    @Override
    public void connect() {
        this.mongoClient = new MongoClient("localhost", 27017);
        this.mongoDb = this.mongoClient.getDatabase("test");
    }

    public void disconnect(){
        this.mongoClient.close();
    }
}
