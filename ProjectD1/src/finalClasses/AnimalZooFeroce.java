package finalClasses;

import Exceptions.AnimalManancaAnimalException;
import Exceptions.AnimalManancaOmException;
import Interfaces.AngajatZoo;
import Interfaces.Animal;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class AnimalZooFeroce  extends Animal{
    @Override
    public void mananca(Object obj) {
        if(obj instanceof AngajatZoo)
            throw new AnimalManancaOmException();
        if(obj instanceof Animal)
            try{
                throw new AnimalManancaAnimalException();
            }
            catch (AnimalManancaAnimalException e)
            {
                System.out.println("Animal mananca Animal Exception");
            }
        System.out.println("AnimalZooFeroce mananca");
    }

    @Override
    public void seJoaca() {
        System.out.println("AnimalulZooFeroce se joaca");
        super.doarme();
    }

    @Override
    public void faceBaie() {
        System.out.println("AnimalulZooFeroce face baie");
    }

    @Override
    public void doarme()
    {
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }
}
