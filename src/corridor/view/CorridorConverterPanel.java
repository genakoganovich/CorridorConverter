package corridor.view;

import javax.swing.*;
import java.awt.Container;

public class CorridorConverterPanel extends JPanel{

    public CorridorConverterPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JTextArea inputTextArea = new JTextArea(20, 40);
        JTextArea outputTextArea = new JTextArea(20, 40);
        add(inputTextArea);
        add(outputTextArea);
    }
}
