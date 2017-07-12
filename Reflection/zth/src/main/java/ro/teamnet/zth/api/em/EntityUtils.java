package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Alexandru.Grameni on 7/12/2017.
 */
public class EntityUtils {

    private EntityUtils() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity)
    {
        Table t = (Table) entity.getAnnotation(Table.class);
       return t.name();

    }

    public static ArrayList<ColumnInfo> getColumns(Class entity) throws IllegalAccessException {
        Field[] f = entity.getDeclaredFields();
        ArrayList<ColumnInfo>  list= new ArrayList<>();
        for(Field i : f)
        {
            Column c = (Column) i.getAnnotation(Column.class);
            if(c != null)
            {
                ColumnInfo ci = new ColumnInfo();
                ci.setName(i.getName());
                ci.setColumnType(i.getClass());
                ci.setId(false);
                ci.setDbColumnName(c.name());
                list.add(ci);
            }

            Id id = (Id) i.getAnnotation(Id.class);
            if(id != null)
            {
                ColumnInfo ci = new ColumnInfo();
                ci.setName(i.getName());
                ci.setColumnType(id.getClass());
                ci.setId(true);
                ci.setDbColumnName(id.name());
                list.add(ci);
            }
        }
        return list;
    }

    public static Object castFromSqlType(Object value, Class wantedType)
    {
        if(value instanceof BigDecimal && wantedType == Integer.class)
            return (Integer) value;
        if(value instanceof BigDecimal && wantedType == Long.class)
            return (Long) value;
        if(value instanceof BigDecimal && wantedType == Float.class)
            return (Float) value;
        if(value instanceof BigDecimal && wantedType == Double.class)
            return (Double) value;
        return value;
    }

    public static ArrayList<Field> getFieldsByAnnotation(Class clazz, Class annotation)
    {
        ArrayList<Field> ret = new ArrayList<>();
        Field[] f = clazz.getDeclaredFields();
        for(Field i : f)
        {
            if(i.getAnnotation(annotation) != null)
                ret.add(i);
        }
        return ret;
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {
        if(object.getClass().getAnnotation(Table.class) != null)
        {
            Field[] f = object.getClass().getDeclaredFields();
            for(Field i : f)
            {
                if(i.getAnnotation(Id.class) != null) {
                    i.setAccessible(true);
                    return i.get(object);
                }
            }
        }
        return object;
    }

}
