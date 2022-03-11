package src.ro.ase.acs.operations;

import java.sql.Connection;

public interface Operation {
    void operation(Connection connection);
}
