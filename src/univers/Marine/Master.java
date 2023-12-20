package univers.Marine;

/**
 * La classe Master représente un maître, un soldat de la marine.
 * Elle hérite de la classe abstraite MarineSoldier.
 *
 * @author Lévi Webert
 */
public class Master extends MarineSoldier {

    /**
     * Constructeur de la classe Master.
     * @param name Le nom du maître.
     * @param powerLevel Le niveau de puissance du maître.
     */
    public Master(String name, int powerLevel) {
        super(name, powerLevel);
    }
}
