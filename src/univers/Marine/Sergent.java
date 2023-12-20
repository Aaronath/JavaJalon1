package univers.Marine;

/**
 * La classe Sergent représente un sous-officier dans la marine.
 * Un Sergent est un soldat gradé, héritant des propriétés de la classe MarineSoldier.
 * 
 * @author Lévi Webert
 */
public class Sergent extends MarineSoldier {

    /**
     * Constructeur de la classe Sergent.
     * 
     * @param name Le nom du Sergent.
     * @param powerLevel Le niveau de puissance du Sergent.
     */
    public Sergent(String name, int powerLevel) {
        // Appelle le constructeur de la classe parente (MarineSoldier) avec les paramètres spécifiés.
        super(name, powerLevel);
    }

    // Vous pouvez ajouter d'autres méthodes spécifiques aux Sergents ici, si nécessaire.
}
