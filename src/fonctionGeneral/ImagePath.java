package fonctionGeneral;

/**
 * L'énumération ImagePath contient les chemins vers des fichiers image utilisés dans le programme.
 * Chaque élément de l'énumération représente un chemin vers un fichier image spécifique.
 */
public enum ImagePath {

    /** Chemin d'origine pour les fichiers image. */
    ORIGIN("src/images/"),

    /** Chemin vers le fichier image "test.png". */
    OPPONENT(ORIGIN.getPath() + "opponent.jpeg"),
    
    BESTFRIEND(ORIGIN.getPath() + "bestFriend.png"),
    
    ISLAND(ORIGIN.getPath() + "islandChoice.jpeg"),
    
    SAVE(ORIGIN.getPath() + "save.jpeg"),
    
    MONSTER(ORIGIN.getPath() + "monster.jpeg"),
    
    PUNCH(ORIGIN.getPath() + "monsterPunched.jpeg");

    /** Le chemin vers le fichier image. */
    private final String path;

    /**
     * Constructeur de l'énumération ImagePath.
     * @param path Le chemin vers le fichier image.
     */
    ImagePath(String path) {
        this.path = path;
    }

    /**
     * Obtient le chemin vers le fichier image.
     * @return Le chemin vers le fichier image.
     */
    public String getPath() {
        return path;
    }
}
