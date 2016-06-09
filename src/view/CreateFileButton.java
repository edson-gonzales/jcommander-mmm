package view;

import core.CreateFile;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Marcelo Loayza on 01/06/2016.
 */
public class CreateFileButton extends JPanel {
    private JButton NewButton;
    private String workingPath;
    private Dimension dimension;
    private Toolkit tool;

    public CreateFileButton()
    {
        NewButton = new JButton();
        workingPath = System.getProperty("user.dir");
        tool = Toolkit.getDefaultToolkit();
        dimension = tool.getScreenSize();

        initComponents();
    }
    private void initComponents() {
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setPreferredSize(new Dimension(dimension.width, 32));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        NewButton.setText("Create File");
        NewButton.setVisible(true);
        JFrame CreateFileFrame = new JFrame("Create new file");

        NewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(CreateFileFrame,
                        "new file name", null);
                if(fileName != null )
                {
                    CreateFile newFileToCreate = new CreateFile(workingPath, fileName);
                    newFileToCreate.createNewFile();
                }
            }
        });

        add(NewButton);
    }

}
