package core;

import java.io.FilenameFilter;
import java.io.File;

/**
 * Created by casa on 10/06/2016.
 */
public class SearchFileOnAPath {


    File fileDirectoryPath;
    File[] matchingFiles;

    /**
     * this method search files that match with a work
     *
     *
     * @param directoryPath it is the path of the directory on we will search the files
     * @param fileToSearch this the file name we will search on the directory
     */
    public SearchFileOnAPath(String directoryPath, String fileToSearch){

        fileDirectoryPath = new File(directoryPath);
        matchingFiles = fileDirectoryPath.listFiles(new FilenameFilter() {

            public boolean accept(File dir, String name) {
                return name.startsWith(fileToSearch);
            }
        });
    }
    public File[] getMatchingFiles() {
        return matchingFiles;
    }
}
