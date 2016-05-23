package core;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Marcelo loayza on 22/05/2016.
 */
public class CreateFile {

    private String newFilePath;

    /**
     * constructor of the class
     */
    public CreateFile(String newPath)
    {
        newFilePath = newPath;

    }
    /**
     * This class create a file using a string for the new file name
     * and the Path with the location that will be used on the creation
     */

    public Boolean createNewFile(String filename) throws IOException {

        Boolean fileCreated = true;
        String fileCreatedName = filename;
        String pathName = newFilePath+fileCreatedName;
        Path newPath = Paths.get(pathName);

        Files.createDirectories(newPath.getParent());

        try {
            Files.createFile(newPath);
        } catch (FileAlreadyExistsException e) {
            System.err.println("already exists: " + e.getMessage());
            fileCreated =false;

        }
        return fileCreated;
    }
}
