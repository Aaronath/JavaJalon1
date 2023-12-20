package univers.Marine;

/**
 * La classe Caporal représente un soldat de la marine avec le grade de caporal.
 * Elle étend la classe MarineSoldier et hérite de ses propriétés.
 *
 * @author Lévi Webert
 */
public class Caporal extends MarineSoldier {

    /**
     * Constructeur de la classe Caporal.
     *
     * @param name        Le nom du caporal.
     * @param powerLevel  Le niveau de puissance du caporal.
     */
    public Caporal(String name, int powerLevel) {
        super(name, powerLevel);
    }
}
