package core;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Marcelo Loayza on 17/05/2016.
 */
public class Folder extends Item {

    public Folder (File file) {
        super(file);
    }

    /**
     * List of files and folders that are on a path
     */
    public List<String> listFilesAndFolders(String directoryName)
    {
        List<String> fileListed = new ArrayList<String>();
        File directory = new File(directoryName);

        //get all the files from a directory
        File[] fullFileList = directory.listFiles();

        for (File file : fullFileList){
            fileListed.add(file.getName());
        }

        return fileListed;
    }
}
