package utils;

import core.Folder;
import core.Item;
import view.TableSortedModel;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcela Barrionuevo on 27/05/2016.
 */
public class ItemUtilities {

    /**
     * Returns a list of files and folders that are located on an absolute path.
     *
     * @param   workingPath   an absolute path giving the base location of the files and folders.
     * @return                the list of files an folders.
     */
    public static List<Item> populateItems(String workingPath) {

        List<Item> items = new ArrayList<Item>();

        try {
            // Get all the folders/files
            File fileSystem = new File(workingPath);

            if (fileSystem == null || !fileSystem.exists()) {
                return items;
            }

            File[] fullFileList = fileSystem.listFiles();

            for (File file : fullFileList){

                Item item;
                if (file.isDirectory()) {
                    item = new Folder(file);
                } else {
                    item = new core.File(file);
                }

                items.add(item);
            }
        } catch (Exception exception) {
            System.out.println("Error getting files and folders: " + exception.getMessage());
        }

        return items;
    }

    /**
     * Returns a list of files and folders that are located on an absolute path.
     *
     * @param   workingPath   an absolute path giving the base location of the item.
     * @return                a Item.
     */
    public static Item getItem(String workingPath) {

        Item item = null;

        try {
            // Get all the folders/files
            File fileSystem = new File(workingPath);

            if (fileSystem == null || !fileSystem.exists()) {
                return item;
            }

            if (fileSystem.isDirectory()) {
                item = new Folder(fileSystem);
            } else {
                item = new core.File(fileSystem);
            }
        } catch (Exception exception) {
            System.out.println("Error getting file or folder: " + exception.getMessage());
        }

        return item;
    }

    /**
     * Returns an image icon according to file or folder type.
     *
     * @param   type   the format type.
     * @return         an ImageIcon.
     */
    public static ImageIcon getImageIcon(String type) {

        ImageIcon imageIcon = new ImageIcon(TableSortedModel.class.getResource("../image/unknownIcon.png"));
        String itemType = type.toLowerCase();

        if (itemType.equals("")) {
            imageIcon = new ImageIcon(TableSortedModel.class.getResource("../image/folderIcon.png"));
        } else if (itemType.equals("txt")) {
            imageIcon = new ImageIcon(TableSortedModel.class.getResource("../image/plainText.png"));
        } else if (itemType.equals("doc") || itemType.equals("docx")) {
            imageIcon = new ImageIcon(TableSortedModel.class.getResource("../image/wordIcon.png"));
        } else if (itemType.equals("ppt") || itemType.equals("pptx")) {
            imageIcon = new ImageIcon(TableSortedModel.class.getResource("../image/powerPointIcon.png"));
        } else if (itemType.equals("7z") || itemType.equals("zip") || itemType.equals("rar")) {
            imageIcon = new ImageIcon(TableSortedModel.class.getResource("../image/compressIcon.png"));
        } else if (itemType.equals("png") || itemType.equals("jpg") || itemType.equals("gif")) {
            imageIcon = new ImageIcon(TableSortedModel.class.getResource("../image/pictureIcon.png"));
        } else if (itemType.equals("java") || itemType.equals("class")) {
            imageIcon = new ImageIcon(TableSortedModel.class.getResource("../image/javaIcon.png"));
        }

        return imageIcon;
    }
}
