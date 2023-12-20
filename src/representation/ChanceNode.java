package representation;

import java.util.List;
import java.util.Random;

/**
 * La classe ChanceNode représente un nœud qui conduit à un nœud aléatoire, 
 * en fonction de la chance du joueur.
 * @author Nathan Halioua
 */
public class ChanceNode extends Node {

    /** Liste des nœuds suivants possibles après ce nœud de chance. */
    protected List<Event> nextNodes;

    /**
     * Constructeur de ChanceNode sans spécification des nœuds suivants.
     * @param id L'identifiant du nœud de chance.
     * @param description La description du nœud de chance.
     */
    public ChanceNode(int id, String description) {
        super(id, description);
    }

    /**
     * Constructeur de ChanceNode avec la spécification des nœuds suivants.
     * @param id L'identifiant du nœud de chance.
     * @param description La description du nœud de chance.
     * @param nextNodes La liste des nœuds suivants possibles après ce nœud de chance.
     */
    public ChanceNode(int id, String description, List<Event> nextNodes) {
        super(id, description);
        this.nextNodes = nextNodes;
    }

    /**
     * Obtient la liste des nœuds suivants possibles après ce nœud de chance.
     * @return La liste des nœuds suivants possibles.
     */
    public List<Event> getNextNodes() {
        return nextNodes;
    }

    /**
     * Sélectionne aléatoirement le nœud suivant en fonction de la chance du joueur.
     * @return L'événement suivant.
     */
    @Override
    public Event chooseNext() {
        // Simulez un événement aléatoire
        Random random = new Random();
        int randomChoice = random.nextInt(nextNodes.size());

        // Retournez le nœud correspondant au choix aléatoire.
        return nextNodes.get(randomChoice);
    }

    /**
     * Définit la liste des nœuds suivants possibles après ce nœud de chance.
     * @param nextNodes La liste des nœuds suivants possibles.
     */
    @Override
    public void setNextNodes(List<Event> nextNodes) {
        this.nextNodes = nextNodes;
    }

}
