import representation.*;
import fonctionGeneral.*;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = null;

        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Nouvelle Partie");
            System.out.println("2. Charger Partie");
            System.out.println("3. Quitter");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choice) {
                case 1:
                    game = new Game();
                    game.configureGame();
                    game.start();
                    break;
                case 2:
                    listAndLoadSaves(scanner, game);
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez choisir à nouveau.");
            }
        }
    }

    private static void listAndLoadSaves(Scanner scanner, Game game) {
        System.out.println("Liste des sauvegardes :");
        List<String> saveFiles = Game.listSaves();

        if (saveFiles.isEmpty()) {
            System.out.println("Aucune sauvegarde trouvée.");
        } else {
            for (int i = 0; i < saveFiles.size(); i++) {
                System.out.println((i + 1) + ". " + saveFiles.get(i));
            }

            System.out.println("Choisissez une sauvegarde (0 pour annuler) :");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            if (choice > 0 && choice <= saveFiles.size()) {
                String selectedSave = saveFiles.get(choice - 1);
                game = Game.loadGame(selectedSave);

                if (game != null) {
                    System.out.println("Partie chargée avec succès.");
                    game.start();
                } else {
                    System.out.println("Erreur lors du chargement de la partie.");
                }
            }
        }
    }
}