package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.appl.domain.Location;

import java.util.List;
import java.util.Map;

/**
 * Created by Alexandru.Grameni on 7/14/2017.
 */
public class LocationDao {

    EntityManager entityManager;

    public LocationDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Location findById(Long id) {
        Location loc = entityManager.findById(Location.class, id);
        return loc;
    }

    public long getNextIdVal()
    {
        return entityManager.getNextIdVal("Locations", "LOCATION_ID");
    }

    public List<Location> findAll()
    {
        return entityManager.findAll(Location.class);
    }

    public List<Location> findByParams(Map<String, Object> params)
    {
        return entityManager.findByParams(Location.class, params);
    }

    public Location insert(Location loc)
    {
        return (Location) entityManager.insert(loc);
    }

}
