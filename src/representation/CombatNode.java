package representation;

import java.util.List;
import java.util.Scanner;

import univers.*;
import univers.Character;

public class CombatNode extends InnerNode {
    private Pirate opponent;
    private Character player;

    public CombatNode(int id, String description, List<Node> nextNodes, Pirate opponent, Character player) {
        super(id, description, nextNodes);
        this.opponent = opponent;
        this.player = player;
    }
    
    public CombatNode(int id, String description, Pirate opponent, Character player) {
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
	    displayText("Vous êtes confronté à " + opponent.getName() + ", un redoutable ennemi !");
	    displayText("Power Level de l'adversaire : " + opponent.getPowerLevel());
	    displayText("Arme de l'adversaire : " + opponent.getWeapon());

	    // Affiche les options de combat
	    displayText("Choisissez votre action :");
	    displayText("1. Attaquer avec votre arme");
	    displayText("2. Utiliser une compétence spéciale (non implémenté pour l'instant)");

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
	        displayText("Votre attaque n'a pas suffi ! L'adversaire contre-attaque !\n Vous êtes vaincu. Fin de l'histoire. ");
	        return false;
	    } else {
	        displayText("Vous remportez le combat ! L'adversaire est battu.");
	        return true;
	    }
	}
	
	private boolean determineCombatOutcomeBonus() {
	    // Logique pour déterminer l'issue du combat en prenant en compte le bonus de powerLevel
	    int playerTotalPowerLevel = player.getPowerLevel() + player.getPowerLevelBonus();

	    if (opponent.getPowerLevel() > playerTotalPowerLevel) {
	        displayText("Votre attaque n'a pas suffi ! L'adversaire contre-attaque !\n Vous êtes vaincu. Fin de l'histoire. ");
	        return false;
	    } else {
	        displayText("Vous remportez le combat ! L'adversaire est battu.");
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
	
	private static void displayText(String text) {
        char[] descriptionChars = text.toCharArray();

        for (char c : descriptionChars) {
            System.out.print(c);
            try {
                Thread.sleep(15); // Délai de 100 millisecondes entre chaque caractère
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // Nouvelle ligne à la fin
    }

}
