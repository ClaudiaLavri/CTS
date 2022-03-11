package src.ro.ase.acs.nosqlCrud;

import com.mongodb.client.MongoDatabase;
import src.ro.ase.acs.nosqlOperations.NoSqlOperations;


public class NoSqlCreateOperation implements NoSqlOperations {
    @Override
    public void operation(MongoDatabase mongoDb) {
        mongoDb.createCollection("employees");
    }
}
