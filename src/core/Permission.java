package core;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Marcela Barrionuevo on 30/05/2016.
 */
public class Permission {

    private PosixFileAttributeView posixView;
    private File fileSystemItem;

    public Permission(File fileSystemItem) {

        this.fileSystemItem = fileSystemItem;
        Path path = Paths.get(fileSystemItem.getAbsolutePath());
        posixView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
    }

    public String readPermissions() {

        String rwxFormPermissions = "";

        if (posixView == null) { // For Windows
            System.out.println("POSIX attribute view is not  supported.");
            rwxFormPermissions = configurePermissions();
        } else { // For Unix and Linux
            try {
                PosixFileAttributes attribs = posixView.readAttributes();
                Set<PosixFilePermission> permissions = attribs.permissions();
                // Convert the set of posix file permissions into rwxrwxrwx form
                rwxFormPermissions = PosixFilePermissions.toString(permissions);
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }

        return rwxFormPermissions;
    }

    private String configurePermissions() {
        String permissions = "";
        if (fileSystemItem.canRead()) {
            permissions += "r";
        } else {
            permissions += "-";
        }
        if (fileSystemItem.canWrite()) {
            permissions += "w";
        } else {
            permissions += "-";
        }
        if (fileSystemItem.canExecute()) {
            permissions += "x";
        } else {
            permissions += "-";
        }

        return permissions;
    }

    public boolean updatePermissions(PosixFileAttributeView posixView) {

        boolean state = false;
        Set<PosixFilePermission> permissions = EnumSet.of(PosixFilePermission.OWNER_READ,
                PosixFilePermission.OWNER_WRITE,
                PosixFilePermission.GROUP_READ);
        try {
            posixView.setPermissions(permissions);
            state = true;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return state;
    }
}
