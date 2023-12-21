package univers;

import java.io.Serializable;

import fonctionGeneral.Utils;
import univers.Pirate.Monster;

/**
 * La classe Player représente un joueur dans le jeu, avec un nom, un personnage (Pirate ou Marine),
 * et un niveau de puissance pour les combats.
 * Implements PowerLevel pour fournir une interface standard pour le niveau de puissance.
 * 
 * @author [Votre Nom]
 */
public class Player implements PowerLevel, Serializable {

    /** Le nom du joueur. */
    private String name;

    /** Le personnage choisi par le joueur (Pirate ou Marine). */
    private Character character;

    /** Le niveau de puissance du joueur pour les combats. */
    private int powerLevel;

    /**
     * Constructeur de la classe Player.
     *
     * @param name      Le nom du joueur.
     * @param character Le personnage choisi par le joueur (Pirate ou Marine).
     */
    public Player(String name, Character character) {
        this.name = name;
        this.character = character;

        // Initialise le niveau de puissance du joueur en fonction de son personnage.
        powerLevel = character.getPowerLevel();
    }

    /**
     * Obtient le nom du joueur.
     *
     * @return Le nom du joueur.
     */
    public String getName() {
        return name;
    }

    /**
     * Définit le nom du joueur.
     *
     * @param name Le nouveau nom du joueur.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Implémentation de la méthode de l'interface PowerLevel.
     *
     * @return Le niveau de puissance du joueur.
     */
    @Override
    public int getPowerLevel() {
        return this.powerLevel;
    }

    /**
     * Obtient le personnage choisi par le joueur.
     *
     * @return Le personnage du joueur.
     */
    public Character getCharacter() {
        return this.character;
    }

	public void setCharacter(Character character) {
		this.character = character;
	}
}
