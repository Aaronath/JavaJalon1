package univers.Pirate;

/**
 * La classe PirateSupernova représente un pirate de niveau "Supernova", un pillard des mers particulièrement puissant.
 * 
 * Les Supernovas sont des pirates exceptionnellement forts et redoutables.
 * Cette classe hérite des propriétés de la classe Pirate.
 * 
 * @author Nathan Halioua
 */
public class PirateSupernova extends Pirate {

    /**
     * Constructeur de la classe PirateSupernova.
     * 
     * @param name Le nom du pirate Supernova.
     * @param powerLevel Le niveau de puissance du pirate Supernova.
     */
    public PirateSupernova(String name, int powerLevel) {
        // Appelle le constructeur de la classe parente (Pirate) avec les paramètres spécifiés.
        super(name, powerLevel);
        // Ajuste le niveau de puissance du pirate Supernova.
        this.powerLevel = 100;
    }

    /**
     * Méthode permettant au pirate de niveau Supernova de se présenter.
     * Il mentionne son statut de Supernova pirate, son nom et son niveau de puissance.
     */
    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis un Supernova pirate, " + name + ". Mon niveau de puissance est " + powerLevel + ".");
    }
}
