package view;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Marcela Barrionuevo on 16/05/2016.
 */
public class TableItems extends JTable {

    private JPopupMenu popupMenu;

    public TableItems(TableSortedModel model) {
        super(model);

        initComponents();
    }

    private void initComponents() {
        getTableHeader().setToolTipText("Click to specify sorting; Control-Click to specify secondary sorting");
        setShowVerticalLines(true);
        setShowHorizontalLines(false);

        popupMenu = new PopupMenu(this);
        this.setComponentPopupMenu(popupMenu);

        this.addMouseListener(new TableMouseListener(this));
        this.addKeyListener(new TableKeyListener(this));
    }
}
