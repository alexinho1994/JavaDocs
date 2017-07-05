package exercise.exercise4;


import java.nio.Buffer;
import java.util.Arrays;
import java.util.Iterator;
/**
 * You should implement from zero a data structure that acts as an ArrayList.
 * We have a default capacity of {@link MyImplementedList#DEFAULT_CAPACITY} elements of type <code>E</code>.
 * We have a {@link MyImplementedList#size} property that stores the number of elements of type <code>E</code> from the data structure.
 * We have an array property, {@link MyImplementedList#elementData}, that keeps the elements from the data structure.
 * We have a {@link MyImplementedList#LOAD_FACTOR} property that specify the maximum accepted load of the data structure.
 * We have a {@link MyImplementedList#INCREASE_SIZE_FACTOR} property to use it when we must increase the capacity of the data structure.
 * We have a {@link MyImplementedList#capacityAfterExtending} property to use it to retain the new capacity after increasing it.
 * <p>
 * Starting with this properties we must implement a data structure that acts ~ as an ArrayList for some objects of type <code>E</code>.
 * <p>
 * TODO if you need to throw some exceptions YOU MUST create them!
 * TODO if you get some warning from the compiler you can use @SuppressWarnings("all") before the method name!
 * TODO if you get this error "usage of api documented as @since 1.6+" you should go to File > Project Structure > Modules and make sure you have the Language level >= 1.6!
 * TODO you should expose as <code>public</code> only the methods that you usually use over a collection!
 * TODO if you need a getter/setter for the properties you must define then, but keep in mind the java concepts!
 * TODO make sure you cover all the possible use-cases for your data structure!
 *
 * @author Cristian.Dumitru
 * @since 7/3/2017.
 */
public class MyImplementedList<E> implements Iterable{

    /**
     * The maximum accepted load property of the data structure.
     */
    private static final double LOAD_FACTOR = 0.75d;

    /**
     * The factor for increasing the size of the data structure.
     */
    private static final int INCREASE_SIZE_FACTOR = 2;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;

    /**
     * The array buffer into which the elements of the {@link MyImplementedList} are stored.
     */
    private Object[] elementData;

    /**
     * Property to keep the extended capacity.
     * TODO if you choose another way to implement the extending capacity you can define your own properties,
     * TODO but the rest of them must remain as they are.
     */
    private int capacityAfterExtending;

    //TODO a) implement the empty constructor for the your data structure
    public MyImplementedList() {
        //TODO a) HINT - DEFAULT_CAPACITY, capacityAfterExtending and elementData properties
        elementData = new Object[this.DEFAULT_CAPACITY];
        size = 0;
        this.capacityAfterExtending = this.DEFAULT_CAPACITY;
    }

    //TODO b) create the int size() method that returns the size of the data structure
    public int size() {
        return size;
    }

    //TODO c) create the boolean add(E e) method that adds at the end of the data structure an element
    //TODO pay attention to the LOAD_FACTOR of the data structure
    public boolean add(E e) {
        this.elementData[size] = e;
        this.size++;
        this.extendCapacity(0);
        return true;
    }

    //TODO d) create the boolean isEmpty() method that checks if the data structure have elements
    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }

    //TODO e) create the boolean contains(Object o_O) method that checks if the data structure contains the object o_O
    public boolean contains(Object o) {
        for (Object i : this.elementData)
            if (i.equals(o))
                return true;
        return false;
    }

    //TODO f) create the int indexOf(Object o_O) method that returns the position in the data structure of the object o_O
    //TODO if exists, otherwise return -1
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++)
            if (elementData[i].equals(o))
                return i;
        return -1;
    }

    //TODO g) create the int lastIndexOf(Object o_O) method that returns the last position in the data structure of the object o_O
    //TODO if exists, otherwise return -1
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i > 0; i--)
            if (this.elementData[i].equals(o))
                return i;
        return -1;
    }

    //TODO h) create the E get(int index) method that returns the object from the given index
    //TODO pay attention to the size property
    public E get(int index) {
        if (index < size)
            return (E) this.elementData[index];
        return null;
    }

    //TODO i) create the E set(int index, E element) method that updates the value of the element from the given index
    //TODO pay attention to the size property
    public E set(int index, E element) {
        if (index >= size)
            return null;
        E prev = (E) this.elementData[index];
        this.elementData[index] = element;
        return prev;
    }

    //TODO j) create the E remove(int index) method that removes the element from the given index
    public E remove(int index) {
        if (index >= size)
            return null;
        E prev = (E) this.elementData[index];
        for (int i = index + 1; i < size; i++)
            this.elementData[i - 1] = this.elementData[i];
        this.elementData[size-1] = null;
        this.size--;
        return prev;
    }

    //TODO k) extend the current default capacity, if the number of elements in the data structure is > 75% of it
    //TODO you should name it: void extendCapacity(int capacity) - HINT use capacity, DEFAULT_CAPACITY, LOAD_FACTOR and INCREASE_SIZE_FACTOR
    public void extendCapacity(int capacity) {
        if (this.capacityAfterExtending * this.LOAD_FACTOR <= size) {
            Object[] newBuffer = new Object[this.capacityAfterExtending * this.INCREASE_SIZE_FACTOR];
            for (int i = 0; i < size; i++)
                newBuffer[i] = this.elementData[i];
            this.elementData = newBuffer;
            this.capacityAfterExtending = this.capacityAfterExtending * this.INCREASE_SIZE_FACTOR;
        }
    }

    public Iterator iterator() {
        Iterator it = new Iterator() {
            private int cursor = 0;

            public void remove() {
                MyImplementedList.this.remove(--cursor);

            }

            public boolean hasNext() {
                return this.cursor < size;
            }

            public Object next() {
                return elementData[cursor++];
            }
        };
        return it;
    }

    //TODO l) implement the iterator() method in order to use the foreach statement over your data structure - HINT Iterable interface
    //TODO and implement a custom iterator for your custom data structure - methods boolean hasNext(), Object next() and void remove()

    //TODO m) implement a method, that uses a Comparator, for your data structure to sort the elements
    //TODO you should name it: void sort(Comparator<? super E> c)
    //TODO create a custom comparator that compares objects by their "what you want" :D - HINT Comparator interface
}
