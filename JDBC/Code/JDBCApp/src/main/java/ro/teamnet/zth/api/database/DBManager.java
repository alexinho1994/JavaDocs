package ro.teamnet.zth.api.database;

import javafx.embed.swt.SWTFXUtils;

import java.sql.*;

/**
 * Created by Alexandru.Grameni on 7/13/2017.
 */
public class DBManager {

    public static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private DBManager()
    {
        throw new UnsupportedOperationException();
    }

    private static void registerDriver()
    {
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        registerDriver();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, DBProperties.USER, DBProperties.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int checkConnection(Connection connection)
    {
        int result = 0;
        String SQL = "SELECT 1 FROM DUAL";
        try(Statement stmt = connection.createStatement())
        {
            ResultSet res = stmt.executeQuery(SQL);
            while(res.next())
                result = res.getInt(1);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

}
