package fonctionGeneral;

public enum AudioPath {
    ORIGIN("src/sounds/"),
    JUMP(ORIGIN.getPath()+"1-up.wav"),
    GAMEOVER(ORIGIN.getPath()+"game-over.wav"),
    FINALEND(ORIGIN.getPath()+"monde-termine.wav"),
    LEVELEND(ORIGIN.getPath()+"niveau-termine.wav"),
    POWERUP(ORIGIN.getPath()+"power-up.wav");
    
    private final String path;

    AudioPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
