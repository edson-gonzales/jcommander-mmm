package view;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;

/**
 * Created by Marcela BARRIONEVO on 16/05/2016.
 */
public class PanelContainer extends JPanel {

    private JTabbedPane jTabbedPane;
    private JPanel panelItems;
    private JScrollPane scrollPane;
    private String workingPath;
    private String viewType;

    /**
     * Constructor to create left or right panel to contain file system items.
     *
     * @param workingPath an absolute path to look files and folders
     */
    public PanelContainer(String workingPath) {

        this.workingPath = workingPath;
        this.viewType = "TABLE"; // TREE

        defineView();

        initComponents();

        addComponents();
    }

    private void defineView() {
        if (workingPath == null || workingPath.isEmpty()) {
            workingPath = System.getProperty("user.dir");
        }

        if (viewType.toUpperCase().equals("TABLE")) {
            TableSortedModel model = new TableSortedModel(workingPath);
            TableRowSorter<TableSortedModel> sorterModel = new TableRowSorter<TableSortedModel>(model);

            TableItems tableItems = new TableItems(model);
            tableItems.setRowSorter(sorterModel);
            tableItems.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            scrollPane = new JScrollPane(tableItems);
        } else if (viewType.toUpperCase().equals("TREE")) {
            TreeItems treeItems = new TreeItems();
            // TO DO
        }
    }

    private void initComponents() {
        setLayout(new GridLayout(1, 1));

        jTabbedPane = new JTabbedPane();
        panelItems = new JPanel();
        panelItems.setLayout(new BorderLayout());
    }

    private void addComponents() {
        panelItems.add(scrollPane, BorderLayout.CENTER);

        jTabbedPane.addTab("File System", panelItems);

        add(jTabbedPane);
    }
}
