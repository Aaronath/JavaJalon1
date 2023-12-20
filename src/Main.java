import representation.*;
import fonctionGeneral.*;
import univers.*;
import univers.Character;
import univers.Marine.NouvelleRecrue;
import univers.Pirate.Monster;
import univers.Pirate.Pirate;
import univers.Pirate.PirateCaptain;
import univers.Pirate.PirateRookie;
import univers.Pirate.PirateSupernova;
import fonctionGeneral.AudioPath;
import fonctionGeneral.Utils;

import java.io.NotActiveException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Monster monster = new Monster("Monstre", 40);
        Player player;
    	
    	Event currentNode = null;
        Event startNodePirate = new DecisionNode(1,"Veux-tu faire ton aventure : \n 1) En solo \n 2) Avec ton meilleur ami" );
        Event startNodeMarine = new DecisionNode(1,"Veux-tu faire ta carrière :\n \n 1) En écrasant les autres \n 2) En te faisant un maximum d'alliés" );
        
        Scanner scanner = new Scanner(System.in);
        // Début de l'histoire
        Utils.displayText("Bienvenue dans le monde des pirates !");
        Utils.displayText("Commençons par de brèves présentations, comment t'appelles-tu ? :");
        String pseudoJoueur = scanner.nextLine();
        Utils.displayText(pseudoJoueur + " c'est ça ? (1 pour oui, 0 pour non)");
        int confirmation = scanner.nextInt();
        scanner.nextLine();
        while(confirmation == 0) {
        	Utils.displayText("Répète moi ton prénom dans ce cas : ");
        	pseudoJoueur = scanner.nextLine();
        	Utils.displayText(pseudoJoueur + " c'est ça ? (1 pour oui, 0 pour non)");
        	confirmation = scanner.nextInt();
        	scanner.nextLine();
        }
        Utils.displayText("Quelle vie as-tu décidé de mener ?");
        Utils.displayText("1. Devenir un pirate");
        Utils.displayText("2. S'engager dans la Marine");

        int userChoice = scanner.nextInt();
        while (userChoice !=1 && userChoice !=2) {
			Utils.displayText("Quelle vie as-tu décidé de mener ?");
	        Utils.displayText("1. Devenir un pirate");
	        Utils.displayText("2. S'engager dans la Marine");
	
	        userChoice = scanner.nextInt();
		}
        
        switch (userChoice) {
            case 1:
                // Choix de devenir un pirate
                
                Utils.displayText("Tu décides donc la voie de la piraterie ! \n Tu commences au stade de Rookie !\n");
                PirateRookie pirate = new PirateRookie(pseudoJoueur, 50);
                player = new Player(pseudoJoueur, pirate); // Le joueur commence en tant que Pirate Rookie 
                currentNode = startNodePirate;
                break;

            case 2:
                // Choix de devenir Marine
                Utils.displayText("Tu t'enroles dans la marine ! Tu commences au stade de nouvelle recrue !");
            	NouvelleRecrue marine = new NouvelleRecrue(pseudoJoueur,30);
                player = new Player(pseudoJoueur, marine); // Le joueur commence en tant que Nouvelle recrue   
                currentNode = startNodeMarine;
                break;

            default:
                return;
        }

        //Création des Nodes relatives au choix Pirate
        Event soloNode = new InnerNode(2, "Tu es donc solo ! Tu pars en mer à bord de ton radeau !");
        Event snNode = new ImageNode(soloNode, ImagePath.TEST);
        Event duoNode = new InnerNode(3, "Tu as raison, l'aventure c'est toujours mieux avec un ami !");
        Event dnNode = new SoundNode(duoNode, AudioPath.FINALEND);
        Event monsterNode = new DecisionNode(4, "Un monstre marin surgit hors de l'eau ! Que vas-tu faire : \n 1) Fuir \n 2) Combattre");
        Event escapeMonsterNode = new InnerNode(5, "Le monstre a tout de même réussi à déchirer ta voile. Tu es à la dérive...");
        Event fightMonsterNode = new CombatNode(6, "A l'attaque !", null, monster, player);
        Event fmSoundNode = new SoundNode(fightMonsterNode, AudioPath.JUMP);
        Event islandNode = new ChanceNode(7, "Le courant te fais dérivé mais miracle ! Terre en vue !");
        Event logueTownNode = new InnerNode(8, "Tu accostes à LogueTown,le repère des pirates !");
        Event whiskyPeakNode = new InnerNode(8, "Tu accostes à Whisky Peak,le repère des chasseurs de prime !");
        Event terminalNode = new TerminalNode(14, "Vous avez atteint l'objectif ultime : vous êtes le Pirate King ! Félicitations !");
        
                 
        //Graphe de l'histoire
        startNodePirate.setNextNodes(Arrays.asList(snNode, dnNode));
        snNode.setNextNodes(Arrays.asList(monsterNode));
        dnNode.setNextNodes(Arrays.asList(monsterNode));
        monsterNode.setNextNodes(Arrays.asList(escapeMonsterNode, fmSoundNode));
        fmSoundNode.setNextNodes(Arrays.asList(escapeMonsterNode));
        escapeMonsterNode.setNextNodes(Arrays.asList(islandNode));
        islandNode.setNextNodes(Arrays.asList(logueTownNode, whiskyPeakNode));
        logueTownNode.setNextNodes(Arrays.asList(terminalNode));
        whiskyPeakNode.setNextNodes(Arrays.asList(terminalNode));

        /*Choix marine
        
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
        		+ "\n Félicitation !");*/
        
                 

                
        /*Graphe de l'histoire marine
        startNodeMarine.setNextNodes(Arrays.asList(soloNode2, teamNode));
        soloNode2.setNextNodes(Arrays.asList(missionNode));
        teamNode.setNextNodes(Arrays.asList(missionNode));
        missionNode.setNextNodes(Arrays.asList(vsPirateNode));
        vsPirateNode.setNextNodes(Arrays.asList(heroNode));
        heroNode.setNextNodes(Arrays.asList(momNode,deathNode));
        momNode.setNextNodes(Arrays.asList(fin));*/
            

        // Simulation de l'histoire
        while (!(currentNode instanceof TerminalNode)) {
            currentNode.display();
            System.out.println(currentNode.getClass());
            if (currentNode instanceof CombatNode) {
                Pirate opponent = ((CombatNode) currentNode).getOpponent();
                // Met à jour le powerLevel du joueur en fonction de ses membres d'équipage
                if (((CombatNode) currentNode).combatNext()) {
                    currentNode = currentNode.chooseNext();
                    continue; // Passer à l'itération suivante de la boucle pour éviter un double traitement
                }
            }

            currentNode = currentNode.chooseNext();
        }

        // Affiche le nœud terminal final
        currentNode.display();
    }

    
}

