
import java.io.File;

/**
 * class Delete that has a boolean method deleteFile
 *
 * @author Milena Vallejos
 * @date May 19
 */
public class Delete {
	/**
	 * Method to deleteFile from a filePath
	 *
	 * @param filePathToDelete is a String (file path)
	 * @return a boolean returns true if they could delete the file
	 * false if there was an error to delete
	 */
	public static boolean deleteFile(String filePathToDelete)
	{
		try {
			File file = new File(filePathToDelete);

			return file.delete();

		} catch (IOException ioe)
		{
			return false;
		}
	}

}
