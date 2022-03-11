package src.ro.ase.acs.nosqlCrud;

import com.mongodb.client.MongoDatabase;
import src.ro.ase.acs.nosqlOperations.NoSqlOperations;

public class NoSqlDropOperation implements NoSqlOperations {

    @Override
    public void operation(MongoDatabase mongoDb) {
        if(mongoDb.getCollection("employees") != null) {
            mongoDb.getCollection("employees").drop();
        }
    }
}
