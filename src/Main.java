import representation.*;
import univers.*;
import univers.Character;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    	
    	Player player = new Player("Moi", 0, Weapon.SABER);
    	Monster monster = new Monster("Monstre", 70, null);
        
        // Début de l'histoire
        System.out.println("Bienvenue dans le monde des pirates !");
        System.out.println("Choisissez votre destin :");
        System.out.println("1. Devenir un pirate");
        System.out.println("2. Autre choix (non implémenté pour l'instant)");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                // Choix de devenir un pirate
                player = new Player("Joueur", 80, Weapon.SWORD); // Le joueur commence en tant que Pirate Rookie        
                break;

            case 2:
                // Autre choix (non implémenté pour l'instant)
                break;

            default:
                System.out.println("Choix non valide. Fin de l'histoire.");
                return;
        }

        //Création des Nodes relatives au choix Pirate
        DecisionNode startNode = new DecisionNode(1,"Veux-tu faire ton aventure : \n 1) En solo \n 2) Avec ton meilleur ami" );
        InnerNode soloNode = new InnerNode(2, "Tu es donc solo ! Tu pars en mer à bord de ton radeau !");
        InnerNode duoNode = new InnerNode(3, "Tu as raison, l'aventure c'est toujours mieux avec un ami !");
        DecisionNode monsterNode = new DecisionNode(4, "Un monstre marin surgit hors de l'eau ! Que vas-tu faire : \n 1) Fuir \n 2) Combattre");
        InnerNode escapeMonsterNode = new InnerNode(5, "Le monstre a tout de même réussi à déchirer ta voile. Tu es à la dérive...");
        CombatNode fightMonsterNode = new CombatNode(6, "A l'attaque !", null, monster, player);
        ChanceNode islandNode = new ChanceNode(7, "Le courant te fais dérivé mais miracle ! Terre en vue !");
        InnerNode logueTownNode = new InnerNode(8, "Tu accostes à LogueTown,le repère des pirates !");
        InnerNode whiskyPeakNode = new InnerNode(8, "Tu accostes à Whisky Peak,le repère des chasseurs de prime !");
        TerminalNode terminalNode = new TerminalNode(14, "Vous avez atteint l'objectif ultime : vous êtes le Pirate King ! Félicitations !");
        
                 
        //Graphe de l'histoire
        startNode.setNextNodes(Arrays.asList(soloNode, duoNode));
        soloNode.setNextNodes(Arrays.asList(monsterNode));
        duoNode.setNextNodes(Arrays.asList(monsterNode));
        monsterNode.setNextNodes(Arrays.asList(escapeMonsterNode, fightMonsterNode));
        fightMonsterNode.setNextNodes(Arrays.asList(escapeMonsterNode));
        escapeMonsterNode.setNextNodes(Arrays.asList(islandNode));
        islandNode.setNextNodes(Arrays.asList(logueTownNode, whiskyPeakNode));
        logueTownNode.setNextNodes(Arrays.asList(terminalNode));
        whiskyPeakNode.setNextNodes(Arrays.asList(terminalNode));

            

         // Simulation de l'histoire
         Node currentNode = startNode;
         
        while (!(currentNode instanceof TerminalNode)) {
            currentNode.display();

            if (currentNode instanceof CombatNode) {
                Pirate opponent = ((CombatNode) currentNode).getOpponent();
                Weapon playerWeapon = choosePlayerWeapon();
                int playerPowerLevel = calculatePlayerPowerLevel(playerWeapon)+ player.getPowerLevel();
                player.setPowerLevel(playerPowerLevel);
                System.out.println("Votre Power Level : " + player.getPowerLevel());

                // Met à jour le powerLevel du joueur en fonction de la classe actuelle
                player.setPowerLevel(player.getPowerLevel() + player.getPowerLevelBonus());

                // Met à jour le powerLevel du joueur en fonction de ses membres d'équipage
                player.setPowerLevel(player.getPowerLevel() + calculateCrewPowerLevel(player));
                
                if (((CombatNode) currentNode).combatNext()) {
					currentNode.chooseNext();
				}
            }
            currentNode = currentNode.chooseNext();
        }

        // Affiche le nœud terminal final
        currentNode.display();
    }

    private static Weapon choosePlayerWeapon() {
        System.out.println("Choisissez votre arme :");
        System.out.println("1. Épée");
        System.out.println("2. Fusil");
        System.out.println("3. Sabre");

        Scanner scanner = new Scanner(System.in);
        int weaponChoice = scanner.nextInt();

        switch (weaponChoice) {
            case 1:
                return Weapon.SWORD;

            case 2:
                return Weapon.GUN;

            case 3:
                return Weapon.SABER;

            default:
                System.out.println("Choix non valide. Utilisation de l'épée par défaut.");
                return Weapon.SWORD;
        }
    }

    private static int calculatePlayerPowerLevel(Weapon weapon) {
        switch (weapon) {
            case SWORD:
                return 10;

            case GUN:
                return 15;

            case SABER:
                return 20;

            default:
                return 0;
        }
    }

    private static int calculateCrewPowerLevel(Player player) {
        // Simule l'ajout de membres d'équipage
        List<Pirate> crewMembers = Arrays.asList(
                new PirateRookie("Membre 1 ", 40, Weapon.SWORD),
                new PirateCaptain("Memebre 2", 30, Weapon.GUN, null),
                new PirateSupernova("Membre 3", 25, Weapon.SABER)
        );

        int totalCrewPowerLevel = 0;

        for (Pirate crewMember : crewMembers) {
            totalCrewPowerLevel += crewMember.getPowerLevel();
        }

        System.out.println("Power Level de l'équipage : " + totalCrewPowerLevel);

        return totalCrewPowerLevel;
    }
}

