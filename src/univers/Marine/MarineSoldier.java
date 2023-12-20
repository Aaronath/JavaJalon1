package univers.Marine;

import univers.Character;

/**
 * La classe MarineSoldier représente un soldat de la marine.
 * Cette classe est abstraite et étend la classe Character.
 *
 * @author Lévi Webert
 */
public abstract class MarineSoldier extends Character {

    /**
     * Constructeur de la classe MarineSoldier.
     *
     * @param name       Le nom du soldat de la marine.
     * @param powerLevel Le niveau de puissance du soldat de la marine.
     */
    public MarineSoldier(String name, int powerLevel) {
        super(name, powerLevel);
    }
}
