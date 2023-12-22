/**
 * Contient les classes des différents nodes utilisés dans le programme.
 * @since 1.0
 */
package representation;

import java.util.List;
import java.util.Scanner;

import fonctionGeneral.Utils;
import univers.Player;

public class PowerUpNode extends InnerNode {
	private Player player;
	private int powerUp=0;

	public PowerUpNode(int id, String description, List<Event> nextNodes, int powerUp, Player player) {
		super(id, description, nextNodes);
		this.powerUp = powerUp;	
		this.player = player;
	}
	
	public void upgradePowerLevel() {
		Utils.displayText("Vous gagnez un powerUp de "+powerUp);
		player.getCharacter().setPowerLevel(player.getCharacter().getPowerLevel() + powerUp);
	}
	/**
     * Affiche le powerUp du personnage
     *
     * @return L'événement choisi par l'utilisateur.
     */
    @Override
    public Event chooseNext() {
    	upgradePowerLevel();
    	return super.chooseNext();    
    }

}
