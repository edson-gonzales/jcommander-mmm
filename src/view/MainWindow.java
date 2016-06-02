package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcela BARRIONEVO on 16/05/2016.
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
    private CreateFileButton createFileButton;

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
        createFileButton = new CreateFileButton();

        setTitle("JCommander - Jala");
        setSize(dimension.width, dimension.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setIconImage(tool.getImage(MainWindow.class.getResource("../image/icon.png")));
        setLayout(new BorderLayout());
        setJMenuBar(menuBar);

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
        Dimension minimumSize = new Dimension(dimension.width/4, dimension.height/4);
        leftPanel.setMinimumSize(minimumSize);
        rightPanel.setMinimumSize(minimumSize);
    }

    private void addComponents() {
        add(toolBar, BorderLayout.PAGE_START);
        add(statusBar, BorderLayout.SOUTH);
        add(createFileButton, BorderLayout.SOUTH);
        add(splitPane, BorderLayout.CENTER);
    }
}
