package univers;

public class Player extends Character{

	public Player(String name, int powerLevel, Weapon weapon) {
		super(name, powerLevel, weapon);
	}

	@Override
	public int getPowerLevelBonus() {
		return 0;
	}


}
