package representation;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import univers.*;
import univers.Character;
import univers.Pirate.Pirate;
import fonctionGeneral.Utils;

public class CombatNode extends InnerNode {
    private Pirate opponent;
    private Player player;

    public CombatNode(int id, String description, List<Event> nextNodes, Pirate opponent, Player player) {
        super(id, description, nextNodes);
        this.opponent = opponent;
        this.player = player;
    }
    
    public CombatNode(int id, String description, Pirate opponent, Player player) {
        super(id, description);
        this.opponent = opponent;
        this.player = player;
    }
    
    public Pirate getOpponent() {
		return opponent;
	}


	public void setOpponent(Pirate opponent) {
		this.opponent = opponent;
	}


	
	public boolean combatNext() {
	    // Affiche les informations sur l'opposant
	    Utils.displayText("Vous êtes confronté à " + opponent.getName() + ", un redoutable ennemi !");
        Utils.displayText("Votre Power Level : " + player.getPowerLevel());
	    Utils.displayText("Power Level de l'adversaire : " + opponent.getPowerLevel());

	    // Affiche les options de combat
	    Utils.displayText("Choisissez votre action :");
	    Utils.displayText("1. Combattre !");
	    Utils.displayText("2. Tenter de fuir ...");

	    Scanner scanner = new Scanner(System.in);
	    int userChoice = scanner.nextInt();

	    // Effectue l'action choisie par le joueur
	    switch (userChoice) {
	        case 1:
	            // Combattre
	            return determineCombatOutcome();

	        case 2:
	            // Tenter de fuir
	        	return determineCombatOutcomeEscape();

	        default:
	            System.out.println("Choix non valide. Plus le choix, il faut combattre !");
	            return determineCombatOutcome();
	    }
	}

	private boolean determineCombatOutcome() {
	    // Logique pour déterminer l'issue du combat
	    if (opponent.getPowerLevel() > player.getPowerLevel()) {
	        Utils.displayText("Votre attaque n'a pas suffi ! L'adversaire contre-attaque !\n Vous êtes vaincu. Fin de l'histoire. ");
	        return false;
	    } else {
	        Utils.displayText("Vous remportez le combat ! L'adversaire est battu.");
	        return true;
	    }
	}
	
	private boolean determineCombatOutcomeEscape() {
		Random random = new Random();
		int randomChoice = random.nextInt(10);
	    if (randomChoice < 4) {
	        Utils.displayText("Vous n'avez pas réussi à fuir ! Vous êtes donc contraint de vous défendre... ");
	        return determineCombatOutcome();
	    } else {
	        Utils.displayText("Vous parvenez à vous echapper ! Vous continuer votre aventure !");
	        return true;
	    }
	}
	
	//public void setNextNodes(List<Node> nextNodes) {
		//this.nextNodes = nextNodes;
	//}
	
	@Override
    public Event chooseNext() {
        return nextNodes.get(0);
    }
	

}
