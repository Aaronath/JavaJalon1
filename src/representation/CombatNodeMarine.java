package representation;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import univers.*;
import univers.Character;
import univers.Pirate.Pirate;
import univers.Marine.Capitaine;
import fonctionGeneral.Utils;

/**
 * La classe CombatNode représente un nœud où le joueur s'engage dans un combat.
 * @author Nathan Halioua
 */
public class CombatNodeMarine extends InnerNode {

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
    public CombatNodeMarine(int id, String description, List<Event> nextNodes, Pirate opponent, Player player) {
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
    public CombatNodeMarine(int id, String description, Pirate opponent, Player player) {
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
        if (player.getCharacter() instanceof Capitaine) {
			Utils.displayText("PowerLevel de l'équipage : " + ((Capitaine) player.getCharacter()).getTeamPowerLevel());
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
    	    float teamPowerLevel = 0;
    	    if (player.getCharacter() instanceof Capitaine) {
    	        teamPowerLevel = ((Capitaine) player.getCharacter()).getTeamPowerLevel();
    	    }

    	    Utils.displayText("Appuyez rapidement sur les lettres données pour augmenter vos chances de victoire !");
    	    
    	    // Générez une séquence de lettres à afficher
    	    String sequenceToType = generateRandomSequence();
    	    Utils.displayText("Séquence à taper rapidement : " + sequenceToType);
    	    
    	    // Laissez le joueur entrer la séquence aussi rapidement que possible
    	    boolean typedSuccessfully = typeSequencePrompt(sequenceToType);

    	    // Augmentez les chances de victoire si la séquence a été tapée avec succès
    	    if (typedSuccessfully) {
    	        teamPowerLevel += 10; // Vous pouvez ajuster le montant en conséquence
    	    }

    	    if (opponent.getPowerLevel() > player.getCharacter().getPowerLevel() + teamPowerLevel) {
    	        Utils.displayText("Votre attaque n'a pas suffi ! L'adversaire contre-attaque !\n Vous êtes vaincu. Fin de l'histoire. ");
    	        return false;
    	    } else {
    	        Utils.displayText("Vous remportez le combat ! L'adversaire est battu.");
    	        return true;
    	    }
    	}
    	
	    /**
	     * Permet de générer une chaîne aléatoire de lettre de 5 caractères
	     * @return une chaine de caractères contenant les lettres issues du hasard.
	     */
    	private String generateRandomSequence() {
    	    // Générez une séquence aléatoire de lettres (vous pouvez personnaliser cela selon vos besoins)
    	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	    StringBuilder sequenceBuilder = new StringBuilder();

    	    for (int i = 0; i < 5; i++) { // Vous pouvez ajuster la longueur de la séquence
    	        int randomIndex = (int) (Math.random() * alphabet.length());
    	        sequenceBuilder.append(alphabet.charAt(randomIndex));
    	    }

    	    return sequenceBuilder.toString();
    	}
    	/**
         * Permet d'augmenter les chances de victoire
         * @return true si le joueur remporte le bonus, false sinon.
         */
    	private boolean typeSequencePrompt(String sequenceToType) {
    	    Scanner scanner = new Scanner(System.in);

    	    Utils.displayText("Tapez la séquence rapidement : ");

    	    long startTime = System.currentTimeMillis();
    	    String userTypedSequence = scanner.nextLine().toUpperCase(); // Convertir en majuscules pour la comparaison

    	    long elapsedTime = System.currentTimeMillis() - startTime;

    	    if (userTypedSequence.equals(sequenceToType) && elapsedTime < 3000) { // Vous pouvez ajuster le temps maximal autorisé
    	        Utils.displayText("Bien joué ! Vous avez tapé la séquence rapidement !");
    	        return true;
    	    } else {
    	        Utils.displayText("Vous n'avez pas tapé correctement ou assez rapidement. Vos chances de victoire restent inchangées.");
    	        return false;
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
