package univers;

public class PirateCaptain extends Pirate {
	private String crewName;
    public PirateCaptain(String name, int powerLevel, Weapon devilFruit, String crewName) {
        super(name, powerLevel, devilFruit);
        this.crewName = crewName;
    }

    @Override
    public void introduceYourself() {
        System.out.println("Je suis "+ name +" ! Capitaine pirate de l'équipage, " + crewName + ". Mon niveau de puissance est " +
                powerLevel + " et je possède le Fruit du Démon : " + weapon + ".");
    }
}
