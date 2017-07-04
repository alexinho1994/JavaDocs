package Interfaces;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public abstract class Animal {

    public Animal() {
        System.out.println("Animal nou");
    }

    public void doarme()
    {
        System.out.println("Animalul doarme");
    }

    public abstract void mananca(Object obj);
    public abstract void seJoaca();
    public abstract void faceBaie();

}
