package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcela Barriouevo on 16/05/2016.
 */
public class MainWindow extends JFrame {

    private Toolkit tool;
    private Dimension dimension;
    private MenuBar menuBar;
    private ToolBar toolBar;
    private StatusBar statusBar;
    private JSplitPane splitPane;
    private PanelContainer leftPanel;
    private PanelContainer rightPanel;

    public MainWindow(){

        tool = Toolkit.getDefaultToolkit();
        dimension = tool.getScreenSize();

        initComponents();

        customizeComponents();

        addComponents();
    }

    private void initComponents() {
        menuBar = new MenuBar();
        toolBar = new ToolBar();
        statusBar = new StatusBar();

        this.setTitle("JCommander - Jala");
        this.setSize(dimension.width, dimension.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultLookAndFeelDecorated(true);
        this.setIconImage(tool.getImage(MainWindow.class.getResource("../image/icon.png")));
        this.setLayout(new BorderLayout());
        this.setJMenuBar(menuBar);

        // Create both panels
        leftPanel = new PanelContainer("");
        rightPanel = new PanelContainer("");
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
    }

    private void customizeComponents() {
        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(0.5);
        splitPane.setContinuousLayout(true);

        // Provide minimum sizes for the two components in the split pane
        Dimension minimumSize = new Dimension(dimension.width / 4, dimension.height / 4);
        leftPanel.setMinimumSize(minimumSize);
        rightPanel.setMinimumSize(minimumSize);
    }

    private void addComponents() {
        add(toolBar, BorderLayout.PAGE_START);
        add(statusBar, BorderLayout.SOUTH);
        add(splitPane, BorderLayout.CENTER);
    }
}
