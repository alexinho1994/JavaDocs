package ro.teamnet.zerotohero.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Alexandru.Grameni on 7/12/2017.
 */

enum lit{a, b, c};

public class ClassReflectionDemoMain {

    public static void main(String args[]) throws NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String x = "aaa";
        System.out.println(x.getClass());


        System.out.println(lit.a.getClass());

        ArrayList list = new ArrayList();
        System.out.println(list.getClass());

        System.out.println(int.class);

        ClassA a = new ClassA();
        Field privateA = a.getClass().getDeclaredField("x");
        privateA.setAccessible(true);
        System.out.println(privateA.getType());

        Boolean b = true;
        System.out.println(b.TYPE);

        System.out.println(Class.forName("ro.teamnet.zerotohero.reflection.ClassReflectionDemoMain"));

        System.out.println(list.getClass().getSuperclass());

        System.out.println(list.getClass().getSuperclass().getSuperclass());

        System.out.println(Outer_Demo.class.getDeclaredClasses()[0]);

        System.out.println(ArrayList.class.getConstructors().length);

        Constructor m = ClassA.class.getConstructor();
        m.newInstance();

        System.out.println(privateA.getType());

        System.out.println(privateA.get(a));

        Field fld[] = a.getClass().getFields();
        for(Field i : fld)
            System.out.println(i.getType());

        Method mtd = ClassA.class.getDeclaredMethod("asd");
        mtd.invoke(a);

        ClassB clb = new ClassB();
        Method mtd2 = ClassB.class.getMethod("asd");
        mtd.invoke(clb);

        double diff1, diff2;

        //System.out.println( System.currentTimeMillis());

        double before = System.currentTimeMillis();

        for(int i = 0; i < 1000000; i++)
            a.fact();

        diff1 = System.currentTimeMillis() - before;



        mtd = ClassA.class.getDeclaredMethod("fact");
        before = System.currentTimeMillis();

        for(int i = 0; i < 1000000; i++)
        {
            mtd.invoke(a);
        }

        diff2 = System.currentTimeMillis() - before;

        System.out.println(diff1);
        System.out.println(diff2);
    }

}
