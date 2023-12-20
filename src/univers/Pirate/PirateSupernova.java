package univers.Pirate;

public class PirateSupernova extends Pirate {
    public PirateSupernova(String name,int powerLevel) {
        super( name,powerLevel);
        this.powerLevel = 100;
    }

    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Supernova pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                ".");
    }
}
