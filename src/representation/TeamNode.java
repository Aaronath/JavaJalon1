package representation;


import univers.Character;
import univers.Player;
import univers.Marine.Capitaine;
import univers.Marine.MarineSoldier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import fonctionGeneral.Utils;

/**
 * La classe CrewNode représente un nœud de décision permettant au joueur de recruter
 * ou non un nouveau membre d'équipage.
 * 
 * Si le joueur n'est pas déjà un capitaine pirate, il devient un PirateCaptain,
 * et le personnage recruté (qui peut être un PirateRookie) est ajouté à sa crewList.
 * 
 * @author Nathan Halioua
 */
public class TeamNode extends DecisionNode {
	private MarineSoldier teamNew;
	private Player player;

    public TeamNode(int id, String description, MarineSoldier teamNew, Player player) {
        super(id, description);
        this.teamNew = teamNew;
        this.player = player;
    }

    @Override
    public Event chooseNext() {
    	while (true) {
            // Affiche les options disponibles
            System.out.println("Choisissez une option :");
            
            // Récupère le choix de l'utilisateur
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();

            // Vérifie que le choix est valide
            if (userChoice >= 1 && userChoice <= nextNodes.size()) {
            	if (userChoice == 2) {
            		recruitTeamMember();
					return nextNodes.get(userChoice - 1);
				} else if (userChoice == 1) {
					return nextNodes.get(userChoice - 1);
				}
                
            } else {
                System.out.println("Choix non valide. Veuillez choisir à nouveau.");
            }
        }
    }

    private void recruitTeamMember() {
        // Vérifiez si le joueur est un PirateCaptain
        if (player.getCharacter() instanceof Capitaine) {
        	((Capitaine) player.getCharacter()).getTeamList().add(teamNew);
        } else {
        	Utils.displayText("Tu t'apprêtes à créer une équipe, il faut lui donner un nom :");
            
            // Récupère le choix de l'utilisateur
            Scanner scanner = new Scanner(System.in);
            String teamName = scanner.nextLine();
            Utils.displayText(teamName + " c'est ça ? (1 pour oui, 0 pour non)");
            int confirmation = scanner.nextInt();
            scanner.nextLine();
            while(confirmation == 0) {
            	Utils.displayText("Répète moi ton prénom dans ce cas : ");
            	teamName = scanner.nextLine();
            	Utils.displayText(teamName + " c'est ça ? (1 pour oui, 0 pour non)");
            	confirmation = scanner.nextInt();
            	scanner.nextLine();
            }
        	
            // Si le joueur n'est pas déjà un PirateCaptain
            List<MarineSoldier> teamList = new ArrayList<>();
        	player.setCharacter(new Capitaine(player.getName(), player.getPowerLevel(), teamName, teamList));
        	Utils.displayText("Tu es désormais Capitaine ! Tes stats ont augmentées !");
        	recruitTeamMember();
        }
    }
    
}
