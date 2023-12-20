package representation;

import java.util.List;

/**
 * La classe InnerNode représente un nœud interne dans une structure d'arbre,
 * avec des événements suivants possibles.
 */
public class InnerNode extends Node {

    /** Liste des événements suivants possibles après ce nœud interne. */
    protected List<Event> nextNodes;

    /**
     * Constructeur de InnerNode avec la spécification des nœuds suivants.
     * @param id L'identifiant du nœud interne.
     * @param description La description du nœud interne.
     * @param nextNodes La liste des événements suivants possibles après ce nœud interne.
     */
    public InnerNode(int id, String description, List<Event> nextNodes) {
        super(id, description);
        this.nextNodes = nextNodes;
    }

    /**
     * Constructeur de InnerNode sans spécification des nœuds suivants.
     * @param id L'identifiant du nœud interne.
     * @param description La description du nœud interne.
     */
    public InnerNode(int id, String description) {
        super(id, description);
    }

    /**
     * Obtient la liste des événements suivants possibles après ce nœud interne.
     * @return La liste des événements suivants possibles.
     */
    public List<Event> getNextNodes() {
        return nextNodes;
    }

    /**
     * Définit la liste des événements suivants possibles après ce nœud interne.
     * @param nextNodes La liste des événements suivants possibles.
     */
    public void setNextNodes(List<Event> nextNodes) {
        this.nextNodes = nextNodes;
    }

    /**
     * Permet de choisir le prochain événement dans le déroulement de l'histoire.
     * Si la liste des nœuds suivants est vide, retourne le nœud actuel.
     * @return L'événement suivant.
     */
    @Override
    public Event chooseNext() {
        if (nextNodes.isEmpty()) {
            // Gérez le cas où il n'y a pas de nœud suivant.
            return this; // Par défaut, revenez au nœud actuel.
        }
        return nextNodes.get(0);
    }
}
