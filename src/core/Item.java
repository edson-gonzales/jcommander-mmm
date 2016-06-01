package core;

import commands.Command;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcelo Loayza on 17/05/2016.
 * added functionality By Marcela Barrionuevo in order to create the Map
 * Added the functionality for Size attributes location and Type
 */
public class Item {

    private String name;
    private String location;
    private String type;
    private double sizeBytes;
    private double sizeKB;
    private double sizeMB;
    private double sizeGB;
    private double sizeTB;
    private Date lastModified;
    private String filePermissions;

    private Map<String, String> map;

    public Item (java.io.File file) {

        if (file.isFile()) {
            int i = file.getName().lastIndexOf('.');
            if (i > 0) {
                name = file.getName().substring(0, i);
                type = file.getName().substring(i + 1);
            }
        } else {
            name = file.getName();
            type = "";
        }

        lastModified = new Date(file.lastModified());
        location = file.getPath();
        sizeBytes = file.length();
        sizeKB = (sizeBytes / 1024);
        sizeMB = (sizeKB / 1024);
        sizeGB = (sizeMB / 1024);
        sizeTB = (sizeGB / 1024);

        filePermissions = "";
        if (file.canRead()) {
            filePermissions += "r";
        } else {
            filePermissions += "-";
        }
        if (file.canWrite()) {
            filePermissions += "w";
        } else {
            filePermissions += "-";
        }
        if (file.canExecute()) {
            filePermissions += "x";
        } else {
            filePermissions += "-";
        }

        map = new HashMap<String, String>();
    }

    public Map<String, String> showProperties() {
        return map;
    }

    public boolean executeCommand(Command command) {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        String fileSize = "";

        if (sizeBytes < 1024) {
            fileSize = sizeBytes + " Bytes";
        } else if (sizeKB < 1024) {
            fileSize = sizeKB + " KB";
        } else if (sizeMB < 1024) {
            fileSize = sizeMB + " MB";
        } else if (sizeGB < 1024) {
            fileSize = sizeGB + " GB";
        } else if (sizeTB < 1024) {
            fileSize = sizeTB + " TB";
        }

        return fileSize;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public String getFilePermissions() {
        return filePermissions;
    }
}
