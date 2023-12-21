package representation;

import java.io.Serializable;

/**
 * La classe abstraite Node est une représentation générique d'un nœud dans une structure d'arbre narratif.
 * Elle implémente l'interface Event, fournissant des méthodes de base pour afficher le nœud, obtenir sa description,
 * et déterminer le prochain événement dans le déroulement de l'histoire.
 */
public abstract class Node implements Event, Serializable {

    /** L'identifiant unique du nœud. */
    protected int id;

    /** La description du nœud. */
    protected String description;

    /**
     * Constructeur de Node.
     * @param id L'identifiant du nœud.
     * @param description La description du nœud.
     */
    public Node(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * Affiche la description du nœud caractère par caractère avec un délai de 15 millisecondes entre chaque caractère.
     */
    public void display() {
        char[] descriptionChars = description.toCharArray();

        for (char c : descriptionChars) {
            System.out.print(c);
            try {
                Thread.sleep(15); // Délai de 15 millisecondes entre chaque caractère
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // Nouvelle ligne à la fin
    }

    /**
     * Obtient la description du nœud.
     * @return La description du nœud.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description du nœud.
     * @param description La nouvelle description du nœud.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du nœud.
     * @return Une chaîne de caractères représentant le nœud.
     */
    @Override
    public String toString() {
        return "Node{id=" + id + ", description='" + description + "'}";
    }

    /**
     * Vérifie l'égalité entre le nœud actuel et un autre objet.
     * @param obj L'objet avec lequel comparer le nœud.
     * @return true si les nœuds sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Node node = (Node) obj;

        return id == node.id &&
               (description != null ? description.equals(node.description) : node.description == null);
    }

    /**
     * Génère un code de hachage pour le nœud.
     * @return Le code de hachage du nœud.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    /**
     * Méthode abstraite pour choisir le prochain événement dans le déroulement de l'histoire.
     * @return L'événement suivant.
     */
    public abstract Event chooseNext();
}
