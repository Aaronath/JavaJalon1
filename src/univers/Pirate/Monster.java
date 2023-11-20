package univers.Pirate;

import univers.Weapon;

public class Monster extends Pirate {
    private String name;
    private int powerLevel;

    public Monster(String name, int powerLevel, Weapon weapon) {
    	super(name, powerLevel, weapon);
    }

}
