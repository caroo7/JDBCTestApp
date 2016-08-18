package util;

import java.sql.*;

public class QueryUtil {

    public void executeQuery(Connection conn, String query) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param conn already established connection
     * @param query query to execute
     * @param args array of arguments
     * @return record set from database
     */
    public ResultSet selectWithStringsParameters(Connection conn, String query, String... args) {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            for(int i=0; i<args.length; ++i) {
                statement.setString(i+1, args[i]);
            }
            resultSet = statement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet selectWithoutParameters(Connection conn, String query)  {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}