package univers;

import java.io.Serializable;

import fonctionGeneral.Utils;

/**
 * La classe abstraite Character représente un personnage générique avec un nom et un niveau de puissance.
 * Elle implémente l'interface PowerLevel pour fournir des méthodes liées au niveau de puissance.
 */
public abstract class Character implements PowerLevel, Serializable {

    /** Le nom du personnage. */
    protected String name;

    /** Le niveau de puissance du personnage. */
    protected int powerLevel;

    /**
     * Constructeur de la classe Character.
     * @param name Le nom du personnage.
     * @param powerLevel Le niveau de puissance du personnage.
     */
    public Character(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }

    /**
     * Affiche une introduction du personnage avec son nom et son niveau de puissance.
     * @param name Le nom du personnage.
     */
    public void introduceYourself(String name) {
        Utils.displayText("Je suis " + name + ". Mon niveau de puissance est " + powerLevel + ".");
    }

    /**
     * Définit le nom du personnage.
     * @param name Le nouveau nom du personnage.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtient le nom du personnage.
     * @return Le nom du personnage.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtient le niveau de puissance du personnage.
     * @return Le niveau de puissance du personnage.
     */
    public int getPowerLevel() {
        return powerLevel;
    }

    /**
     * Définit le niveau de puissance du personnage.
     * @param powerLevel Le nouveau niveau de puissance du personnage.
     */
    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }
}
