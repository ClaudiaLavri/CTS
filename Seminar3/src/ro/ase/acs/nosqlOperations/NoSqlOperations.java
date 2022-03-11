package src.ro.ase.acs.nosqlOperations;

import com.mongodb.client.MongoDatabase;

public interface NoSqlOperations {
    public void operation(MongoDatabase mongoDb);
}
