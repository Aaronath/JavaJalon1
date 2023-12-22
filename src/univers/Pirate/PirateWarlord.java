/**
 * Contient les classes univers du programme.
 * @since 1.0
 */
package univers.Pirate;

/**
 * La classe PirateWarlord représente un seigneur de guerre pirate, un pilleur des mers de haut niveau.
 * Elle étend la classe Pirate et hérite de ses propriétés.
 * Cette classe spécifique représente un pirate de haut niveau, un chef parmi les corsaires.
 * 
 * @author Nathan Halioua
 */
public class PirateWarlord extends PirateCaptain {

    /**
     * Constructeur de la classe PirateWarlord.
     *
     * @param name        Le nom du seigneur de guerre pirate.
     * @param powerLevel  Le niveau de puissance initial du seigneur de guerre pirate.
     * @param crewName 
     */
    public PirateWarlord(String name, int powerLevel, String crewName) {
        super(name, powerLevel, crewName);
        // Initialise le niveau de puissance du seigneur de guerre pirate à une valeur spécifique (120 dans cet exemple).
        this.powerLevel = 120;
    }

    /**
     * Méthode pour présenter le seigneur de guerre pirate.
     *
     * @param name Le nom du seigneur de guerre pirate.
     */
    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Corsaire pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                ".");
    }
}
