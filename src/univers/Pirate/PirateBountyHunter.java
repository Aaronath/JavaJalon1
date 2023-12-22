/**
 * Contient les classes univers du programme.
 * @since 1.0
 */
package univers.Pirate;

/**
 * La classe PirateBountyHunter représente un pillard des mers spécialisé dans la chasse aux primes, qui est une sous-classe de Pirate.
 * Elle hérite des caractéristiques de base d'un pirate.
 *
 * @author Nathan Halioua
 */
public class PirateBountyHunter extends Pirate {

    /**
     * Constructeur de la classe PirateBountyHunter.
     *
     * @param name        Le nom du chasseur de primes pirate.
     * @param powerLevel  Le niveau de puissance du chasseur de primes pirate.
     */
    public PirateBountyHunter(String name, int powerLevel) {
        super(name, powerLevel);
    }

    /**
     * Méthode permettant au chasseur de primes pirate de se présenter en disant son nom et son niveau de puissance.
     *
     * @param name Le nom du chasseur de primes pirate.
     */
    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Chasseur de primes pirate, " + name + ". Mon niveau de puissance est " +
                powerLevel + ".");
    }
}
