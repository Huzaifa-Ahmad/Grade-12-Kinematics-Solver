import javax.swing.*;
import java.awt.*;

public class kinematics extends JFrame {
    public static void main(String[] args) {
        Graphs grf = new Graphs();
        Main execute = new Main(grf);   
        execute.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        execute.setSize(850,600);
        execute.setVisible(true);
        execute.setResizable(false);
    }
}