package view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Marcela Barrionuevo on 27/05/2016.
 */
public class TableMouseListener extends MouseAdapter {

    private TableItems tableItems;

    public TableMouseListener(TableItems tableItems) {

        this.tableItems = tableItems;
    }

    @Override
    public void mousePressed(MouseEvent event) {

        // Select the row at which point the mouse is clicked
        Point point = event.getPoint();
        int currentRow = tableItems.rowAtPoint(point);
        tableItems.setRowSelectionInterval(currentRow, currentRow);
    }
}
