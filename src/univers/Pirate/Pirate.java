package univers.Pirate;

import univers.Character;

/**
 * La classe Pirate représente un pillard des mers.
 * Cette classe est abstraite et étend la classe Character.
 *
 * @author Nathan Halioua
 */
public abstract class Pirate extends Character {

    /**
     * Constructeur de la classe Pirate.
     *
     * @param name       Le nom du pirate.
     * @param powerLevel Le niveau de puissance du pirate.
     */
    public Pirate(String name, int powerLevel) {
        super(name, powerLevel);
    }
}
