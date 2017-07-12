package ro.teamnet.zerotohero.reflection;

/**
 * Created by Alexandru.Grameni on 7/12/2017.
 */
public class ClassA {

    public ClassA()
    {

    }

    private int x = 4;
    public int y;

    public int asd()
    {
        System.out.println("5");
        return 5;
    }

    public void fact()
    {
        int f = 1;
        for(int i = 1; i < 100; i++)
            f*=i;
    }

}

class ClassB extends ClassA{

}
