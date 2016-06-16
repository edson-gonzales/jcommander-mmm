package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Marcela Barrionuevo on 27/05/2016.
 */
public class PopupMenu extends JPopupMenu implements ActionListener {

    private TableItems tableItems;
    private JMenuItem deleteItem;
    private JMenuItem renameItem;
    private JMenuItem propertiesItem;

    public PopupMenu(TableItems tableItems) {

        this.tableItems = tableItems;

        initComponents();

        addEvents();

        addComponents();
    }

    private void initComponents() {

        deleteItem = new JMenuItem("Delete");
        renameItem = new JMenuItem("Rename");
        propertiesItem = new JMenuItem("Properties");
    }

    private void addEvents() {

        deleteItem.addActionListener(this);
        renameItem.addActionListener(this);
        propertiesItem.addActionListener(this);
    }

    private void addComponents() {
        this.add(deleteItem);
        this.add(renameItem);
        this.add(new JPopupMenu.Separator());
        this.add(propertiesItem);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == deleteItem) {
            // TO DO
        } else if (menu == renameItem) {
            // TO DO
        } else if (menu == propertiesItem) {
            ItemDialog itemDialog = new ItemDialog(tableItems);
            itemDialog.setVisible(true);
        }
    }
}
