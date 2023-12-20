package univers.Pirate;

public class PirateRookie extends Pirate {
    public PirateRookie(String name,int powerLevel) {
        super(name,powerLevel);
        this.powerLevel = 50;
    }

    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Rookie pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                ".");
    }
}
