package univers;

public abstract class Character {
    protected String name;
    protected int powerLevel;
    protected Weapon weapon;

    public Character(String name, int powerLevel, Weapon weapon) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.weapon = weapon;
    }

    public void introduceYourself() {
        System.out.println("Je suis un personnage, " + name + ". Mon niveau de puissance est " + powerLevel +
                " et j'utilise " + weapon + " comme arme.");
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public abstract int getPowerLevelBonus();
}
