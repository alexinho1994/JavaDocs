package ro.teamnet.zth.api.database;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alexandru.Grameni on 7/13/2017.
 */
public class DBManagerTest {


    @Test
    public void testConnection()
    {
        int result = DBManager.checkConnection(DBManager.getConnection());

        assertEquals(1, result);
    }

}
