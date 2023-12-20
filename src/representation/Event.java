package representation;

import java.util.List;

/**
 * L'interface Event représente un événement dans une structure narrative.
 * Les classes implémentant cette interface doivent fournir des méthodes
 * pour afficher l'événement, choisir le prochain événement, et définir
 * la liste des événements suivants.
 */
public interface Event {

    /**
     * Affiche les détails de l'événement.
     */
    public void display();

    /**
     * Permet de choisir le prochain événement dans le déroulement de l'histoire.
     * @return L'événement suivant.
     */
    public Event chooseNext();

    /**
     * Définit la liste des événements suivants possibles après cet événement.
     * @param nextNodes La liste des événements suivants possibles.
     */
    public void setNextNodes(List<Event> nextNodes);
}
