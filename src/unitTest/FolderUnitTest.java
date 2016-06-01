package unitTest;

import static org.junit.Assert.*;

import core.CreateFile;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import core.Folder;

/**
 * Created by casa on 24/05/2016.
 */
public class FolderUnitTest {

    @Test
    public void testListedFilesAndFoldersForAPath()
    {
        List<String> listeToCompare = new ArrayList<String>();

        String pathLocation = "c://test//";
        String testName = "testForCreate.txt";
        CreateFile newFileForTest = new CreateFile(pathLocation);
        newFileForTest.createNewFile(testName);

        listeToCompare.add(testName);

        Folder testFolder = new Folder("test", "C:\\test");
        List<String> folderList = testFolder.listFilesAndFolders(testFolder.getLocation());
        folderList.removeAll(listeToCompare);

        assertTrue(folderList.isEmpty());

    }
}
