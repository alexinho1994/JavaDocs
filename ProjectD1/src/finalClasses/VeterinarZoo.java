package finalClasses;

import Interfaces.AngajatZoo;
import Interfaces.Animal;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {
    private int bonus = 0;

    public int getBonus() {
        return bonus;
    }

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Veterinarul are grija de animal");
        if(animal instanceof AnimalZooFeroce)
            animal.faceBaie();
        this.calculeazaBonusSalarial();
    }

    @Override
    public void calculeazaBonusSalarial() {
        bonus+= valoareBonusPerAnimal*2;
    }
}
