/**
 * Contient les classes des différents nodes utilisés dans le programme.
 * @since 1.0
 */
package representation;

import java.util.List;
import java.util.Scanner;

import fonctionGeneral.Utils;

public class PowerUpNode extends InnerNode {
	
	float powerUp=0;

	public PowerUpNode(int id, String description, List<Event> nextNodes, float powerUp) {
		super(id, description, nextNodes);
		this.powerUp = powerUp;	
	}
	
	
	/**
     * Affiche le powerUp du personnage
     *
     * @return L'événement choisi par l'utilisateur.
     */
    @Override
    public Event chooseNext() {
    		Utils.displayText("Vous gagnez un powerUp de "+powerUp);
        	return super.chooseNext();    
        }

}
