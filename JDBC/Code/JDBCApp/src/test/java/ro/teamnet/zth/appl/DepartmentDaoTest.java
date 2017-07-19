package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alexandru.Grameni on 7/14/2017.
 */
public class DepartmentDaoTest {

    DepartmentDao deptDao = new DepartmentDao(new EntityManagerImpl());

    @Test
    public void findAllTest()
    {
        assertEquals(35, deptDao.findAll().size());
    }

    @Test
    public void getNextId()
    {
        assertEquals(280, deptDao.getNextIdVal());
    }

    @Test
    public void findByIdTest()
    {
        Department dept = deptDao.findById((long) 30);
        assertEquals("Purchasing", dept.getDepartmentName());
    }

    @Test
    public void findParams()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Department_name", "Bo$$");
        assertEquals(7, deptDao.findByParams(map).size());
    }

    @Test
    public void insertTest()
    {
        Department dept = new Department();
        dept.setDepartmentName("Bo$$");
        dept.setLocation((long) 1500);
        deptDao.insert(dept);
        assertEquals(36, deptDao.findAll().size());
    }
}
