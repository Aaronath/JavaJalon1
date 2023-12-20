package representation;

import java.util.List;
import java.util.Scanner;

/**
 * La classe DecisionNode représente un nœud de décision dans une structure d'arbre.
 * Elle étend la classe Node et permet à l'utilisateur de choisir parmi différentes options
 * pour déterminer le prochain événement dans le flux narratif.
 */
public class DecisionNode extends Node {

    /** Liste des nœuds d'événements possibles après ce nœud de décision. */
    private List<Event> nextNodes;

    /**
     * Constructeur permettant de créer un nœud de décision avec un identifiant, une description
     * et une liste d'événements possibles après ce nœud.
     *
     * @param id L'identifiant du nœud de décision.
     * @param description La description du nœud de décision.
     * @param nextNodes La liste des événements possibles après ce nœud de décision.
     */
    public DecisionNode(int id, String description, List<Event> nextNodes) {
        super(id, description);
        this.nextNodes = nextNodes;
    }
    
    /**
     * Constructeur permettant de créer un nœud de décision avec un identifiant et une description.
     *
     * @param id L'identifiant du nœud de décision.
     * @param description La description du nœud de décision.
     */
    public DecisionNode(int id, String description) {
        super(id, description);
    }

    /**
     * Définit la liste des événements possibles après ce nœud de décision.
     *
     * @param nextNodes La liste des événements possibles après ce nœud de décision.
     */
    public void setNextNodes(List<Event> nextNodes) {
        this.nextNodes = nextNodes;
    }

    /**
     * Permet à l'utilisateur de choisir parmi les options disponibles et retourne
     * l'événement correspondant au choix de l'utilisateur.
     *
     * @return L'événement choisi par l'utilisateur.
     */
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
                return nextNodes.get(userChoice - 1);
            } else {
                System.out.println("Choix non valide. Veuillez choisir à nouveau.");
            }
        }
    }
}
