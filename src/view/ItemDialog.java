package view;

import core.Item;
import utils.ItemUtilities;
import utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Marcela Barrionuevo on 28/05/2016.
 */
public class ItemDialog extends JDialog {

    private TableItems tableItems;
    private Toolkit tool;
    private Dimension dimension;

    private JTabbedPane jTabbedPane;
    private GeneralDialog generalDialog;

    private JButton okButton;
    private JButton cancelButton;
    private JButton applyButton;

    public ItemDialog(TableItems tableItems) {

        this.tableItems = tableItems;

        tool = Toolkit.getDefaultToolkit();
        dimension = tool.getScreenSize();

        initComponents();

        addComponents();

        buttonEvents();
    }

    private void initComponents() {
        this.setIconImage(tool.getImage(ItemDialog.class.getResource("../image/icon.png")));
        this.setBounds((dimension.width / 2) - 150, (dimension.height / 2) - 200, 300, 400);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        int selectedRow = tableItems.getSelectedRow();
        String absolutePath = (String) tableItems.getModel().getValueAt(selectedRow, 6);
        Item item = ItemUtilities.getItem(absolutePath);
        String title = "Properties on: \"" + item.getFullName() + "\"";
        this.setTitle(title);

        jTabbedPane = new JTabbedPane();
        generalDialog = new GeneralDialog(item);
        jTabbedPane.addTab("General", generalDialog);
        jTabbedPane.addTab("Security", new JPanel());
        jTabbedPane.addTab("Details", new JPanel());
    }

    private void addComponents() {
        JPanel mainPanel = new JPanel(new SpringLayout());
        mainPanel.add(jTabbedPane);
        mainPanel.add(getButtonsPanel());
        SpringUtilities.makeCompactGrid(mainPanel, 2, 1, 0, 0, 5, 5);

        this.add(mainPanel);
    }

    private JPanel getButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new SpringLayout());

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        applyButton = new JButton("Apply");

        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(applyButton);

        SpringUtilities.makeCompactGrid(buttonsPanel, 1, 3, 0, 0, 10, 5);

        return buttonsPanel;
    }

    private void buttonEvents() {
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent ignore) {
                generalDialog.saveChanges();
                closeDialog();
            }
        });

        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent ignore) {
                closeDialog();
            }
        });

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent event) {
                System.out.println("Closing item dialog: " + event.paramString());
            }
        });

        applyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent ignore) {
                generalDialog.saveChanges();
            }
        });
    }

    private void closeDialog() {
        ItemDialog.this.setVisible(false);
        ItemDialog.this.dispatchEvent(new WindowEvent(ItemDialog.this, WindowEvent.WINDOW_CLOSING));
    }
}
