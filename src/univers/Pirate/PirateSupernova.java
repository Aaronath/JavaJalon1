package univers.Pirate;

import univers.Weapon;

public class PirateSupernova extends Pirate {
    public PirateSupernova(String name, int powerLevel, Weapon fightingStyle) {
        super(name, powerLevel, fightingStyle);
    }

    @Override
    public void introduceYourself() {
        System.out.println("Je suis un Supernova pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                " et mon style de combat est " + weapon + ".");
    }
}
