package corridor.view;

import javax.swing.*;
import java.awt.*;

public class CorridorConverterFrameTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CorridorConverterFrame frame = new CorridorConverterFrame();
                frame.setTitle("Corridor converter");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
