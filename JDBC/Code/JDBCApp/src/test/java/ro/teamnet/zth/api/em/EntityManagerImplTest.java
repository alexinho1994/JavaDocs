package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


/**
 * Created by Alexandru.Grameni on 7/13/2017.
 */
public class EntityManagerImplTest {
/*
    @Test
    public void findAllTest()
    {
        EntityManagerImpl ent = new EntityManagerImpl();
        List list = ent.findAll(Department.class);
        assertEquals(34, list.size());
    }

    @Test
    public void insertTest()
    {
        EntityManagerImpl ent = new EntityManagerImpl();
        Department dept = new Department();
        dept.setDepartmentName("Bo$$");
        dept.setLocation((long) 1500);
        ent.insert(dept);
        List list = ent.findAll(Department.class);
        assertEquals(35, list.size());
    }


   @Test
   public void getNextId()
   {
       EntityManagerImpl ent = new EntityManagerImpl();
       assertEquals(278, ent.getNextIdVal("Departments", "DEPARTMENT_ID"));
   }

   @Test
   public void findByIdTest()
   {
       EntityManagerImpl ent = new EntityManagerImpl();
       Department dept = ent.findById(Department.class, (long) 30);
       assertEquals("Purchasing", dept.getDepartmentName());
   }*/

  /* @Test
   public void update()
   {
       EntityManagerImpl ent = new EntityManagerImpl();
       Department dept = new Department();
       dept.setDepartmentName("sef");
       dept.setLocation((long) 1500);
       dept.setId((long) 274);
       dept = ent.update(dept);
       dept = ent.findById(Department.class, (long) 274);
       assertEquals("sef", dept.getDepartmentName());
   }
*/
  /*
   @Test
   public void delete()
   {
       EntityManagerImpl ent = new EntityManagerImpl();
       Department dept = new Department();
       dept.setDepartmentName("sef");
       dept.setLocation((long) 1500);
       dept.setId((long) 275);
       ent.delete(dept);
       assertEquals(34, ent.findAll(Department.class).size());
   }*/
/*
  @Test
  public void findParams()
  {
      EntityManagerImpl ent = new EntityManagerImpl();
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("Department_name", "Bo$$");
      assertEquals(6, ent.findByParams(Department.class, map).size());
  }*/

  @Test
  public void allEmployees()
  {
      EntityManagerImpl ent = new EntityManagerImpl();
      ent.findAllEmployees("str");
  }
}
