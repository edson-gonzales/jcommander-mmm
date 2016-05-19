import view.MainWindow;

import javax.swing.UIManager;

/**
 * Created by Marcela Barrionuevo on 16/05/2016.
 */
public class JCommander {

    public static void main (String [] args)
    {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            //JOptionPane.showMessageDialog(null,"Error al intentar cargar L&F");
        }
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}
