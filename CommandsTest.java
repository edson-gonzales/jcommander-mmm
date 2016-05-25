
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommandsTest.
 *
 * @author  Milena vallejos  * @version 18 de mayo 2016
 */
public class CommandsTest
{
    /**
     * Default constructor for test class CommandsTest
     */
    @Test
    public void testCommandCopy()
    
    
    {
        
         
     
         assertTrue( Copy.copyFile("C:\\Users\\Milena\\Music\\Grapes - I dunno.mp3","C:\\Users\\Milena\\Documents"));
    }
     @Test
    public void testCommandMove()
    {
       // assertTrue(true);
        assertTrue( Move.moveFile("C:\\Users\\Milena\\Documents\\Grapes - I dunno.mp3","C:\\Users\\Milena\\Music\\Grapes - I dunno.mp3"));
    }
     @Test
    public void testCommandDelete()
    {
        assertTrue(Delete.deleteFile("C:\\Users\\Milena\\Music\\Grapes - I dunno.mp3"));
    }
}
