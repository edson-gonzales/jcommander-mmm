package view;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Marcela BARRIONEVO on 17/05/2016.
 */
public class ToolBar extends JToolBar {

    private ImageIcon iconNew;
    private Action actionNew;
    private ImageIcon iconOpen;
    private Action actionOpen;
    private ImageIcon iconSave;
    private Action actionSave;

    public ToolBar() {

        initComponents();

        addComponents();
    }

    private void initComponents() {
        iconNew = new ImageIcon(ToolBar.class.getResource("../image/iconAttributes.gif"));
        actionNew = new AbstractAction("Change Attributes", iconNew) {
            public void actionPerformed(ActionEvent actionEvent) {
                // TO DO
            }
        };

        iconOpen = new ImageIcon(ToolBar.class.getResource("../image/iconCompare.png"));
        actionOpen = new AbstractAction("Compare By Content", iconOpen) {
            public void actionPerformed(ActionEvent actionEvent) {
                // TO DO
            }
        };

        iconSave = new ImageIcon(ToolBar.class.getResource("../image/iconProperties.gif"));
        actionSave = new AbstractAction("Properties", iconSave) {
            public void actionPerformed(ActionEvent actionEvent) {
                // TO DO
            }
        };
    }

    private void addComponents() {
        JButton buttonNew = add(actionNew);
        buttonNew.setToolTipText("Change Attributes");
        JButton buttonOpen = add(actionOpen);
        buttonOpen.setToolTipText("Compare By Content");
        JButton buttonSave = add(actionSave);
        buttonSave.setToolTipText("Properties");
    }
}
