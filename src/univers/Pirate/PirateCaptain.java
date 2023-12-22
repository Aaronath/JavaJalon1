/**
 * Contient les classes univers du programme.
 * @since 1.0
 */
package univers.Pirate;

import java.util.List;

/**
 * La classe PirateCaptain représente un capitaine pirate, un pillard des mers.
 * 
 * Un capitaine pirate commande un équipage et est généralement un personnage puissant.
 * Cette classe hérite des propriétés de la classe Pirate.
 * 
 * @author Nathan Halioua
 */
public class PirateCaptain extends Pirate {

    private String crewName;
    private List<Pirate> crewList;// Nom de l'équipage dirigé par le capitaine.

    /**
     * Constructeur de la classe PirateCaptain.
     * 
     * @param name Le nom du capitaine pirate.
     * @param powerLevel Le niveau de puissance du capitaine pirate.
     * @param crewName Le nom de l'équipage dirigé par le capitaine pirate.
     */
    public PirateCaptain(String name, int powerLevel, String crewName) {
        // Appelle le constructeur de la classe parente (Pirate) avec les paramètres spécifiés.
        super(name, powerLevel);
        this.crewName = crewName;
        // Ajuste le niveau de puissance du capitaine pirate.
        this.powerLevel = 80;
    }

    public PirateCaptain(String name, int powerLevel, String crewName, List<Pirate> crewList) {
		super(name, powerLevel);
		this.powerLevel = 80;
		this.crewName = crewName;
		this.crewList = crewList;
	}



	public String getCrewName() {
		return crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

	public List<Pirate> getCrewList() {
		return crewList;
	}

	public void setCrewList(List<Pirate> crewList) {
		this.crewList = crewList;
	}
	
	public float getCrewPowerLevel() {
    	float crewPowerLevel = 0;
    	
		for (Pirate crewMember : crewList) {
         crewPowerLevel += crewMember.getPowerLevel()/2;
		}
    	return crewPowerLevel; 
    }

	/**
     * Méthode permettant au pirate de se présenter.
     * Il mentionne son nom, son statut de capitaine pirate et le nom de son équipage.
     */
    @Override
    public void introduceYourself(String name) {
        System.out.println("Je suis " + name + " ! Capitaine pirate de l'équipage, " + crewName +
                ". Mon niveau de puissance est " + powerLevel + ".");
    }
}
