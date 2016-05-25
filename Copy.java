 
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
 
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
 
/**
 * Write a description of class Copy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Copy
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Copy
     */
   public static boolean copyFile(String fromFile, String toFile) {
        File origin = new File(fromFile);
        File destination = new File(toFile);
        if (origin.exists()) {
            try {
                InputStream in = new FileInputStream(origin);
                OutputStream out = new FileOutputStream(destination);
                
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                return true;
            }finally{
                return false;
            }
        } else {
            return false;
        }
    }
    
 
}
