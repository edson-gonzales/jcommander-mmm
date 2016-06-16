package view;

import core.FileSizeType;
import core.Item;
import utils.ItemUtilities;
import utils.SpringUtilities;

import javax.swing.*;

/**
 * Created by Marcela Barrionuevo on 03/06/2016.
 */
public class GeneralDialog extends JPanel {

    private Item item;
    private JTextField itemName;
    private JCheckBox isReadOnly;
    private JCheckBox isHidden;

    public GeneralDialog(Item item) {
        this.item = item;

        initComponents();
    }

    private void initComponents() {
        this.setLayout(new SpringLayout());
        isReadOnly = new JCheckBox("Read Only", item.getReadOnly());
        isHidden = new JCheckBox("Hidden", item.getHidden());

        setFormPanel();
    }

    private void setFormPanel() {
        int rowElements = 0;

        this.add(new JLabel(ItemUtilities.getImageIcon(item.getType())));
        itemName = new JTextField(item.getName());
        this.add(itemName);
        ++rowElements;

        this.add(new JLabel("File name: ", JLabel.TRAILING));
        this.add(new JLabel(item.getFullName()));
        ++rowElements;

        if (item.getClass().getName().equals("core.Folder")) // Folder
        {
            int files = 0;
            int folders = 0;
            java.util.List<Item> items = ItemUtilities.populateItems(item.getLocation());
            for (Item tempItem: items) {
                if (tempItem.getClass().getName().equals("core.Folder")) {
                    ++folders;
                }
                else {
                    ++files;
                }
            }

            this.add(new JLabel("Files/Folders: ", JLabel.TRAILING));
            this.add(new JLabel(files + " File(s), " + folders + " Folder(s)"));
            ++rowElements;
        }

        this.add(new JLabel("File size: ", JLabel.TRAILING));
        this.add(new JLabel(item.getSize() + " (" + item.getSize(FileSizeType.BYTES) + ")"));
        ++rowElements;

        this.add(new JLabel("Full Path: ", JLabel.TRAILING));
        JTextField fullPathLabel = new JTextField(item.getLocation()); // a look-alike JLabel to select the text
        fullPathLabel.setEditable(false);
        fullPathLabel.setBorder(null);
        fullPathLabel.setBackground(null);
        fullPathLabel.setForeground(UIManager.getColor("Label.foreground"));
        fullPathLabel.setFont(UIManager.getFont("Label.font"));
        fullPathLabel.setToolTipText(item.getLocation());
        this.add(fullPathLabel);
        ++rowElements;

        this.add(new JLabel("Last Modified: ", JLabel.TRAILING));
        this.add(new JLabel(item.getLastModified().toString()));
        ++rowElements;

        // Attributes
        this.add(new JLabel("Attributes: ", JLabel.TRAILING));
        this.add(new JLabel(""));
        ++rowElements;

        this.add(new JLabel(""));
        this.add(isReadOnly);
        ++rowElements;

        this.add(new JLabel(""));
        this.add(isHidden);
        ++rowElements;

        SpringUtilities.makeCompactGrid(this, rowElements, 2, 0, 0, 5, 5);
    }

    public void saveChanges() {
        item.setHidden(isHidden.isSelected());
        item.setReadOnly(isReadOnly.isSelected());
    }
}
