package univers;

import fonctionGeneral.Utils;

public abstract class Character implements PowerLevel {
    protected int powerLevel;
	protected int pv;
    protected Weapon weapon;

    public Character( int powerLevel, Weapon weapon) {
        this.powerLevel = powerLevel;
        this.weapon = weapon;
    }

    public void introduceYourself() {
        Utils.displayText("Je suis un personnage, " + name + ". Mon niveau de puissance est " + powerLevel +
                " et j'utilise " + weapon + " comme arme.");
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
