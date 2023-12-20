package univers;

import fonctionGeneral.Utils;

public abstract class Character implements PowerLevel {
    protected String name;
    protected int powerLevel;

    public Character(String name,int powerLevel) {
    	this.name = name;
        this.powerLevel = powerLevel;
    }

    public void introduceYourself(String name) {
        Utils.displayText("Je suis " + name + ". Mon niveau de puissance est " + powerLevel +
                ".");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}
}
