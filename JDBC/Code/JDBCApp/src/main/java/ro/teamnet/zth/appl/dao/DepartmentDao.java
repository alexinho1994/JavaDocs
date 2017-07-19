package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.appl.domain.Department;

import java.util.List;
import java.util.Map;

/**
 * Created by Alexandru.Grameni on 7/14/2017.
 */
public class DepartmentDao {

    EntityManager entityManager;

    public DepartmentDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Department findById(Long id) {
        Department dept = entityManager.findById(Department.class, id);
        return dept;
    }

    public long getNextIdVal()
    {
        return entityManager.getNextIdVal("Departments", "DEPARTMENT_ID");
    }

    public List<Department> findAll()
    {
        return entityManager.findAll(Department.class);
    }

    public List<Department> findByParams(Map<String, Object> params)
    {
        return entityManager.findByParams(Department.class, params);
    }

    public Department insert(Department dept)
    {
        return (Department) entityManager.insert(dept);
    }
}
