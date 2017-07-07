package exercise4;

import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMap() {

        //Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>();
        for(int i = 0; i< 16; i++)
            buckets.add(new LinkedList<MyEntry>());
    }

    public String get(String key) {
        //
        if(key == null) {
            LinkedList<MyEntry> list = buckets.get(1);
            for(MyEntry me : list)
                if(me.getKey() == null)
                    return me.getValue();
            return null;
        }
        int code = key.hashCode() % 16;
        if(code < 0)
            code*=-1;

        LinkedList<MyEntry> list = buckets.get(code);
        for(MyEntry me : list)
            if(me.getKey().equals(key))
                return me.getValue();
        return null;
    }

    public void put(String key, String value) {
        //
        if(key == null)
        {
            LinkedList<MyEntry> list = buckets.get(0);
            for(MyEntry x : list)
                if (x.getKey().equals(key)) {
                    //int index = list.indexOf(x);
                    list.remove(x);
                    list.add(new MyEntry(key, value));
                    return;
                }
            list.add(new MyEntry(key, value));
            return;
        }
            int code = key.hashCode() % 16;
            if (code < 0)
                code *= -1;

            LinkedList<MyEntry> list = buckets.get(code);
            for (MyEntry x : list) {
                if (x.getKey().equals(key)) {
                    //int index = list.indexOf(x);
                    list.remove(x);
                    list.add(new MyEntry(key, value));
                    return;
                }
            }
            list.add(new MyEntry(key, value));

    }

    public Set<String> keySet() {
        // ODO
        Set<String> keys = new HashSet<String>();
        for(LinkedList<MyEntry> list : buckets)
        {
            for(MyEntry x : list)
                keys.add(x.getKey());

        }
        return keys;
    }

    public Collection<String> values() {
        Collection<String> values = new HashSet<String>();
        for(LinkedList<MyEntry> list : buckets)
        {
            for(MyEntry x : list)
                values.add(x.getValue());

        }
        return values;
    }

    public String remove(String key) {
        // ODO Returns the value associated with the key removed from the map or null if the key wasn't found
        if(key == null)
            return null;
        String value = this.get(key);
        if(value == null)
            return null;
        int code;
        if(key == null)
            code = 1;
        else
            code = key.hashCode() % 16;
        if(code < 0)
            code*=-1;
        MyEntry toBeRemoved = null;
        LinkedList<MyEntry> list = buckets.get(code);
        for(MyEntry x : list)
        {
            if(x.getKey().equals(key))
                toBeRemoved = x;
        }
        list.remove(toBeRemoved);
        return value;
    }

    public boolean containsKey(String key) {
        // ODO
        int code;
        if(key == null)
            code = 0;
        else code = key.hashCode() % 16;
        if(code < 0)
            code*=-1;
        LinkedList<MyEntry> list = buckets.get(code);
        for(MyEntry x : list)
            if(x.getKey().equals(key))
                return true;
        return false;
    }

    public boolean containsValue(String value) {
        // ODO
        for(LinkedList<MyEntry> list : buckets)
            for(MyEntry x : list)
                if(x.getValue().equals(value))
                    return true;
        return false;
    }

    public int size() {
        // ODO Return the number of the Entry objects stored in all the buckets
        int size = 0;
        for(LinkedList<MyEntry> list : buckets)
            size+=list.size();
        return size;
    }

    public void clear() {
        // ODO Remove all the Entry objects from the bucket list
        for(LinkedList<MyEntry> list : buckets)
            list.clear();
    }

    public Set<MyEntry> entrySet() {
        // ODO Return a Set containing all the Entry objects
        Set<MyEntry> entryset = new HashSet<MyEntry>();
        for(LinkedList<MyEntry> list : buckets)
            for(MyEntry x : list)
                entryset.add(x);
        return entryset;
    }

    public boolean isEmpty() {
        // ODO
        if(this.size() != 0)
            return false;
        return true;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
