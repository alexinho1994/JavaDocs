package finalClasses;

import Exceptions.AnimalPeCaleDeDisparitieException;
import Interfaces.AngajatZoo;
import Interfaces.Animal;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {
    private int bonus = 0;

    public int getBonus() {
        return bonus;
    }

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca animalului");
        this.calculeazaBonusSalarial();
    }

    @Override
    public void calculeazaBonusSalarial() {
        bonus+= valoareBonusPerAnimal*3;
    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException {
        this.lucreaza(animal);
        animal.doarme();
        animal.faceBaie();
        animal.seJoaca();
        if(mancare == null && animal instanceof AnimalZooRar)
            throw new AnimalPeCaleDeDisparitieException();
        animal.mananca(mancare);
    }
}
