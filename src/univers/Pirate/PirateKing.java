package univers.Pirate;

/**
 * La classe PirateKing représente un empereur pirate, un puissant pillard des mers.
 * Elle étend la classe Pirate et hérite de ses propriétés.
 * Cette classe spécifique représente un pirate de haut niveau, un roi parmi les pirates.
 * 
 * @author Nathan Halioua
 */
public class PirateKing extends Pirate {

    /**
     * Constructeur de la classe PirateKing.
     *
     * @param name        Le nom du roi pirate.
     * @param powerLevel  Le niveau de puissance initial du roi pirate.
     */
    public PirateKing(String name, int powerLevel) {
        super(name, powerLevel);
        // Initialise le niveau de puissance du roi pirate à une valeur spécifique (200 dans cet exemple).
        this.powerLevel = 200;
    }

    /**
     * Méthode pour présenter le roi pirate.
     *
     * @param name Le nom du roi pirate.
     */
    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Empereur pirate, " + name + ". Mon niveau de puissance est " + powerLevel +
                ".");
    }
}
