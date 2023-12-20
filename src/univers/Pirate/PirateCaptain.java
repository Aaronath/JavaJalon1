package univers.Pirate;

/**
 * La classe PirateCaptain représente un capitaine pirate, un pillard des mers.
 * 
 * Un capitaine pirate commande un équipage et est généralement un personnage puissant.
 * Cette classe hérite des propriétés de la classe Pirate.
 * 
 * @author Nathan Halioua
 */
public class PirateCaptain extends Pirate {

    private String crewName; // Nom de l'équipage dirigé par le capitaine.

    /**
     * Constructeur de la classe PirateCaptain.
     * 
     * @param name Le nom du capitaine pirate.
     * @param powerLevel Le niveau de puissance du capitaine pirate.
     * @param crewName Le nom de l'équipage dirigé par le capitaine pirate.
     */
    public PirateCaptain(String name, int powerLevel, String crewName) {
        // Appelle le constructeur de la classe parente (Pirate) avec les paramètres spécifiés.
        super(name, powerLevel);
        this.crewName = crewName;
        // Ajuste le niveau de puissance du capitaine pirate.
        this.powerLevel = 80;
    }

    /**
     * Méthode permettant au pirate de se présenter.
     * Il mentionne son nom, son statut de capitaine pirate et le nom de son équipage.
     */
    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis " + name + " ! Capitaine pirate de l'équipage, " + crewName +
                ". Mon niveau de puissance est " + powerLevel + ".");
    }
}
