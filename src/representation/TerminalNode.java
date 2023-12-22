/**
 * Contient les classes des différents nodes utilisés dans le programme.
 * @since 1.0
 */
package representation;

import java.util.List;

/**
 * La classe TerminalNode représente un nœud terminal dans une structure d'arbre narratif.
 * Elle marque la fin du jeu ou de l'histoire.
 */
public class TerminalNode extends Node {

    /**
     * Constructeur de TerminalNode.
     * @param id L'identifiant du nœud terminal.
     * @param description La description du nœud terminal.
     */
    public TerminalNode(int id, String description) {
        super(id, description);
    }

    /**
     * Choix du prochain nœud.
     * En tant que nœud terminal, le jeu se termine ici.
     * @return Le nœud terminal actuel.
     */
    @Override
    public Node chooseNext() {
        return this;
    }

    /**
     * Définit la liste des événements suivants possibles après ce nœud terminal.
     * Dans un nœud terminal, cette méthode ne fait rien, car il n'y a pas de nœud suivant.
     * @param asList La liste des événements suivants possibles.
     */
    @Override
    public void setNextNodes(List<Event> asList) {
        // Ne fait rien, car un nœud terminal n'a pas de nœuds suivants.
    }
}
