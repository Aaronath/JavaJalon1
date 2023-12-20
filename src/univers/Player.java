package univers;

import fonctionGeneral.Utils;
import univers.Pirate.Monster;

public class Player implements PowerLevel{
	private String name;
	
	// gestion du choix du joueur : Pirate ou marine
	private Character character;

	// Mise en place d'un niveau de puissance pour les combats
	private int powerLevel;

	public Player(String name,Character character) {
		this.name = name;
		this.character = character;

		powerLevel = character.getPowerLevel();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getPowerLevel() {
		return this.powerLevel;
	}

	public Character getCharacter() {
		return this.character;
	}

	
	// Idée : on pourrait faire une classe level ou c'est plus précis au niveau 
	// des up en ajoutant le principe des XP par exemple
	


	// Quand le joueur monte de niveau
	// il gagne plus de puissance et de point de vie
	// On utilise ces fonctions pour notre fonction level up 
	// combat.
	public void powerUp(int levelUp) {
		powerLevel += levelUp;
	}
}
