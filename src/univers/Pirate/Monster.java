package univers.Pirate;

/**
 * La classe Monster représente un monstre, une créature marine très dangereuse.
 * Son apparition provoque un combat.
 * Elle hérite de la classe Pirate.
 *
 * @author Nathan Halioua
 */
public class Monster extends Pirate {

    /**
     * Constructeur de la classe Monster.
     * @param name Le nom du monstre.
     * @param powerLevel Le niveau de puissance du monstre.
     */
    public Monster(String name, int powerLevel) {
        super(name, powerLevel);
    }
}
