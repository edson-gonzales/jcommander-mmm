
import java.io.File;

/**
 * class Rename that has a boolean method renameFile 
 * @author Milena Vallejos 
 * @date May 24
 */
public class Rename
{ /**
     * Method to renameFile 
     * @param filename is a String (the origin name)
     * @param filename2 is a String (the new name)
     * @return a boolean returns true if they could rename the file
     * false if there was an error to rename
     */
	
	
	public static boolean RenameFile(String fileName,String fileName2) throws java.io.IOException
	{
		
		 File file1 = new File(fileName);
		 File file2 = new File(fileName2);
		
          if( file1.renameTo(file2))
          {
            return true;
        }
           else
            {
                return false;
            }
            
            
	}
	
}
