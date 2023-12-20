package univers.Pirate;

public class PirateKing extends Pirate {
    public PirateKing( String name,int powerLevel) {
        super(name,powerLevel);
        this.powerLevel = 200;
    }

    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Empereur pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                ".");
    }
}
