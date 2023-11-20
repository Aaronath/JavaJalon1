package univers;

public class NouvelleRecrue extends MarineSoldier {
    public NouvelleRecrue(String name, int powerLevel, Weapon signatureMove) {
        super(name, powerLevel, signatureMove);
    }
    
    public int getPowerLevelBonus() {
    	return 10;
    }

}
