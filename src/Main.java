import representation.*;
import fonctionGeneral.*;
import univers.*;
import univers.Character;
import univers.Marine.NouvelleRecrue;
import univers.Pirate.Monster;
import univers.Pirate.Pirate;
import univers.Pirate.PirateCaptain;
import univers.Pirate.PirateRookie;
import univers.Pirate.PirateSupernova;
import fonctionGeneral.AudioPath;
import fonctionGeneral.Utils;

import java.io.NotActiveException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Configuration initiale du jeu
        Game game = new Game();
        game.configureGame();

        // Lancement du jeu
        game.start();
    }
}