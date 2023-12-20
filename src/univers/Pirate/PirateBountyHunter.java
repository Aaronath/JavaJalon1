package univers.Pirate;

public class PirateBountyHunter extends Pirate {
    public PirateBountyHunter(String name, int powerLevel) {
        super(name, powerLevel);
    }

    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Chasseur de primes pirate, " + name + ". Mon niveau de puissance est " +
                powerLevel + ".");
    }
}
