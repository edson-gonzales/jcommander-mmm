package view;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;

/**
 * Created by Marcela Barrionuevo on 16/05/2016.
 */
public class PanelContainer extends JPanel {

    JTabbedPane jTabbedPane;
    private String workingPath;

    public PanelContainer(String workingPath) {

        if (workingPath == null || workingPath.isEmpty()) {
            workingPath = System.getProperty("user.dir");
        }

        jTabbedPane = new JTabbedPane();

        JPanel jPaneA = new JPanel();
        jPaneA.setLayout(new BorderLayout());
        TableSortedModel model = new TableSortedModel(workingPath);
        TableRowSorter<TableSortedModel> sorterModel = new TableRowSorter<TableSortedModel>(model);

        TableItems tableItems = new TableItems(model);
        tableItems.setRowSorter(sorterModel);
        tableItems.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(tableItems);
        jPaneA.add(scrollPane, BorderLayout.CENTER);

        jTabbedPane.addTab("File System", jPaneA);

        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(1, 1));
        add(jTabbedPane);
    }
}
