/**
 * Contient les classes des différents nodes utilisés dans le programme.
 * @since 1.0
 */
package representation;

import java.io.Serializable;

/**
 * La classe abstraite NodeDecorator est une représentation générique d'un décorateur de nœud dans une structure d'arbre narratif.
 * Elle implémente l'interface Event, fournissant des méthodes pour afficher le nœud décoré et choisir le prochain événement dans le déroulement de l'histoire.
 */
public abstract class NodeDecorator implements Event, Serializable {

    /** Le nœud décoré par le décorateur. */
    protected Event decoratedEvent;

    /**
     * Constructeur de NodeDecorator.
     * @param decoratedEvent Le nœud à décorer.
     */
    public NodeDecorator(Event decoratedEvent) {
        this.decoratedEvent = decoratedEvent;
    }

    /**
     * Affiche le nœud décoré en appelant la méthode display() du nœud décoré.
     */
    @Override
    public void display() {
        decoratedEvent.display();
    }

    /**
     * Permet de choisir le prochain événement dans le déroulement de l'histoire en appelant la méthode chooseNext() du nœud décoré.
     * @return L'événement suivant.
     */
    @Override
    public Event chooseNext() {
        return decoratedEvent.chooseNext();
    }

	public Event getDecoratedEvent() {
		return decoratedEvent;
	}
}


