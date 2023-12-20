package univers;

/**
 * L'interface Attaque définit des méthodes pour effectuer une attaque simple et une attaque spéciale.
 * Les classes implémentant cette interface doivent fournir une implémentation de ces méthodes.
 */
public interface Attaque {

    /**
     * Effectue une attaque simple sur un personnage.
     * @param c Le personnage sur lequel effectuer l'attaque.
     */
    public void attaqueSimple(Character c);

    /**
     * Effectue une attaque spéciale sur un personnage.
     * @param c Le personnage sur lequel effectuer l'attaque spéciale.
     */
    public void attaqueSpeciale(Character c);
}
