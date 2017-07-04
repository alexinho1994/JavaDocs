package finalClasses;

import Exceptions.AnimalManancaOmException;
import Exceptions.AnimalPeCaleDeDisparitieException;
import Interfaces.AngajatZoo;

import java.util.Date;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class GradinaZooMain {

    public static void main(String args[]) throws AnimalPeCaleDeDisparitieException {

        AnimalZooRar animal1 = new AnimalZooRar("Pinguin");
        AnimalZooRar animal2 = new AnimalZooRar("Elefant","Africa");
        AnimalZooRar animal3 = new AnimalZooRar();

        AnimalZooFeroce animalFeroce = new AnimalZooFeroce();

        AngajatZoo angajat1 = new IngrijitorZoo();
        IngrijitorZoo angajat2 = new IngrijitorZoo();

        GradinaZoo zoo = new GradinaZoo("Bucuresti Zoo", new Date(1992, 12,5), animal1, angajat2);


        AngajatZoo angajat3 = new VeterinarZoo();
        VeterinarZoo angajat4 = new VeterinarZoo();

        angajat3.lucreaza(animal1);
        angajat3.lucreaza(animal2);
        angajat3.lucreaza(animal3);
        angajat4.lucreaza(animal1);
        angajat4.lucreaza(animal2);
        angajat4.lucreaza(animal3);

        angajat1.lucreaza(animal1);

        angajat1.lucreaza(animal2);
        angajat1.lucreaza(animal3);

        angajat2.lucreaza(animal1);
        angajat2.lucreaza(animal2);
        angajat2.lucreaza(animal3);

        try {
            angajat2.lucreaza(animal1, null);
        }
        catch (AnimalPeCaleDeDisparitieException e)
        {
            System.out.println("Animal pe cale de disparitie");
        }

        try {
            angajat2.lucreaza(animal1, angajat1);
        }
        catch(AnimalManancaOmException e)
        {
            System.out.println("Animal mananca om");
        }
        angajat2.lucreaza(animal1,new String("Mancare"));

        angajat2.lucreaza(animalFeroce);
        angajat2.lucreaza(animalFeroce,null);
        angajat2.lucreaza(animalFeroce, new String("Mancare"));
        angajat2.lucreaza(animalFeroce, animal1);

        System.out.println(angajat1.getBonus());
        System.out.println(angajat2.getBonus());
        System.out.println(angajat3.getBonus());
        System.out.println(angajat4.getBonus());

        System.out.println("Finish!");

    }

}
