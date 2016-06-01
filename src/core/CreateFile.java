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
     * The constructor class we will use to create a new CreateFile object
     *
     * @param newPath it is an string that we will use to add the path location were we will create a new file
     */
    public CreateFile(String newPath)
    {
        newFilePath = newPath;

    }


    /**
     * This class create a file using a string for the new file name
     * and the Path with the location that will be used on the creation
     *
     * @param fileName is the string used for the name of the file we will create
     * @return fileCreated it is a Boolean that returns true when the file is created and false is the file was not created
     */

    public Boolean createNewFile(String fileName){

        Boolean fileCreated = true;
        String fileCreatedName = fileName;
        String pathName = newFilePath + fileCreatedName;
        Path newPath = Paths.get(pathName);

        try {
            Files.createDirectories(newPath.getParent());
            Files.createFile(newPath);
        } catch (FileAlreadyExistsException e) {
            System.err.println("already exists: " + e.getMessage());
            fileCreated =false;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileCreated;
    }
}
