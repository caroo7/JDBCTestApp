package scripts;

public class ScriptsUtil {

    public static String createTable() {
        return "CREATE TABLE PERSON" +
                "(" +
                "ID SERIAL PRIMARY KEY," +
                "NAME varchar(255)," +
                "SURNAME varchar(255)" +
                ");";
    }

    public static String insertRow() {
        return "INSERT INTO PERSON (NAME, SURNAME) VALUES ('KAROL', 'SKUPIEN')";
    }

    public static String insertRow(String name, String surname) {
        return "INSERT INTO PERSON (NAME, SURNAME) VALUES ('" + name + "', '" + surname + "')";
    }

    public static String selectRow() {
        return "SELECT * FROM PERSON WHERE NAME = ? and SURNAME = ?";
    }

    public static String updateRow(String name) {
        return "UPDATE PERSON SET NAME='" + name + "' WHERE NAME='KAROL'";
    }

    public static String deleteRow(String name) {
        return "DELETE FROM PERSON WHERE NAME='" + name + "'";
    }

}