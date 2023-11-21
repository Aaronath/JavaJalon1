package univers.Marine;

import univers.Character;
import univers.Weapon;

public abstract class MarineSoldier extends Character {
    protected Weapon weapon;

    public MarineSoldier(String name,int powerLevel, Weapon weapon) {
        super(name,powerLevel, weapon);
    }

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
    
	public int getPowerLevelBonus() {
	    // Logique spécifique à chaque classe de MarineSoldier
	    return 0;
	}
}

