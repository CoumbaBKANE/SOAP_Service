package esp.dic2.softarchitecture.finalproject.configs;


import java.io.File;

public class FileManager {
    private static FileManager instance;
    private final String absolutePath;

    public String getAbsolutePath() {
        return absolutePath;
    }

    private FileManager() {
        File currentFile = new File(".");
        this.absolutePath = currentFile.getAbsolutePath();
    }

    public static FileManager getInstance() {
        if (instance == null) instance = new FileManager();
        return instance;
    }

}
