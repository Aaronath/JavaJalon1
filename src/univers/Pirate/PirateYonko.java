package univers.Pirate;

public class PirateYonko extends Pirate {
    public PirateYonko(String name, int powerLevel) {
        super(name, powerLevel);
        this.powerLevel = 150;
    }

    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Yonko pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                ".");
    }
}
