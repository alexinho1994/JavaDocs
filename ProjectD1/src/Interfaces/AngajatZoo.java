package Interfaces;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public interface AngajatZoo {
    public int valoareBonusPerAnimal = 50;

    public void lucreaza(Animal animal);

    public void calculeazaBonusSalarial();

    public int getBonus();
}
