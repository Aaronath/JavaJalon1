package fonctionGeneral;


public class Utils {
    public static void displayText(String text) {
        char[] descriptionChars = text.toCharArray();

        for (char c : descriptionChars) {
            System.out.print(c);
            try {
                Thread.sleep(15); // Délai de 100 millisecondes entre chaque caractère
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // Nouvelle ligne à la fin
    }
}
