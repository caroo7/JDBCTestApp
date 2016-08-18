package util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetUtil {

    public static ResultSet updateResultSet(ResultSet resultSet, String... parameters) throws SQLException {

        if (resultSet.getConcurrency() != ResultSet.CONCUR_UPDATABLE) {
            throw new SQLException("No updatable result set"); // proper exception when result set is not updatable
        }

        resultSet.next();
        resultSet.updateString("name", parameters[0]);
        resultSet.updateString("surname", parameters[1]);
        resultSet.updateRow();

        return resultSet;
    }

}