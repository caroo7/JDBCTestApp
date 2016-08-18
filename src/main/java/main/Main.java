package main;

import exceptions.ConnectionEstablishException;
import scripts.ScriptsUtil;
import util.QueryUtil;
import util.ResultSetUtil;
import util.TestConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private TestConnection connection;

    public static void main(String[] args) {

        TestConnection testConnection = new TestConnection();

        try (Connection conn = testConnection.establishConnection();) {
            QueryUtil queryUtil = new QueryUtil();

            //create table
            //queryUtil.executeQuery(conn, ScriptsUtil.createTable());

            //insert row
            //queryUtil.executeQuery(conn, ScriptsUtil.insertRow());
            //queryUtil.executeQuery(conn, ScriptsUtil.insertRow("Maciek", "Kowalski"));

            //retrieve row based on name and surname
            /*ResultSet personSet = queryUtil.selectWithStringsParameters(conn, ScriptsUtil.selectRow(), "Maciek", "Kowalski");
            while(personSet.next()) {
                System.out.println(personSet.getString("NAME"));
                System.out.println(personSet.getString("SURNAME"));
            }*/

            //update row
            //queryUtil.executeQuery(conn, ScriptsUtil.updateRow("MICHAL"));

            //delete row
            //queryUtil.executeQuery(conn, ScriptsUtil.deleteRow("Maciek"));

            ResultSet personSet = queryUtil.selectWithStringsParameters(conn, ScriptsUtil.selectRow(), "MICHAL", "SKUPIEN");
            ResultSet updatedPersonSet = ResultSetUtil.updateResultSet(personSet, "Karol", "Skupien");
            displayResults(updatedPersonSet);

        } catch (ConnectionEstablishException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayResults(ResultSet personSet) throws SQLException {
        while (personSet.next()) {
            System.out.println(personSet.getString("NAME"));
            System.out.println(personSet.getString("SURNAME"));
        }
    }

}