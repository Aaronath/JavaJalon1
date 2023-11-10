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
    	
    	Node currentNode = null;
        DecisionNode startNode = new DecisionNode(1,"Veux-tu faire ton aventure : \n 1) En solo \n 2) Avec ton meilleur ami" );
        DecisionNode startNode2 = new DecisionNode(1,"Veux-tu faire ta carrière :\n \n 1) En écrasant les autres \n 2) En te faisant un maximum d'alliés" );
        
        Scanner scanner = new Scanner(System.in);
        // Début de l'histoire
        displayText("Bienvenue dans le monde des pirates !");
        displayText("Très bien ! Par quel petit surnom voulez vous vous appeler ? :");
        String pseudoJoueur = scanner.nextLine();
        displayText("Choisissez votre destin :");
        displayText("1. Devenir un pirate");
        displayText("2. S'engager dans la Marine");

        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                // Choix de devenir un pirate
                player = new Player(pseudoJoueur, 80, Weapon.SWORD); // Le joueur commence en tant que Pirate Rookie   
                currentNode = startNode;
                break;

            case 2:
                // Choix de devenir Marine
            	player = new Player(pseudoJoueur, 80, Weapon.GUN); // Le joueur commence en tant que Pirate Rookie   
                currentNode = startNode2;
                break;

            default:
                System.out.println("Choix non valide. Fin de l'histoire.");
                return;
        }

        //Création des Nodes relatives au choix Pirate
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

        //Choix marine
        
        InnerNode soloNode2 = new InnerNode(2, "Tu préfères donc la voie de  et de la puissance !\n"
        		+ "\nTu es tomber sur un power up !\n"
        		+ "\nTu commences par un entrainement très difficile !\n");
        InnerNode teamNode = new InnerNode(3, "Tu fais un choix judicieux !"
        		+ "Tu ne pourras pas être très puissant,\n"
        		+ "mais tu auras des alliés fidèles\n"
        		+ " pour t'aider à tout instant !\n");
        InnerNode missionNode = new InnerNode(4, "Un village se fait attaquer par des pirates.\n"
        		+ "Tu es immédiatement appeler en mission pour sauver ces innocents !");
        CombatNode vsPirateNode = new CombatNode(5,"Tu arrives sur place,"
        		+ "un pirate te barre la route, tu le combat vigoureusement !",null,monster,player) ;
        DecisionNode heroNode = new DecisionNode(6,"Tu es gravement blessé, tu as besoin de soin d'urgence.\n"
        		+ "Soudain un garçon te barre la route, te supplie d'aller aider sa mère\n"
        		+ " qui se fait violencer par un pirate.\n"
        		+ "\n Que choisis tu ? :"
        		+ "\n1) Aller combattre au péril de ta vie"
        		+ "\n2) Ta vie est plus importante. Tu fuis. ");
        
        InnerNode momNode = new InnerNode(7, "Tu as fais le choix d'aller aider"
        		+ "\n Tu arrives sur place, le pirate prends peur en te voyant."
        		+ "\nTu es trop puissant pour lui, tu le tue avec une balle dans le crâne.\n");
        
        TerminalNode deathNode = new TerminalNode(8, "En fuyant, tu te retrouves face au capitaine de l'équipage.\n"
        		+ "Tu essaies de te battre tant bien que mal mais..."
        		+ "\n D'un coup d'épée il te coupe la tête !"
        		+ "\n \n Votre aventure s'arrête ici !");
        TerminalNode fin = new TerminalNode(9,"\nTu revNiens de ta mission héroique, acclamé par les foules.\n"
        		+ "\nAu paroxysme des célébrations, tu es nommée par ton chef comme Amiral pour ton courage et ta bravo."
        		+ "\n Tu as désormais atteint ton objectifs, tu es désormais au sommet de la marine !"
        		+ "\n Félicitation !");
        
                 

                
        //Graphe de l'histoire marine
        startNode2.setNextNodes(Arrays.asList(soloNode2, teamNode));
        soloNode2.setNextNodes(Arrays.asList(missionNode));
        teamNode.setNextNodes(Arrays.asList(missionNode));
        missionNode.setNextNodes(Arrays.asList(vsPirateNode));
        vsPirateNode.setNextNodes(Arrays.asList(heroNode));
        heroNode.setNextNodes(Arrays.asList(momNode,deathNode));
        momNode.setNextNodes(Arrays.asList(fin));
            

         // Simulation de l'histoire
         
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

