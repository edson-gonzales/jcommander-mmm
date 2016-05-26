package view;

import core.Folder;
import core.Item;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TANIA BARRIONEVO on 18/05/2016.
 */
public class TableSortedModel extends AbstractTableModel {

    private List<Item> items;
    private final String[] columnNames = {"<html><strong>Name</strong></html>",
            "<html><strong>Ext</strong></html>", "<html><strong>Size</strong></html>",
            "<html><strong>Date</strong></html>", "<html><strong>Attr</strong></html>"};
    private final Class[] columnTypes = new Class[]{String.class, String.class, String.class, Date.class, String.class};
    private Object[][] data;

    public TableSortedModel(String workingPath) {
        items = populateItems(workingPath);

        populateDataTable();
    }

    private void populateDataTable() {
        data = new Object[items.size()][columnNames.length];

        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            data[index] = new Object[] { item.getName(),
                    item.getType(),
                    item.getSize(),
                    item.getLastModified(),
                    item.getFilePermissions()};

        }
    }

    /**
     * Returns a list of files and folders that are located on an absolute path.
     *
     * @param   workingPath   an absolute path giving the base location of the files and folders.
     * @return                the list of files an folders.
     */
    private List<Item> populateItems(String workingPath) {
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

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
