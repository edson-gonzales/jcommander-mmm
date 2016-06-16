package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Marcela Barrionuevo on 27/05/2016.
 */
public class TableKeyListener extends KeyAdapter {

    private TableItems tableItems;

    public TableKeyListener(TableItems tableItems) {

        this.tableItems = tableItems;
    }

    @Override
    public void keyReleased(KeyEvent ke) {

        if(ke.getKeyCode() == KeyEvent.VK_ENTER) {

            ItemDialog itemDialog = new ItemDialog(tableItems);
            itemDialog.setVisible(true);
        }
    }
}
