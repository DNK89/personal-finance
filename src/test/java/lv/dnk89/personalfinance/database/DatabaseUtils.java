package lv.dnk89.personalfinance.database;

import lv.dnk89.personalfinance.database.jdbc.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils extends DAOImpl {

    public void cleanDatabase() throws DBException {
        for (String tableName: getTableNames()) {
            Connection connection = null;
            PreparedStatement statement = null;
            try {
                connection = getConnection();
                String sql = "delete from " + tableName;
                statement = connection.prepareStatement(sql);
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Exception while execute cleanDatabase() for table " + tableName);
                e.printStackTrace();
                throw new DBException(e);
            } finally {
                closeConnectionResources(connection, statement, null);
            }
        }
    }

    private List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        tableNames.add("transactions");
        return tableNames;
    }
}
