package univers.Pirate;

import univers.Weapon;

public class PirateRookie extends Pirate {
    public PirateRookie(String name,int powerLevel, Weapon signatureMove) {
        super(name,powerLevel, signatureMove);
    }

    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Rookie pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                " et ma technique signature est " + weapon + ".");
    }
    
    public int getPowerLevelBonus() {
    	return 10;
    }
}
