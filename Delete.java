
import java.io.File;

/**
 * Write a description of class Delete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Delete
{
	
	
	
	public static boolean deleteFile(String filePath){
		
		File file = new File(filePath);
		
		return file.delete();
	}
	
}
