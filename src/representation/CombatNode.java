package representation;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import univers.*;
import univers.Character;
import univers.Pirate.Pirate;
import univers.Pirate.PirateCaptain;
import fonctionGeneral.Utils;

/**
 * La classe CombatNode représente un nœud où le joueur s'engage dans un combat.
 * @author Nathan Halioua
 */
public class CombatNode extends InnerNode {

    /** L'adversaire avec lequel le joueur combat. */
    private Pirate opponent;

    /** Le joueur participant au combat. */
    private Player player;

    /**
     * Constructeur de CombatNode avec la spécification des nœuds suivants.
     * @param id L'identifiant du nœud de combat.
     * @param description La description du nœud de combat.
     * @param nextNodes La liste des nœuds suivants possibles après ce nœud de combat.
     * @param opponent Le pirate adversaire dans le combat.
     * @param player Le joueur participant au combat.
     */
    public CombatNode(int id, String description, List<Event> nextNodes, Pirate opponent, Player player) {
        super(id, description, nextNodes);
        this.opponent = opponent;
        this.player = player;
    }

    /**
     * Constructeur de CombatNode sans spécification des nœuds suivants.
     * @param id L'identifiant du nœud de combat.
     * @param description La description du nœud de combat.
     * @param opponent Le pirate adversaire dans le combat.
     * @param player Le joueur participant au combat.
     */
    public CombatNode(int id, String description, Pirate opponent, Player player) {
        super(id, description);
        this.opponent = opponent;
        this.player = player;
    }

    /**
     * Obtient l'adversaire dans le combat.
     * @return Le pirate adversaire.
     */
    public Pirate getOpponent() {
        return opponent;
    }

    /**
     * Définit l'adversaire dans le combat.
     * @param opponent Le pirate adversaire.
     */
    public void setOpponent(Pirate opponent) {
        this.opponent = opponent;
    }

	public void display() {
            opponent = this.getOpponent();
            // Met à jour le powerLevel du joueur en fonction de ses membres d'équipage
            if (!this.combatNext()) {
                System.exit(0);
            }
        }

    /**
     * Séquence de combat où le joueur choisit son action.
     * @return true si le joueur remporte le combat, false sinon.
     */
    public boolean combatNext() {
        // Affiche les informations sur l'opposant
        Utils.displayText("Vous êtes confronté à " + opponent.getName() + ", un redoutable ennemi !");
        Utils.displayText("Votre Power Level : " + player.getCharacter().getPowerLevel());
        Utils.displayText("Power Level de l'adversaire : " + opponent.getPowerLevel());
        if (player.getCharacter() instanceof PirateCaptain) {
			Utils.displayText("PowerLevel de l'équipage : " + ((PirateCaptain) player.getCharacter()).getCrewPowerLevel());
		}

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


    /**
     * Détermine l'issue du combat en fonction des niveaux de puissance.
     * @return true si le joueur remporte le combat, false sinon.
     */
    private boolean determineCombatOutcome() {
        // Logique pour déterminer l'issue du combat
    	float crewPowerLevel = 0;
    	if (player.getCharacter() instanceof PirateCaptain) {
			crewPowerLevel = ((PirateCaptain) player.getCharacter()).getCrewPowerLevel();
		}
        if (opponent.getPowerLevel() > player.getCharacter().getPowerLevel() + crewPowerLevel) {
            Utils.displayText("Votre attaque n'a pas suffi ! L'adversaire contre-attaque !\n Vous êtes vaincu. Fin de l'histoire. ");
            return false;
        } else {
            Utils.displayText("Vous remportez le combat ! L'adversaire est battu.");
            return true;
        }
    }

    /**
     * Détermine aléatoirement si le joueur réussit à fuir.
     * @return true si le joueur réussit à fuir, false sinon.
     */
    private boolean determineCombatOutcomeEscape() {
        Random random = new Random();
        int randomChoice = random.nextInt(10);
        if (randomChoice < 4) {
            Utils.displayText("Vous n'avez pas réussi à fuir ! Vous êtes donc contraint de vous défendre... ");
            return determineCombatOutcome();
        } else {
            Utils.displayText("Vous parvenez à vous échapper ! Vous continuez votre aventure !");
            return true;
        }
    }

    /**
     * Sélectionne le nœud suivant dans le déroulement de l'histoire.
     * @return L'événement suivant.
     */
    
    @Override
    public Event chooseNext() {
        return nextNodes.get(0);
    }
}
