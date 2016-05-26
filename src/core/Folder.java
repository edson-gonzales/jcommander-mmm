package core;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Marcelo Loayza on 17/05/2016.
 */
public class Folder extends Item {

    public Folder (File fileSystemItem) {
        super(fileSystemItem);
    }

    /**
     * Returns a list of files and folders that are located on an absolute path.
     *
     * @param   workingPath an absolute path giving the base location of the files and folders.
     * @return                the list of files an folders.
     */
    public List<String> listFilesAndFolders(String workingPath)
    {
        List<String> filesListed = new ArrayList<String>();

        try {
            File directory = new File(workingPath);

            if (!directory.exists()) {
                return filesListed;
            }

            File[] fullFileList = directory.listFiles();

            for (File file : fullFileList){
                filesListed.add(file.getName());
            }

        } catch (Exception exception) {
            System.out.println("Error getting files and folders: " + exception.getMessage());
        }

        return filesListed;
    }
}
