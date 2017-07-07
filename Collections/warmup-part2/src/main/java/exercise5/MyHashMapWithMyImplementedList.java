package exercise5;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Create a HashMap that uses to store the buckets your implementation of MyImplementedList that you
 * created in the Collections I workshop.
 *
 * Created by Radu.Hoaghe on 7/6/2017.
 */
public class MyHashMapWithMyImplementedList {

    // ODO uncomment the following line and add your MyImplementedList implementation to the project
    private MyImplementedList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMapWithMyImplementedList() {
        // ODO
        buckets = new MyImplementedList<LinkedList<MyEntry>>();
        for(int i = 0; i< 16; i++)
            buckets.add(new LinkedList<MyEntry>());
    }

    public String get(String key) {
        // ODO
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
        // ODO
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
        for(int i = 0; i < this.BUCKET_ARRAY_SIZE; i++)
        {
            LinkedList<MyEntry> list = buckets.get(i);
            for(MyHashMapWithMyImplementedList.MyEntry x : list)
                keys.add(x.getKey());
        }
        return keys;
    }

    public Collection<String> values() {
        // ODO
        Collection<String> values = new HashSet<String>();
        for(int i = 0; i < this.BUCKET_ARRAY_SIZE; i++) {
            LinkedList<MyEntry> list = buckets.get(i);
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
        for(int i = 0; i< this.BUCKET_ARRAY_SIZE; i++)
        {
            LinkedList<MyEntry> list = buckets.get(i);
            for(MyEntry x : list)
                if(x.getValue().equals(value))
                    return true;
        }
        return false;
    }

    public int size() {
        // ODO Return the number of the Entry objects stored in all the buckets
        int size = 0;
        for(int i = 0; i< this.BUCKET_ARRAY_SIZE; i++)
            size+=buckets.get(i).size();
        return size;
    }

    public void clear() {
        // ODO Remove all the Entry objects from the bucket list
        for(int i = 0; i< this.BUCKET_ARRAY_SIZE; i++)
        {
            LinkedList<MyEntry> list = buckets.get(i);
            list.clear();
        }
    }

    public Set<MyHashMapWithMyImplementedList.MyEntry> entrySet() {
        // ODO Return a Set containing all the Entry objects
        Set<MyEntry> entryset = new HashSet<MyEntry>();
        for(int i = 0; i < this.BUCKET_ARRAY_SIZE; i++)
        {
            LinkedList<MyEntry> list = buckets.get(i);
            for(MyEntry x : list)
                entryset.add(x);
        }
        return entryset;
    }

    public boolean isEmpty() {
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
