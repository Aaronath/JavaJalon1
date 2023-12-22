/**
 * Contient les classes univers du programme.
 * @since 1.0
 */
package univers.Marine;

/**
 * La classe Vice_Amiral représente un vice-amiral dans la marine.
 * Cette classe hérite de la classe MarineSoldier.
 *
 * @author Lévi Webert
 */
public class Vice_Amiral extends MarineSoldier {

    /**
     * Constructeur de la classe Vice_Amiral.
     *
     * @param name       Le nom du vice-amiral.
     * @param powerLevel Le niveau de puissance du vice-amiral.
     */
    public Vice_Amiral(String name, int powerLevel) {
        super(name, powerLevel);
    }
}
