package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Marcela BARRIONEVO on 16/05/2016.
 */
public class MenuBar extends JMenuBar implements ActionListener {

    private JMenu files;
    private JMenu mark;
    private JMenu commands;
    private JMenu show;
    private JMenu configuration;
    private JMenu help;

    private JMenuItem filesChangeAttrib;
    private JMenuItem filesCompareContent;
    private JMenuItem filesProperties;
    private JMenuItem filesQuit;

    public MenuBar() {
        initComponents();

        customizeComponents();

        addComponents();
    }

    private void initComponents() {

        files = new JMenu("Files");
        mark = new JMenu("Mark");
        commands = new JMenu("Commands");
        show = new JMenu("Show");
        configuration = new JMenu("Configuration");
        help = new JMenu("Help");

        filesChangeAttrib = new JMenuItem("Change Attributes", new ImageIcon(MenuBar.class.getResource("../image/iconAttributes.gif")));
        filesCompareContent = new JMenuItem("Compare By Content", new ImageIcon(MenuBar.class.getResource("../image/iconCompare.png")));
        filesProperties = new JMenuItem("Properties", new ImageIcon(MenuBar.class.getResource("../image/iconProperties.gif")));
        filesQuit = new JMenuItem("Quit", new ImageIcon(MenuBar.class.getResource("../image/iconQuit.png")));
    }

    private void customizeComponents() {
        files.setMnemonic(KeyEvent.VK_F);
        mark.setMnemonic(KeyEvent.VK_M);
        commands.setMnemonic(KeyEvent.VK_C);
        show.setMnemonic(KeyEvent.VK_W);
        configuration.setMnemonic(KeyEvent.VK_O);
        help.setMnemonic(KeyEvent.VK_H);

        filesChangeAttrib.addActionListener(this);
        filesChangeAttrib.setMnemonic(KeyEvent.VK_A);
        filesChangeAttrib.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        filesChangeAttrib.getAccessibleContext().setAccessibleDescription("Change attributes in selected folders/files");

        filesCompareContent.addActionListener(this);
        filesCompareContent.setMnemonic(KeyEvent.VK_T);

        filesProperties.addActionListener(this);
        filesProperties.setMnemonic(KeyEvent.VK_P);

        filesQuit.addActionListener(this);
        filesQuit.setMnemonic(KeyEvent.VK_Q);
    }

    private void addComponents() {
        files.add(filesChangeAttrib);
        files.add(filesCompareContent);
        files.add(filesProperties);
        files.addSeparator();
        files.add(filesQuit);

        add(files);
        add(mark);
        add(commands);
        add(show);
        add(configuration);
        add(help);
    }

    @Override
    public void actionPerformed(ActionEvent actionE) {

        if (actionE.getSource() == filesChangeAttrib) {
            // TO DO
        } else if (actionE.getSource() == filesCompareContent) {
            // TO DO
        } else if (actionE.getSource() == filesProperties) {
            // TO DO
        } else if (actionE.getSource() == filesQuit) {
            System.exit(0);
        }
    }
}
