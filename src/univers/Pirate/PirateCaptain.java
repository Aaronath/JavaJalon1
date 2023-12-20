package univers.Pirate;

public class PirateCaptain extends Pirate {
	private String crewName;
    public PirateCaptain(String name, int powerLevel, String crewName) {
        super( name, powerLevel);
        this.crewName = crewName;
        this.powerLevel = 80;
    }

    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis "+ name +" ! Capitaine pirate de l'équipage, " + crewName + ". Mon niveau de puissance est " +
                powerLevel + ".");
    }
}
