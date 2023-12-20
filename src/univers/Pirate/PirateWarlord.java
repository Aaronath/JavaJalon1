package univers.Pirate;

public class PirateWarlord extends Pirate {
    public PirateWarlord(String name, int powerLevel) {
        super(name, powerLevel);
        this.powerLevel = 120;
    }

    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Corsaire pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                ".");
    }
}

