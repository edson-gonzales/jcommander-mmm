package view;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Marcela Barrionuevo on 17/05/2016.
 */
public class ToolBar extends JToolBar {

    public ToolBar() {

        initComponents();
    }

    private void initComponents() {
        ImageIcon iconNew = new ImageIcon(MenuBar.class.getResource("../image/iconAttributes.gif"));
        Action actionNew = new AbstractAction("Change Attributes", iconNew) {
            public void actionPerformed(ActionEvent e) {
                // TO DO
            }
        };

        ImageIcon iconOpen = new ImageIcon(MenuBar.class.getResource("../image/iconCompare.png"));
        Action actionOpen = new AbstractAction("Compare By Content", iconOpen) {
            public void actionPerformed(ActionEvent e) {
                // TO DO
            }
        };

        ImageIcon iconSave = new ImageIcon(MenuBar.class.getResource("../image/iconProperties.gif"));
        Action actionSave = new AbstractAction("Properties", iconSave) {
            public void actionPerformed(ActionEvent e) {
                // TO DO
            }
        };

        JButton btn1 = add(actionNew);
        btn1.setToolTipText("Change Attributes");
        JButton btn2 = add(actionOpen);
        btn2.setToolTipText("Compare By Content");
        JButton btn3 = add(actionSave);
        btn3.setToolTipText("Properties");
    }
}
