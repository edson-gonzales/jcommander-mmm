package core;

import java.io.*;

import static core.FileSizeType.BYTES;

/**
 * Created by Marcela Barrionuevo on 30/05/2016.
 */
public class FormatterSize {

    private double sizeBytes;
    private double sizeKB;
    private double sizeMB;
    private double sizeGB;
    private double sizeTB;

    public FormatterSize(double sizeBytes) {

        this.sizeBytes = sizeBytes;
        sizeKB = (sizeBytes / 1024);
        sizeMB = (sizeKB / 1024);
        sizeGB = (sizeMB / 1024);
        sizeTB = (sizeGB / 1024);
    }

    private double getSizeBytes() {
        return sizeBytes;
    }

    private double getSizeKB() {
        return sizeKB;
    }

    private double getSizeMB() {
        return sizeMB;
    }

    private double getSizeGB() {
        return sizeGB;
    }

    private double getSizeTB() {
        return sizeTB;
    }

    public String getFileSize() {

        String fileSize = sizeBytes + " Bytes";

        if (sizeKB >= 1) {
            fileSize = sizeKB + " KB";
        } else if (sizeMB >= 1) {
            fileSize = sizeMB + " MB";
        } else if (sizeGB >= 1) {
            fileSize = sizeGB + " GB";
        } else if (sizeTB >= 1) {
            fileSize = sizeTB + " TB";
        }

        return fileSize;
    }

    public String getFileSize(FileSizeType sizeType) {
        String fileSize = "";
        switch (sizeType) {
            case BYTES: fileSize = getSizeBytes() + " Bytes";
                break;
            case KB: fileSize = getSizeKB() + " KB";
                break;
            case MB: fileSize = getSizeMB() + " MB";
                break;
            case GB: fileSize = getSizeGB() + " GB";
                break;
            case TB: fileSize = getSizeTB() + " TB";
                break;
        }

        return fileSize;
    }
}

