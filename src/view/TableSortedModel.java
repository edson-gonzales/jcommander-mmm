package view;

import core.Item;
import utils.ItemUtilities;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.List;

/**
 * Created by Marcela Barrionuevo on 18/05/2016.
 */
public class TableSortedModel extends AbstractTableModel {

    private List<Item> items;
    private final String[] columnNames = {"", "<html><strong>Name</strong></html>",
            "<html><strong>Ext</strong></html>", "<html><strong>Size</strong></html>",
            "<html><strong>Date</strong></html>", "<html><strong>Attr</strong></html>"};
    private final Class[] columnTypes = new Class[]{ImageIcon.class, String.class,
            String.class, String.class,
            Date.class, String.class};
    private Object[][] data;

    public TableSortedModel(String workingPath) {
        items = ItemUtilities.populateItems(workingPath);
        // We add an extra row to have the link to up level
        data = new Object[items.size() + 1][columnNames.length];

        populateDataTable();
    }

    private void populateDataTable() {

        // Add th first extra row
        data[0] = new Object[] {new ImageIcon(TableSortedModel.class.getResource("../image/upLevel.png")),
                "[..]", "", "", new Date(), ""};

        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            data[index + 1] = new Object[] {
                    ItemUtilities.getImageIcon(item.getType()),
                    item.getName(),
                    item.getType(),
                    item.getSize(),
                    item.getLastModified(),
                    item.getFilePermissions()};

        }
    }

    @Override
    public int getColumnCount() {

        return columnNames.length;
    }

    @Override
    public int getRowCount() {

        return data.length;
    }

    @Override
    public String getColumnName(int columnIndex) {

        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int row, int col) {

        return data[row][col];
    }

    @Override
    public Class getColumnClass(int columnIndex) {

        return columnTypes[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col > 0 && col < 3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
