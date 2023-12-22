/**
 * Contient les classes univers du programme.
 * @since 1.0
 */
package univers.Pirate;

/**
 * La classe PirateYonko représente un pirate de haut niveau, appelé Yonko, qui est une sous-classe de Pirate.
 * Elle hérite des caractéristiques de base d'un pirate.
 *
 * @author Nathan Halioua
 */
public class PirateYonko extends PirateCaptain {

    /**
     * Constructeur de la classe PirateYonko.
     *
     * @param name        Le nom du Yonko pirate.
     * @param powerLevel  Le niveau de puissance initial du Yonko pirate.
     * @param crewName 
     */
    public PirateYonko(String name, int powerLevel, String crewName) {
        super(name, powerLevel, crewName);
        // Le niveau de puissance du Yonko est fixé à 150 par défaut.
        this.powerLevel = 150;
    }

    /**
     * Méthode permettant au Yonko pirate de se présenter en disant son nom et son niveau de puissance.
     *
     * @param name Le nom du Yonko pirate.
     */
    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Yonko pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                ".");
    }
}
