package univers.Pirate;

import univers.Weapon;

public class PirateYonko extends Pirate {
    public PirateYonko(String name, int powerLevel, Weapon devilFruit) {
        super(name, powerLevel, devilFruit);
    }

    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Yonko pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                " et je possède le Fruit du Démon : " + weapon + ".");
    }
}
