package core;

import commands.Command;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Marcelo Loayza on 17/05/2016.
 */
public class Item {

    private File fileSystemItem;
    private String name;
    private String fullName;
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
            location = fileSystemItem.getAbsolutePath();
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

    public String getSize(FileSizeType sizeType) {
        FormatterSize formatter = new FormatterSize(fileSystemItem.length());
        String fileSize = formatter.getFileSize(sizeType);

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

    public String getFullName() {

        if (fullName == null) {
            fullName = fileSystemItem.getName();
        }

        return fullName;
    }

    public boolean getReadOnly() {
        return !fileSystemItem.canWrite();
    }

    public void setReadOnly(boolean value) {

        if (getReadOnly() != value) {
            String newValue = (value)? "+r": "-r";
            String cmd1[] = {"attrib", newValue, getLocation()};

            try {
                Runtime.getRuntime().exec(cmd1);
            } catch (IOException exception) {

                if (value) {
                    fileSystemItem.setReadOnly();
                } else {
                    fileSystemItem.setWritable(true);
                }

                System.out.println("Error setting new hidden file attribute: " + exception.getMessage());
            }
        }
    }

    public boolean getHidden() {
        return fileSystemItem.isHidden();
    }

    /**
     * Setting the hidden attribute just for Windows Operating System
     * @param value    the new value of hidden file attribute
     */
    public void setHidden(boolean value) {

        if (getHidden() != value)
        {
            String newValue = (value)? "+h": "-h";
            String cmd1[] = {"attrib", newValue, getLocation()};

            try {
                Runtime.getRuntime().exec(cmd1);
            } catch (IOException exception) {
                System.out.println("Error setting new hidden file attribute: " + exception.getMessage());
            }
        }
    }
}
