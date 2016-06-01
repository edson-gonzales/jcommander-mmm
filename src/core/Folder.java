package core;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Marcelo Loayza on 17/05/2016.
 */
public class Folder{


    private String name;
    private String pathLoacation;

    public Folder (String fileName, String fileLocation) {
        name = fileName;
        pathLoacation = fileLocation;
    }

    /**
     * List of files and folders that are on a path
     */
    public List<String> listFilesAndFolders(String directoryFullFileName)
    {
        List<String> fileListed = new ArrayList<String>();
        File directory = new File(directoryFullFileName);

        //get all the files from a directory
        File[] fullFileList = directory.listFiles();

        for (File file : fullFileList){
            fileListed.add(file.getName());
        }

        return fileListed;
    }

    public String getLocation() {
        return pathLoacation;
    }
}
