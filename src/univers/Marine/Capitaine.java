/**
 * Contient les classes univers du programme.
 * @since 1.0
 */
package univers.Marine;

import java.util.List;

import univers.Pirate.Pirate;

/**
 * La classe Capitaine représente un soldat dans la marine, qui est une sous-classe de MarineSoldier.
 * Elle hérite des caractéristiques de base d'un soldat de la marine.
 *
 * @author Lévi Webert
 */
public class Capitaine extends MarineSoldier {
	private String teamName;
	private List<MarineSoldier> teamList;// Nom de l'équipage dirigé par le capitaine.

    /**
     * Constructeur de la classe Capitaine.
     *
     * @param name        Le nom du capitaine.
     * @param powerLevel  Le niveau de puissance du capitaine.
     */
    public Capitaine(String name, int powerLevel, String teamName) {
        super(name, powerLevel);
        this.teamName = teamName;
    }

    public Capitaine(String name, int powerLevel, String teamName, List<MarineSoldier> teamList) {
		// TODO Auto-generated constructor stub
    	super(name, powerLevel);
        this.teamName = teamName;
        this.teamList = teamList;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<MarineSoldier> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<MarineSoldier> TeamList) {
		this.teamList = teamList;
	}
	
	public float getTeamPowerLevel() {
    	float TeamPowerLevel = 0;
    	
		for (MarineSoldier TeamMember : teamList) {
         TeamPowerLevel += TeamMember.getPowerLevel()/2;
		}
    	return TeamPowerLevel; 
    }

}
