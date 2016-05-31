package core;

import utils.ItemUtilities;

import java.util.List;
import java.io.File;

/**
 * Created by Marcelo Loayza on 17/05/2016.
 */
public class Folder extends Item {

    private List<Item> innerItems;

    public Folder(File fileSystemItem) {

        super(fileSystemItem);

        innerItems = ItemUtilities.populateItems(fileSystemItem.getAbsolutePath());
    }
}
