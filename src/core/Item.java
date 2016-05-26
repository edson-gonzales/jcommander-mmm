package core;

import commands.Command;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcelo Loayza on 17/05/2016.
 */
public class Item {

    private String name;
    private String location;
    private String type;
    private String fileSize;
    private Date lastModified;
    private String filePermissions;
    private Map<String, String> map;

    public Item (File fileSystemItem) {
        map = new HashMap<String, String>();
        lastModified = new Date(fileSystemItem.lastModified());
        location = fileSystemItem.getPath();

        configureNameAndType(fileSystemItem);

        configureSize(fileSystemItem);

        configurePermissions(fileSystemItem);
    }

    private void configurePermissions(File fileSystemItem) {
        filePermissions = "";
        if (fileSystemItem.canRead()) {
            filePermissions += "r";
        } else {
            filePermissions += "-";
        }
        if (fileSystemItem.canWrite()) {
            filePermissions += "w";
        } else {
            filePermissions += "-";
        }
        if (fileSystemItem.canExecute()) {
            filePermissions += "x";
        } else {
            filePermissions += "-";
        }
    }

    private void configureSize(File fileSystemItem) {
        double sizeBytes = fileSystemItem.length();
        double sizeKB = (sizeBytes / 1024);
        double sizeMB = (sizeKB / 1024);
        double sizeGB = (sizeMB / 1024);
        double sizeTB = (sizeGB / 1024);

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
    }

    private void configureNameAndType(File fileSystemItem) {
        if (fileSystemItem.isFile()) {
            int i = fileSystemItem.getName().lastIndexOf('.');
            if (i > 0) {
                name = fileSystemItem.getName().substring(0, i);
                type = fileSystemItem.getName().substring(i + 1);
            }
        } else {
            name = fileSystemItem.getName();
            type = "";
        }
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

    public String getSize() { return fileSize; }

    public Date getLastModified() {
        return lastModified;
    }

    public String getFilePermissions() {
        return filePermissions;
    }
}
