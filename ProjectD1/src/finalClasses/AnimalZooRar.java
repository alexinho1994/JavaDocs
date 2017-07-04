package finalClasses;

import Exceptions.AnimalManancaAnimalException;
import Exceptions.AnimalManancaOmException;
import Interfaces.AngajatZoo;
import Interfaces.Animal;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class AnimalZooRar extends Animal  {
    private String nume;
    private String numeTaraOrigine;

    public String getNume() {
        return nume;
    }

    public String getNumeTaraOrigine() {
        return numeTaraOrigine;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setNumeTaraOrigine(String numeTaraOrigine) {
        this.numeTaraOrigine = numeTaraOrigine;
    }

    public AnimalZooRar() {
    }

    public AnimalZooRar(String nume) {
        this.nume = nume;
    }

    public AnimalZooRar(String nume, String numeTaraOrigine) {
        this.nume = nume;
        this.numeTaraOrigine = numeTaraOrigine;
    }

    @Override
    public void mananca(Object obj) {
        if(obj instanceof AngajatZoo)
            throw new AnimalManancaOmException();
        if(obj instanceof Animal)
            try {
                throw new AnimalManancaAnimalException();
            } catch (AnimalManancaAnimalException e) {
                System.out.println("Animal mananca Animal Exception");
            }
        System.out.println(this.getNume() + " mananca");
    }

    @Override
    public void seJoaca() {
        System.out.println(this.getNume() + " se joaca");
        super.doarme();
    }

    @Override
    public void faceBaie() {
        System.out.println(this.getNume() + " face baie");
    }
}
