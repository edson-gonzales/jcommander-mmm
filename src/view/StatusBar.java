package view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Created by Marcela Barrionuevo on 17/05/2016.
 */
public class StatusBar extends JPanel {

    private Toolkit tool;
    private Dimension dimension;
    private JLabel message;

    public StatusBar() {
        tool = Toolkit.getDefaultToolkit();
        dimension = tool.getScreenSize();

        initComponents();
    }

    private void initComponents() {
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setPreferredSize(new Dimension(dimension.width, 32));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        message = new JLabel("   Hello World");
        message.setHorizontalAlignment(SwingConstants.LEFT);
        add(message);
    }
}
