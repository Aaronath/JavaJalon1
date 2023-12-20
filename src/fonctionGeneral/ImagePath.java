package fonctionGeneral;

/**
 * L'énumération ImagePath contient les chemins vers des fichiers image utilisés dans le programme.
 * Chaque élément de l'énumération représente un chemin vers un fichier image spécifique.
 */
public enum ImagePath {

    /** Chemin d'origine pour les fichiers image. */
    ORIGIN("src/images/"),

    /** Chemin vers le fichier image "test.png". */
    TEST(ORIGIN.getPath() + "test.png");

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
