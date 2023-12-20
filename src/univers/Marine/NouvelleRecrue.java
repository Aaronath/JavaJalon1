package univers.Marine;

/**
 * La classe NouvelleRecrue représente un nouveau soldat de la marine.
 * Elle étend la classe MarineSoldier et hérite de ses propriétés.
 *
 * @author Lévi Webert
 */
public class NouvelleRecrue extends MarineSoldier {

    /**
     * Constructeur de la classe NouvelleRecrue.
     *
     * @param name        Le nom de la nouvelle recrue.
     * @param powerLevel  Le niveau de puissance de la nouvelle recrue.
     */
    public NouvelleRecrue(String name, int powerLevel) {
        super(name, powerLevel);
    }
}
