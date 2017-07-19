package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Employee;

import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alexandru.Grameni on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {
    @Override
    public <T> T findById(Class<T> entityClass, Long id) {
        Connection conn = DBManager.getConnection();
        String name = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> cols = EntityUtils.getColumns(entityClass);
        List<Field> idFields = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);
        Field idField = idFields.get(0);
        List<Field> columnFields = EntityUtils.getFieldsByAnnotations(entityClass, Column.class);
        Condition cond = new Condition();

                cond.setColumnName(cols.get(0).getDbColumnName());
                cond.setValue(id);

        QueryBuilder qb = new QueryBuilder();
        qb.setTableName(name);
        qb.addQueryColumns(cols);
        qb.setQueryType(QueryType.SELECT);
        qb.addCondition(cond);
        String query = qb.createQuery();
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            T instT;
            if(res.next())
            {
                instT = entityClass.newInstance();
                for(ColumnInfo ci : cols)
                {
                    Field f = instT.getClass().getDeclaredField(ci.getColumnName());
                    f.setAccessible(true);
                    f.set(instT, EntityUtils.castFromSqlType(res.getObject(ci.getDbColumnName()), Long.class));
                }
                return instT;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getNextIdVal(String tableName, String columnIdName) {
        Connection conn = DBManager.getConnection();
        String query = "SELECT MAX(" + columnIdName + ") from " + tableName;
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if(res.next()) {
                return res.getLong(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public <T> Object insert(T entity) {
        Connection conn = DBManager.getConnection();
        String name = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> cols = EntityUtils.getColumns(entity.getClass());
        long id = 0;
        for(ColumnInfo ci : cols)
        {
            if(ci.isId()) {
                id = getNextIdVal(name, ci.getDbColumnName());
                ci.setValue(id);
            }
            else
            {
                try {
                    Field f = entity.getClass().getDeclaredField(ci.getColumnName());
                    f.setAccessible(true);
                    ci.setValue(f.get(entity));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        QueryBuilder qb = new QueryBuilder();
        qb.setTableName(name);
        qb.addQueryColumns(cols);
        qb.setQueryType(QueryType.INSERT);
        String query = qb.createQuery();
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            return findById(entity.getClass(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        Connection conn = DBManager.getConnection();
        String name = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> cols = EntityUtils.getColumns(entityClass);
        QueryBuilder qb = new QueryBuilder();
        qb.setTableName(name);
        qb.addQueryColumns(cols);
        qb.setQueryType(QueryType.SELECT);
        String query = qb.createQuery();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            ArrayList<T> list = new ArrayList<>();
            while(res.next())
            {
                T instance = entityClass.newInstance();
                for(ColumnInfo ci : cols)
                {
                    Field f = instance.getClass().getDeclaredField(ci.getColumnName());
                    f.setAccessible(true);
                    f.set(instance, EntityUtils.castFromSqlType(res.getObject(ci.getDbColumnName()), Long.class));
                }
                list.add(instance);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> T update(T entity) {
        Connection conn = DBManager.getConnection();
        String name = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> cols = EntityUtils.getColumns(entity.getClass());
        List<Field> idFields = EntityUtils.getFieldsByAnnotations(entity.getClass(), Id.class);
        try {
            Statement stmt = conn.createStatement();
            for(ColumnInfo i : cols)
            {
                Field f = entity.getClass().getDeclaredField(i.getColumnName());
                f.setAccessible(true);
                i.setValue(f.get(entity));
            }
            Condition cond = new Condition();
            idFields.get(0).setAccessible(true);
            long id  = (long) idFields.get(0).get(entity);
            cond.setValue(idFields.get(0).get(entity));
            cond.setColumnName(cols.get(0).getDbColumnName());
            QueryBuilder qb = new QueryBuilder();
            qb.setTableName(name);
            qb.addQueryColumns(cols);
            qb.setQueryType(QueryType.UPDATE);
            qb.addCondition(cond);
            String query = qb.createQuery();
            ResultSet res = stmt.executeQuery(query);
            return (T) findById(entity.getClass(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Object entity) {

        Connection conn = DBManager.getConnection();
        String name = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> cols = EntityUtils.getColumns(entity.getClass());
        List<Field> idFields = EntityUtils.getFieldsByAnnotations(entity.getClass(), Id.class);
        try {
            Statement stmt = conn.createStatement();
            for(ColumnInfo i : cols)
            {
                Field f = entity.getClass().getDeclaredField(i.getColumnName());
                f.setAccessible(true);
                i.setValue(f.get(entity));
            }
            Condition cond = new Condition();
            idFields.get(0).setAccessible(true);
            cond.setValue(idFields.get(0).get(entity));
            cond.setColumnName(cols.get(0).getDbColumnName());
            QueryBuilder qb = new QueryBuilder();
            qb.setTableName(name);
            qb.setQueryType(QueryType.DELETE);
            qb.addCondition(cond);
            String query = qb.createQuery();
            ResultSet res = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) {
        Connection conn = DBManager.getConnection();
        String name = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> cols = EntityUtils.getColumns(entityClass);
        ArrayList<T> list = new ArrayList<T>();
        try {
            Statement stmt = conn.createStatement();
            for(ColumnInfo i : cols)
            {
                Field f = entityClass.getDeclaredField(i.getColumnName());
                f.setAccessible(true);
//                i.setValue(f.get(entityClass));
            }
            QueryBuilder qb = new QueryBuilder();
            qb.setTableName(name);
            qb.setQueryType(QueryType.SELECT);
            qb.addQueryColumns(cols);
            for(Map.Entry<String, Object> condition : params.entrySet())
            {
                Condition cond = new Condition();
                cond.setColumnName(condition.getKey());
                cond.setValue(condition.getValue());
                qb.addCondition(cond);
            }
            String query = qb.createQuery();
            ResultSet res = stmt.executeQuery(query);
            while(res.next())
            {
                T instT = entityClass.newInstance();
                for(ColumnInfo ci : cols)
                {
                    Field f = instT.getClass().getDeclaredField(ci.getColumnName());
                    f.setAccessible(true);
                    f.set(instT, EntityUtils.castFromSqlType(res.getObject(ci.getDbColumnName()), Long.class));
                }
                list.add(instT);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> findAllEmployees(String string)
    {
        Connection conn = DBManager.getConnection();
        List<ColumnInfo> cols = EntityUtils.getColumns(Employee.class);
        List<Employee> list = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
                String sql = "select * from employees where department_id in (select department_id from departments where department_name" +
                        " like '%" + string + "%')";
                ResultSet res = stmt.executeQuery(sql);
                while(res.next())
                {
                    Employee employee = new Employee();
                    for(ColumnInfo ci : cols)
                    {
                        Field f = employee.getClass().getDeclaredField(ci.getColumnName());
                        f.setAccessible(true);
                        f.set(employee, EntityUtils.castFromSqlType(res.getObject(ci.getDbColumnName()), f.getType()));
                    }
                    list.add(employee);
                }
            } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
