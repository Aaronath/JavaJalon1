package univers;

import fonctionGeneral.Utils;
import univers.Pirate.Monster;

public class Player implements PowerLevel{
	private String name;

	// Gestion du niveau du joueur
	private int level;
	private final int LEVEL_MAX = 100;
	
	// gestion du choix du joueur : Pirate ou marine
	private Character character;

	// Mise en place d'un niveau de puissance pour les combats
	private int powerLevel;

	// Gestion d'une barre de vie
	private int pvMax;
	private int pv;

	public Player(String name,Level level,Character character) {
		this.name = name;
		this.level = 1;
		this.character = character;
		powerLevel = 80 + character.getPowerLevel();
		pv = 100 + character.getPv();
		pvMax = pv;
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

	public int getLevel() {
		return level;
	}

	public void levelUp(int l) {
		level += l;
	}

	// Les combats apporte des niveaux au joueur
	public void levelUpCombat(Monster mechantBattu) {
		if (level<= LEVEL_MAX) {
			int levelUp = (mechantBattu.getPowerLevel() / level)*2;
			int pvUp = (mechantBattu.getPv() / pv)*2;
			level += levelUp;
			powerUp(levelUp);
			pvMaxUp(pvUp);
		}
		else {
			Utils.displayText("Vous êtes déjà au niveau maximum !");
		}
		
	}
	// Idée : on pourrait faire une classe level ou c'est plus précis au niveau 
	// des up en ajoutant le principe des XP par exemple
	


	// Quand le joueur monte de niveau
	// il gagne en puissance
	public void powerUp(int levelUp) {
		powerLevel += levelUp;
	}

	public void pvMaxUp(int pvUp) {
		pvMax += pvUp;
	}

}
