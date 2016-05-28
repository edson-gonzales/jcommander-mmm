import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
 
/**
 * class Copy that has a boolean method copyFile 
 * @author Milena Vallejos 
 * @date May 19
 */
public class Copy
{
    
    /**
     * Method to copyfile from a source origin fromFile
     * to a destination toFile
     * @param fromFile is a String (source file path)
     * @param toFile is a String( destination file path) (ruta del fichero
     * destino).
     * @return a boolean returns true if they could copy the file
     * false if there was an error to copy
     */
   public static boolean copyFile(String fromFile, String toFile) {
        File origin = new File(fromFile);
        File destination = new File(toFile);
        
            try {
                InputStream in = new FileInputStream(origin);
                OutputStream out = new FileOutputStream(destination);
                // Using a buffer for the Copy
                byte[] buf = new byte[1024];
                int len;
               /*In the while cycle
                *Read from in and stores the result in buf.
                *Stores the length of the read content in len.
                *Compares the read length with 0 to determine whether in has returned content or reading is finished.
                */
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                return true;
            }catch (IOException ioe){
                return false;
            }
        
    }
    
 
}
