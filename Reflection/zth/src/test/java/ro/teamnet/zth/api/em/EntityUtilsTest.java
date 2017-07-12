package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Table;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alexandru.Grameni on 7/12/2017.
 */
public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("departments", tableName);
    }


    @Test
    public void testGetTableNameMethod2() {
        String tableName = EntityUtils.getTableName(Job.class);
        assertEquals("Jobs", tableName);
    }


    @Test
    public void getColumns() throws IllegalAccessException {
        Department dep = new Department();
        dep.setId(1);
        dep.setDepartmentName("hr");
        dep.setLocation(new Location(1, "Maniu", "999999", "Bucuresti", "Bucuresti"));
        ArrayList<ColumnInfo> list = EntityUtils.getColumns(dep.getClass());
        assertEquals(list.size(), 3);
    }

    @Test
    public void getColumns2() throws IllegalAccessException {
        Department dep = new Department();
        dep.setId(2);
        dep.setDepartmentName("it");
        dep.setLocation(new Location(1, "Maniu", "999999", "Bucuresti", "Bucuresti"));
        ArrayList<ColumnInfo> list = EntityUtils.getColumns(dep.getClass());
        assertEquals(list.size(), 3);
    }

    @Test
    public void cast()
    {
        Float f = (Float) EntityUtils.castFromSqlType(5.32f, Float.class);
        assertEquals(f.getClass(), Float.class);
    }

    @Test
    public void cast2()
    {
        Double f = (Double) EntityUtils.castFromSqlType(5.32, Double.class);
        assertEquals(f.getClass(), Double.class);
    }

    @Test
    public void getFieldsByAnnotation()
    {
        Department dep = new Department();
        dep.setId(2);
        dep.setDepartmentName("it");
        dep.setLocation(new Location(1, "Maniu", "999999", "Bucuresti", "Bucuresti"));
        ArrayList<Field> list = EntityUtils.getFieldsByAnnotation(dep.getClass(), Column.class);
        assertEquals(list.size(), 2);
    }

    @Test
    public void getFieldsByAnnotation2()
    {
        Department dep = new Department();
        dep.setId(1);
        dep.setDepartmentName("hr");
        dep.setLocation(new Location(1, "Maniu", "999999", "Bucuresti", "Bucuresti"));
        ArrayList<Field> list = EntityUtils.getFieldsByAnnotation(dep.getClass(), Column.class);
        assertEquals(list.size(), 2);
    }

    @Test
    public void getSqlValue() throws IllegalAccessException {
        Department dep = new Department();
        dep.setId(1);
        dep.setDepartmentName("hr");
        Object obj = EntityUtils.getSqlValue(dep);
        assertEquals(obj, dep.getId());
    }

    @Test
    public void getSqlValue2() throws IllegalAccessException {
        Employee x = new Employee();
        x.setId(1);
        Object obj = EntityUtils.getSqlValue(x);
        assertEquals(obj, x.getId());
    }
}
