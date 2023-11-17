package univers;

public class PirateBountyHunter extends Pirate {
    public PirateBountyHunter(String name, int powerLevel, Weapon weapon) {
        super(name, powerLevel, weapon);
    }

    @Override
    public void introduceYourself() {
        System.out.println("Je suis un Chasseur de primes pirate, " + name + ". Mon niveau de puissance est " +
                powerLevel + " et j'utilise " + weapon + " comme outil de chasse.");
    }
}