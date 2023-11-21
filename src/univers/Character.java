package univers;

import fonctionGeneral.Utils;

public abstract class Character implements PowerLevel {
    protected String name;
    protected int powerLevel;
	protected int pv;
    protected Weapon weapon;

    public Character(String name,int powerLevel, Weapon weapon) {
        this.powerLevel = powerLevel + weapon.getPowerLevel();
        this.weapon = weapon;
    }

    public void introduceYourself(String name) {
        Utils.displayText("Je suis un personnage, " + name + ". Mon niveau de puissance est " + powerLevel +
                " et j'utilise " + weapon + " comme arme.");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

	public abstract int getPowerLevelBonus();
}
