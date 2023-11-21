package univers;

public enum Weapon {
    SWORD(10),
    GUN(15),
    AXE(100),
    DEVIL_FRUIT(2000),
    HUNTING_TOOL(25),
    FISTS(5),
    NONE(0), 
    SABER(20);

    private final int powerLevel;

    Weapon(int powerLevel){
        this.powerLevel=powerLevel;
    }

    public int getPowerLevel() {
        return powerLevel;
    }
}
