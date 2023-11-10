package univers;

public abstract class Pirate extends Character {
    protected Weapon weapon;

    public Pirate(String name, int powerLevel, Weapon weapon) {
        super(name, powerLevel, weapon);
    }

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
    
	public int getPowerLevelBonus() {
	    // Logique spécifique à chaque classe de Pirate
	    return 0;
	}
}

