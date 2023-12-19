package fonctionGeneral;

public enum ImagePath {
	ORIGIN("src/images/"),
    TEST(ORIGIN.getPath()+"test.png");
    
    private final String path;

    ImagePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
