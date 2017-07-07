package exercise3;

import javax.swing.text.html.HTMLDocument;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Alexandru.Grameni on 7/7/2017.
 */
public class Main {

    public static void main(String args[])
    {
        Map<Student, BigDecimal> map1 = new HashMap<Student, BigDecimal>();
        Map<Student, BigDecimal> map2 = new HashMap<Student, BigDecimal>();
        Map<Student, BigDecimal> map3 = new HashMap<Student, BigDecimal>();
        Map<Student, BigDecimal> map4 = new HashMap<Student, BigDecimal>();

        map1.put(new StudentB("std", "b"), new BigDecimal(23));
        map2.put(new StudentC("std", "c"), new BigDecimal(24));
        map3.put(new StudentD("std", "d"), new BigDecimal(25));
        map4.put(new StudentE("std", "e"), new BigDecimal(26));

        for(Map.Entry<Student, BigDecimal> mp : map1.entrySet())
            System.out.println(mp.getKey() + "  " + mp.getValue());

        for(Map.Entry<Student, BigDecimal> mp : map2.entrySet())
            System.out.println(mp.getKey() + "  " + mp.getValue());

        for(Map.Entry<Student, BigDecimal> mp : map3.entrySet())
            System.out.println(mp.getKey() + "  " + mp.getValue());

        for(Map.Entry<Student, BigDecimal> mp : map4.entrySet())
            System.out.println(mp.getKey() + "  " + mp.getValue());
    }

}
