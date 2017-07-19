package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Location;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alexandru.Grameni on 7/14/2017.
 */
public class LocationDaoTest {

    LocationDao locationDao = new LocationDao(new EntityManagerImpl());

    @Test
    public void findAllTest()
    {
        assertEquals(23, locationDao.findAll().size());
    }

    @Test
    public void getNextId()
    {
        assertEquals(3201, locationDao.getNextIdVal());
    }

    @Test
    public void findByIdTest()
    {
        Location location = locationDao.findById((long) 1600);
        assertEquals("50090", location.getPostalCode());
    }

    @Test
    public void findParams()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("CITY", "Sydney");
        assertEquals(1, locationDao.findByParams(map).size());
    }

    @Test
    public void insertTest()
    {
        Location location = new Location();
        location.setCity("Roma");
        location.setPostalCode("55555");
        location.setStateProvince("");
        location.setStreetAddress("8204 Arthur St");
        locationDao.insert(location);
        assertEquals(24, locationDao.findAll().size());
    }

}
