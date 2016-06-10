package core;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * Created by Marcelo Loayza on 22/05/2016.
 */
public class ZipFile {
    static final int BUFFER = 2048;

    /**
     * this is a method will be used to compress files on Zip
     *
     * @param fileListed it is the list with the files that will be compress
     * @param ZipName this is the name that will be used to create the zip file
     */
    public ZipFile (List<File> fileListed, String ZipName) {

        try{

            FileOutputStream fileZipName = new FileOutputStream(ZipName);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileZipName);

            for(File fileName: fileListed)
            {

                ZipEntry ze = new ZipEntry(fileName.getName());
                zipOutputStream.putNextEntry(ze);

                zipOutputStream.closeEntry();
            }
            zipOutputStream.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }



}
