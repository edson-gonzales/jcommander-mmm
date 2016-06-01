package core;

import commands.Command;

import java.io.File;
import java.util.Date;

/**
 * Created by Marcelo Loayza on 17/05/2016.
 */
public class Item {

    private File fileSystemItem;
    private String name;
    private String location;
    private String type;
    private String fileSize;
    private Date lastModified;
    private String filePermissions;

    /**
     * It is the constructor to create an item of file or folder type.
     * @param fileSystemItem an java.io.File object to get all required info to be displayed in the UI
     */
    public Item (File fileSystemItem) {

        this.fileSystemItem = fileSystemItem;
    }

    public boolean executeCommand(Command command) {
        return true;
    }

    public String getName() {

        if (name == null || name.trim().equals("")) {

            name = fileSystemItem.getName();

            if (fileSystemItem.isFile()) {

                int i = fileSystemItem.getName().lastIndexOf('.');
                name = (i > 0) ? fileSystemItem.getName().substring(0, i) : "";
            }
        }

        return name;
    }

    public String getLocation() {

        if (location == null || location.trim().equals("")) {
            location = fileSystemItem.getPath();
        }

        return location;
    }

    public String getType() {

        if (type == null || type.trim().equals("")) {

            type = "";

            if (fileSystemItem.isFile()) {

                int i = fileSystemItem.getName().lastIndexOf('.');
                type = (i > 0) ? fileSystemItem.getName().substring(i + 1) : "";
            }
        }

        return type;
    }

    public String getSize() {

        if (fileSize == null) {
            FormatterSize formatter = new FormatterSize(fileSystemItem.length());
            fileSize = formatter.getFileSize();
        }

        return fileSize;
    }

    public Date getLastModified() {

        if (lastModified == null) {
            lastModified = new Date(fileSystemItem.lastModified());
        }

        return lastModified;
    }

    public String getFilePermissions() {

        if (filePermissions == null) {
            Permission permission = new Permission(fileSystemItem);
            filePermissions = permission.readPermissions();
        }

        return filePermissions;
    }
}
