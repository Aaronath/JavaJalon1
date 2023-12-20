package fonctionGeneral;

/**
 * La classe Utils fournit des méthodes utilitaires pour l'affichage de texte.
 */
public class Utils {

    /**
     * Affiche le texte caractère par caractère avec un délai de 15 millisecondes entre chaque caractère.
     * @param text Le texte à afficher.
     */
    public static void displayText(String text) {
        char[] descriptionChars = text.toCharArray();

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
}
