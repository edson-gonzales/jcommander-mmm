package commands;

import java.io.File;
import java.io.IOException;

/**
 * class Rename that has a boolean method renameFile
 * @author Milena Vallejos
 * @date May 24
 */
public class Rename
{
    /**
     * Method to renameFile
     * @param actualName is a String (the origin name)
     * @param toRename is a String (the new name)
     * @return a boolean returns true if they could rename the file
     * false if there was an error to rename
     */
    public static boolean RenameFile(String actualName,String toRename)
    {
        try
        {
            File initialName = new File(actualName);
            File finalName = new File(toRename);

            if (initialName.renameTo(finalName))
            {
                return true;
            }
        }
        catch (IOException ioe)
        {
            return false;
        }

    }

}

