/**
 * Contient les classes univers du programme.
 * @since 1.0
 */
package univers.Marine;

/**
 * La classe Lieutenant représente un officier de la marine.
 * Un Lieutenant est un soldat dans la marine.
 * Il hérite des propriétés de la classe MarineSoldier.
 * 
 * @author Lévi Webert
 */
public class Lieutenant extends MarineSoldier {

    /**
     * Constructeur de la classe Lieutenant.
     * 
     * @param name Le nom du Lieutenant.
     * @param powerLevel Le niveau de puissance du Lieutenant.
     */
    public Lieutenant(String name, int powerLevel) {
        // Appelle le constructeur de la classe parente (MarineSoldier) avec les paramètres spécifiés.
        super(name, powerLevel);
    }

    // Vous pouvez ajouter d'autres méthodes spécifiques aux Lieutenants ici, si nécessaire.
}
