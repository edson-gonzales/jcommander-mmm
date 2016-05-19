package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcela Barrionuevo on 16/05/2016.
 */
public class MainWindow extends JFrame {

    private Toolkit tool;
    private Dimension dimension;
    private MenuBar menuBar;
    private ToolBar toolBar;
    private StatusBar statusBar;
    private PanelContainer leftPanel;
    private PanelContainer rightPanel;

    public MainWindow(){

        tool = Toolkit.getDefaultToolkit();
        dimension = tool.getScreenSize();
        menuBar = new MenuBar();
        toolBar = new ToolBar();
        statusBar = new StatusBar();
        leftPanel = new PanelContainer("");
        rightPanel = new PanelContainer("");

        initComponents();
    }

    private void initComponents() {
        setTitle("JCommander - Jala");
        setSize(dimension.width, dimension.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setIconImage(tool.getImage(MainWindow.class.getResource("../image/icon.png")));
        setLayout(new BorderLayout());

        // Add components in the main window
        setJMenuBar(menuBar);
        add(toolBar, BorderLayout.PAGE_START);
        add(statusBar, BorderLayout.SOUTH);

        // Create both panels
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(0.5);
        splitPane.setContinuousLayout(true);

        // Provide minimum sizes for the two components in the split pane
        Dimension minimumSize = new Dimension(dimension.width/4, dimension.height/4);
        leftPanel.setMinimumSize(minimumSize);
        rightPanel.setMinimumSize(minimumSize);
        add(splitPane, BorderLayout.CENTER);
    }
}
