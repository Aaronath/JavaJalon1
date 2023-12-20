package univers.Marine;

/**
 * La classe Capitaine représente un soldat dans la marine, qui est une sous-classe de MarineSoldier.
 * Elle hérite des caractéristiques de base d'un soldat de la marine.
 *
 * @author Lévi Webert
 */
public class Capitaine extends MarineSoldier {

    /**
     * Constructeur de la classe Capitaine.
     *
     * @param name        Le nom du capitaine.
     * @param powerLevel  Le niveau de puissance du capitaine.
     */
    public Capitaine(String name, int powerLevel) {
        super(name, powerLevel);
    }

    // Vous pouvez ajouter d'autres méthodes spécifiques à la classe Capitaine ici avec leurs commentaires Javadoc.
}
