package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcela BARRIONEVO on 16/05/2016.
 */
public class TableItems extends JTable {



    public TableItems(TableSortedModel model) {
        super(model);

        initComponents();
    }

    private void initComponents() {
        getTableHeader().setToolTipText("Click to specify sorting; Control-Click to specify secondary sorting");
        setShowVerticalLines(true);
        setShowHorizontalLines(false);
    }
}
