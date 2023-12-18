package representation;

import java.util.List;
import java.util.Scanner;

public class DecisionNode extends Node {
    private List<Node> nextNodes;

    public DecisionNode(int id, String description, List<Node> nextNodes) {
        super(id, description);
        this.nextNodes = nextNodes;
    }
    
    public DecisionNode(int id, String description) {
        super(id, description);
    }

    public void setNextNodes(List<Node> nextNodes) {
        this.nextNodes = nextNodes;
    }

    @Override
    public Node chooseNext() {
        while (true) {
            // Affiche les options disponibles
            System.out.println("Choisissez une option :");
            
            // Récupère le choix de l'utilisateur
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();

            // Vérifie que le choix est valide
            if (userChoice >= 1 && userChoice <= nextNodes.size()) {
                return nextNodes.get(userChoice - 1);
            } else {
                System.out.println("Choix non valide. Veuillez choisir à nouveau.");
            }
        }
    }

}