package unitTest;

import core.CreateFile;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
/**
 * Created by Marcelo Loayza on 22/05/2016.
 */
public class CreateFileUnitTest {


    /**
     * we are verifying that the file was create using createNewFile
     */
    @Test
    public void testCreateFileUsingStringName() throws IOException {

        String pathLocation = "c://test//";
        String testName = "testForCreate.txt";
        CreateFile newFileForTest = new CreateFile(pathLocation);

        assertTrue(newFileForTest.createNewFile(testName));

    }

}
