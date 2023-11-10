package univers;

public class PirateWarlord extends Pirate {
    public PirateWarlord(String name, int powerLevel, Weapon weapon) {
        super(name, powerLevel, weapon);
    }

    @Override
    public void introduceYourself() {
        System.out.println("Je suis un Corsaire pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                " et j'utilise " + weapon + " comme arme.");
    }
}

