package univers.Marine;

/**
 * La classe Matelot représente un soldat dans la marine, qui est une sous-classe de MarineSoldier.
 * Elle hérite des caractéristiques de base d'un soldat de la marine.
 *
 * @author Lévi Webert
 */
public class Matelot extends MarineSoldier {

    /**
     * Constructeur de la classe Matelot.
     *
     * @param name        Le nom du matelot.
     * @param powerLevel  Le niveau de puissance du matelot.
     */
    public Matelot(String name, int powerLevel) {
        super(name, powerLevel);
    }

    // Vous pouvez ajouter d'autres méthodes spécifiques à la classe Matelot ici avec leurs commentaires Javadoc.
}
