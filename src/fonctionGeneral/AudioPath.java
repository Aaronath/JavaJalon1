/**
 * Contient les classes des fonctions utilisées dans le programme.
 * @since 1.0
 */
package fonctionGeneral;

/**
 * L'énumération AudioPath contient les chemins vers des fichiers audio utilisés dans le programme.
 * Chaque élément de l'énumération représente un chemin vers un fichier audio spécifique.
 */
public enum AudioPath {

    /** Chemin d'origine pour les fichiers audio. */
    ORIGIN("src/sounds/"),

    /** Chemin vers le fichier audio "1-up.wav". */
    JUMP(ORIGIN.getPath() + "1-up.wav"),
    
    OPPONENT(ORIGIN.getPath() + "opponent.wav"),
    
    COMIC(ORIGIN.getPath() + "comic.wav"),
    
    LASER(ORIGIN.getPath() + "laser.wav"),
    
    SECOND(ORIGIN.getPath() + "second.wav"),
    
    BOUND(ORIGIN.getPath() + "bound.wav"),
    
    ROOM(ORIGIN.getPath() + "room.wav"),
    
    HAKI(ORIGIN.getPath() + "haki.wav"),
    
    OST(ORIGIN.getPath() + "ost.wav"),
    
    WHOOSH(ORIGIN.getPath() + "whoosh.wav"),
    
    COMBAT(ORIGIN.getPath() + "combatSound.wav"),
    
    BINKS(ORIGIN.getPath() + "binks.wav"),

    /** Chemin vers le fichier audio "game-over.wav". */
    GAMEOVER(ORIGIN.getPath() + "game-over.wav"),

    /** Chemin vers le fichier audio "monde-termine.wav". */
    FINALEND(ORIGIN.getPath() + "monde-termine.wav"),

    /** Chemin vers le fichier audio "niveau-termine.wav". */
    LEVELEND(ORIGIN.getPath() + "niveau-termine.wav"),

    /** Chemin vers le fichier audio "power-up.wav". */
    POWERUP(ORIGIN.getPath() + "power-up.wav");

    /** Le chemin vers le fichier audio. */
    private final String path;

    /**
     * Constructeur de l'énumération AudioPath.
     * @param path Le chemin vers le fichier audio.
     */
    AudioPath(String path) {
        this.path = path;
    }

    /**
     * Obtient le chemin vers le fichier audio.
     * @return Le chemin vers le fichier audio.
     */
    public String getPath() {
        return path;
    }
}
