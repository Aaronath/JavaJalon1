import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import fonctionGeneral.AudioPath;
import fonctionGeneral.ImagePath;
import fonctionGeneral.Utils;
import representation.*;
import univers.*;
import univers.Marine.NouvelleRecrue;
import univers.Pirate.Monster;
import univers.Pirate.*;

public class Game implements Serializable {
    private Player player;
    private Event currentNode;

    public void configureGame() {
    	Monster monster = new Monster("Monstre", 40);
    	PirateRookie opponent = new PirateRookie("Marshall.D.Teach", 80); 
        PirateRookie bestFriend = new PirateRookie("Ace", 40);
    	
    	currentNode = null;
        Event startNodePirate = new InnerNode(1,"Tu commences à t'approcher du port pour trouver une embarcation quand soudain un dilemme se pose :");
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
    	
    	
    	
        // Création des Nodes relatives au choix Pirate
        Event bestFriendNode = new SoundNode(new ImageNode(new CrewNode(1, "Veux-tu faire ton aventure : \n 1) En solo \n 2) Avec ton meilleur ami", bestFriend, player), ImagePath.BESTFRIEND), AudioPath.OST);
        Event soloNode =  new SoundNode(new InnerNode(2, "Tu es donc solo ! Tu pars en mer à bord de ton radeau !"), AudioPath.COMIC);
        Event duoNode = new SoundNode(new InnerNode(3, "Tu as raison, l'aventure c'est toujours mieux avec un ami !"), AudioPath.HAKI);
        Event saveNode = new SaveNode(4, "Veux-tu sauvegarder ta partie ?");
        Event monsterNode = new SoundNode(new ImageNode(new DecisionNode(5, "Un monstre marin surgit hors de l'eau ! Que vas-tu faire : \n 1) Fuir \n 2) Combattre"), ImagePath.MONSTER), AudioPath.BOUND);
        Event escapeMonsterNode = new InnerNode(6, "Le monstre a tout de même réussi à déchirer ta voile. Tu es à la dérive...");
        Event fightMonsterNode = new SoundNode( new ImageNode(new CombatNode(7, "A l'attaque !", null, monster, player), ImagePath.PUNCH), AudioPath.COMBAT);
        Event islandNode = new ImageNode(new ChanceNode(8, "Le courant te fais dériver mais miracle ! Terre en vue !"), ImagePath.ISLAND);
        Event logueTownNode = new InnerNode(9, "Tu accostes à LogueTown, le repère des pirates !");
        Event whiskyPeakNode = new InnerNode(10, "Tu accostes à Whisky Peak, le repère des chasseurs de prime !");
        Event opponentNode = new SoundNode(new ImageNode(new CombatNode(12, "Tu fais face à ton ennemi juré : "+opponent.getName()+" !", opponent, player), ImagePath.OPPONENT), AudioPath.OPPONENT);
        Event terminalNode = new SoundNode( new TerminalNode(11, "Vous avez atteint l'objectif ultime : vous êtes le Pirate King ! Félicitations!"), AudioPath.BINKS);

        // Graphe de l'histoire
        startNodePirate.setNextNodes(Arrays.asList(bestFriendNode));
        bestFriendNode.setNextNodes(Arrays.asList(soloNode, duoNode));
        soloNode.setNextNodes(Arrays.asList(saveNode));
        duoNode.setNextNodes(Arrays.asList(saveNode));
        saveNode.setNextNodes(Arrays.asList(monsterNode));
        monsterNode.setNextNodes(Arrays.asList(escapeMonsterNode, fightMonsterNode));
        fightMonsterNode.setNextNodes(Arrays.asList(escapeMonsterNode));
        escapeMonsterNode.setNextNodes(Arrays.asList(islandNode));
        islandNode.setNextNodes(Arrays.asList(logueTownNode, whiskyPeakNode));
        logueTownNode.setNextNodes(Arrays.asList(opponentNode));
        whiskyPeakNode.setNextNodes(Arrays.asList(opponentNode));
        opponentNode.setNextNodes(Arrays.asList(terminalNode));


        //Choix marine
        
        Event saveNodeMarine = new SaveNode(4, "Veux-tu sauvegarder ta partie marin des mers ?");
        Event soloNodeMarine = new SoundNode(new ImageNode(new PowerUpNode(2, "Tu préfères donc la voie de  et de la puissance !\n"
        		+ "\nTu es tomber sur un power up !\n"
        		+ "\nTu commences par un entrainement très difficile !\n",null,50, player), ImagePath.SOLO), AudioPath.POWERUP);
        Event teamNode = new SoundNode (new ImageNode(new InnerNode(3, "Tu fais un choix judicieux !"
        		+ "Tu ne pourras pas être très puissant,\n"
        		+ "mais tu auras des alliés fidèles\n"
        		+ " pour t'aider à tout instant !\n"),ImagePath.TEAM),AudioPath.HAKI);
        Event missionNode = new InnerNode(4, "Un village se fait attaquer par des pirates.\n"
        		+ "Tu es immédiatement appeler en mission pour sauver ces innocents !");
        Event vsPirateNode = new SoundNode( new ImageNode(new CombatNodeMarine(5,"Tu arrives sur place,"
        		+ "un pirate te barre la route, tu le combat vigoureusement !",null,monster,player), ImagePath.PIRATE), AudioPath.COMBAT);
        Event heroNode = new DecisionNode(6,"Tu es gravement blessé, tu as besoin de soin d'urgence.\n"
        		+ "Soudain un garçon te barre la route, te supplie d'aller aider sa mère\n"
        		+ " qui se fait violencer par un pirate.\n"
        		+ "\n Que choisis tu ? :"
        		+ "\n1) Aller combattre au péril de ta vie"
        		+ "\n2) Ta vie est plus importante. Tu fuis. ");
        
        Event momNode = new InnerNode(7, "Tu as fais le choix d'aller aider"
        		+ "\n Tu arrives sur place, le pirate prends peur en te voyant."
        		+ "\nTu es trop puissant pour lui, tu le tue avec une balle dans le crâne.\n");
        
        Event deathNode = new TerminalNode(8, "En fuyant, tu te retrouves face au capitaine de l'équipage.\n"
        		+ "Tu essaies de te battre tant bien que mal mais..."
        		+ "\n D'un coup d'épée il te coupe la tête !"
        		+ "\n \n Votre aventure s'arrête ici !");
        Event fin = new TerminalNode(9,"\nTu revNiens de ta mission héroique, acclamé par les foules.\n"
        		+ "\nAu paroxysme des célébrations, tu es nommée par ton chef comme Amiral pour ton courage et ta bravo."
        		+ "\n Tu as désormais atteint ton objectifs, tu es désormais au sommet de la marine !"
        		+ "\n Félicitation !");
        
                 

                
        //Graphe de l'histoire marine
        startNodeMarine.setNextNodes(Arrays.asList(soloNodeMarine, teamNode));
        soloNodeMarine.setNextNodes(Arrays.asList(saveNodeMarine));
        teamNode.setNextNodes(Arrays.asList(saveNodeMarine));
        saveNodeMarine.setNextNodes(Arrays.asList(missionNode));
        missionNode.setNextNodes(Arrays.asList(vsPirateNode));
        vsPirateNode.setNextNodes(Arrays.asList(heroNode));
        heroNode.setNextNodes(Arrays.asList(momNode,deathNode));
        momNode.setNextNodes(Arrays.asList(fin));
    }

    public void start() {
        // Simulation de l'histoire
        while (!(currentNode instanceof TerminalNode)) {
            currentNode.display();

            if (currentNode instanceof SaveNode) {
                // Si le nœud actuel est un SaveNode, affiche le choix de sauvegarde
                currentNode = ((SaveNode) currentNode).chooseNext(this);
            } else {
                currentNode = currentNode.chooseNext();
            }
        }

        // Affiche le nœud terminal final
        currentNode.display();
    }

    public void saveGame() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(getSaveFileName()))) {
            outputStream.writeObject(this);
            System.out.println("Partie sauvegardée avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getSaveFileName() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy 'à' HH_mm_ss", Locale.FRENCH);
        String formattedDate = dateFormat.format(now);
        return "savegame_" + formattedDate + ".ser";
    }


    public static List<String> listSaves() {
        File savesDirectory = new File(".");
        File[] saveFiles = savesDirectory.listFiles((dir, name) -> name.startsWith("savegame_") && name.endsWith(".ser"));

        if (saveFiles == null) {
            return Collections.emptyList();
        }

        Arrays.sort(saveFiles, Comparator.comparingLong(File::lastModified).reversed());

        List<String> saveFileNames = new ArrayList<>();
        for (File saveFile : saveFiles) {
            saveFileNames.add(saveFile.getName());
        }

        return saveFileNames;
    }

    public static Game loadGame(String saveFileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(saveFileName))) {
            return (Game) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class SaveNode extends DecisionNode {
    public SaveNode(int id, String description) {
        super(id, description);
    }

    public Event chooseNext(Game game) {
        // Affiche les options disponibles
        System.out.println("Choisissez une option :");
        System.out.println("1. Continuer l'aventure");
        System.out.println("2. Sauvegarder et quitter");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                return nextNodes.get(0); // Continuer l'aventure

            case 2:
                game.saveGame(); // Sauvegarder et quitter
                System.out.println("Partie sauvegardée avec succès. Merci d'avoir joué !");
                System.exit(0);

            default:
                System.out.println("Choix non valide. Veuillez choisir à nouveau.");
                return this;
        }
    }
}