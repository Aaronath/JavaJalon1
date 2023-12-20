package univers;

/**
 * L'interface PowerLevel définit le contrat pour les entités ayant un niveau de puissance.
 * Les classes implémentant cette interface doivent fournir une méthode pour récupérer le niveau de puissance.
 * 
 * @author [Votre nom]
 */
public interface PowerLevel {

    /**
     * Récupère le niveau de puissance de l'entité.
     *
     * @return Le niveau de puissance de l'entité.
     */
    public int getPowerLevel();
}
