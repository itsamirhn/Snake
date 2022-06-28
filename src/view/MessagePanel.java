package view;
import javax.swing.*;
import java.awt.*;


public class MessagePanel extends JPanel {
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawString("karo",10,10);
    }
}
