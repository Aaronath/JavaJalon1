/**
 * Contient les classes univers du programme.
 * @since 1.0
 */
package univers.Pirate;

/**
 * La classe PirateRookie représente un jeune pirate, un débutant dans le pillage des mers.
 * Cette classe hérite de la classe Pirate.
 *
 * @author Nathan Halioua
 */
public class PirateRookie extends Pirate {

    /**
     * Constructeur de la classe PirateRookie.
     *
     * @param name       Le nom du pirate rookie.
     * @param powerLevel Le niveau de puissance initial du pirate rookie.
     */
    public PirateRookie(String name, int powerLevel) {
        super(name, powerLevel);
        this.powerLevel = 50; // Initialisation du niveau de puissance à 50 pour les pirates rookies.
    }

    /**
     * Méthode permettant au pirate rookie de se présenter.
     *
     * @param name Le nom du pirate rookie.
     */
    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Rookie pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                ".");
    }
}
