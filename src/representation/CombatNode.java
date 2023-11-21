package representation;

import java.util.List;
import java.util.Scanner;

import univers.*;
import univers.Character;
import univers.Pirate.Pirate;
import fonctionGeneral.Utils;

public class CombatNode extends InnerNode {
    private Pirate opponent;
    private Player player;

    public CombatNode(int id, String description, List<Node> nextNodes, Pirate opponent, Player player) {
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
	    Utils.displayText("Power Level de l'adversaire : " + opponent.getPowerLevel());
	    Utils.displayText("Arme de l'adversaire : " + opponent.getWeapon());

	    // Affiche les options de combat
	    Utils.displayText("Choisissez votre action :");
	    Utils.displayText("1. Attaquer avec votre arme");
	    Utils.displayText("2. Utiliser une compétence spéciale (non implémenté pour l'instant)");

	    Scanner scanner = new Scanner(System.in);
	    int userChoice = scanner.nextInt();

	    // Effectue l'action choisie par le joueur
	    switch (userChoice) {
	        case 1:
	            // Attaquer avec l'arme
	            return determineCombatOutcome();

	        case 2:
	            // Utiliser une compétence spéciale (non implémenté pour l'instant)
	        	return determineCombatOutcomeBonus();

	        default:
	            System.out.println("Choix non valide. Choix de l'arme par défaut.");
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
	
	private boolean determineCombatOutcomeBonus() {
	    // Logique pour déterminer l'issue du combat en prenant en compte le bonus de powerLevel
	    int playerTotalPowerLevel = player.getPowerLevel();

	    if (opponent.getPowerLevel() > playerTotalPowerLevel) {
	        Utils.displayText("Votre attaque n'a pas suffi ! L'adversaire contre-attaque !\n Vous êtes vaincu. Fin de l'histoire. ");
	        return false;
	    } else {
	        Utils.displayText("Vous remportez le combat ! L'adversaire est battu.");
	        return true;
	    }
	}
	
	public void setNextNodes(List<Node> nextNodes) {
		this.nextNodes = nextNodes;
	}
	
	@Override
    public Node chooseNext() {
        return nextNodes.get(0);
    }
	

}
