import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.util.*;
import javax.swing.event.*;
import java.awt.event.*;
public class Graphs {
    public JFrame frame, frame2, frame3;

    public Graphs(){
        Velocity graphs1 = new Velocity();
        ReactionTime graphs2 = new ReactionTime();
        Friction graphs3 = new Friction();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Velocity");
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.add(graphs1);

        frame2 = new JFrame();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Reaction Time");
        frame2.setSize(500,500);
        frame2.setResizable(false);
        frame2.add(graphs2);
        frame2.setVisible(Main.ViewGraphs);

        frame3 = new JFrame();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setTitle("Graphs");
        frame3.setSize(500,500);
        frame3.setResizable(false);
        frame3.add(graphs3);
        frame3.setVisible(Main.ViewGraphs);

        frame.setLocation(100,200);
        frame2.setLocation(400,200);
        frame3.setLocation(700,200);
    }

    public void showFrames() {
        frame.setVisible(Main.ViewGraphs);
        frame2.setVisible(Main.ViewGraphs);
        frame3.setVisible(Main.ViewGraphs);

    }
}
class Velocity extends JPanel
{
    public static final int W = 500;
    public static final int H = 500;

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int graphx = 50;
        int graphy = 425;
        double V1 = 0, Tr = 0.5, mu = 0.7;
        double D1;
        double D2;
        double Dis;

        //Stopping distance vs initial speed
        g2.drawLine(50,425,450,425);
        g2.drawLine(50,425,50,25);
        for (int i=0;i<16;i++)
        {
            graphx = graphx+25;
            g2.drawLine(graphx,420,graphx,430);
            graphy = graphy-25;
            g2.drawLine(45,graphy,55,graphy);
        }

        g2.drawString("Initial Velocity (m/s)",195,460);
        g2.drawString("Stopping Distance (m)",10,20);
        g2.drawString("Stopping Distance vs.",200,10);
        g2.drawString("Initial Velocity",215,30);
        g2.drawString("0",30,445);
        graphx = 50;
        graphy = 425;
        for (int i=0;i<400;i++)
        {
            graphx = graphx + 1;
            V1 = V1 + 0.1;
            D1 = V1*Tr;
            D2 = Math.round((V1*V1)/(2*10*mu));
            Dis = D1 + D2;
            Dis = Dis+400-(2*(Dis-25)) - 200;
            graphy = (int) Dis+50;
            g2.drawOval(graphx,graphy,1,1);
        }
    }
}
class ReactionTime extends JPanel
{
    public static final int W = 500;
    public static final int H = 500;

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        int graphx = 50;
        int graphy = 425;
        double V1 = 54/3.6, Tr = 0, mu = 0.7;
        double D1;
        double D2;
        double Dis;

        //Stopping distance vs initial speed
        g2.drawLine(50,425,450,425);
        g2.drawLine(50,425,50,25);
        for (int i=0;i<16;i++)
        {
            graphx = graphx+25;
            g2.drawLine(graphx,420,graphx,430);
            graphy = graphy-25;
            g2.drawLine(45,graphy,55,graphy);
        }

        g2.drawString("Reaction Time (s)",195,460);
        g2.drawString("Stopping Distance (m)",10,20);
        g2.drawString("Stopping Distance vs.",200,10);
        g2.drawString("Reaction Time",215,30);
        g2.drawString("0",30,445);
        graphx = 50;
        graphy = 425;
        for (int i=0;i<400;i++)
        {
            graphx = graphx + 1;
            Tr = Tr + 0.01;
            D1 = V1*Tr;
            D2 = Math.round((V1*V1)/(2*10*mu));
            Dis = D1 + D2;
            Dis = Dis+400-(2*(Dis-25)) - 200;
            graphy = (int) Dis+50;
            g2.drawOval(graphx,graphy,1,1);
        }
    }
}
class Friction extends JPanel
{
    public static final int W = 500;
    public static final int H = 500;

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        int graphx = 50;
        int graphy = 425;
        double V1 = 54/3.6, Tr = 1.53, mu = 0;
        double D1;
        double D2;
        double Dis;

        //Stopping distance vs initial speed
        g2.drawLine(50,425,450,425);
        g2.drawLine(50,425,50,25);
        for (int i=0;i<16;i++)
        {
            graphx = graphx+25;
            g2.drawLine(graphx,420,graphx,430);
            graphy = graphy-25;
            g2.drawLine(45,graphy,55,graphy);
        }

        g2.drawString("Friction",195,460);
        g2.drawString("Stopping Distance (m)",10,20);
        g2.drawString("Stopping Distance vs.",200,10);
        g2.drawString("Friction",220,30);
        g2.drawString("0",30,445);
        graphx = 50;
        graphy = 425;
        for (int i=0;i<400;i++)
        {
            graphx = graphx + 1;
            mu = mu + 0.01;
            D1 = V1*Tr;
            D2 = Math.round((V1*V1)/(2*10*mu));
            Dis = D1 + D2;
            Dis = Dis+400-(2*(Dis-25)) - 200;
            graphy = (int) Dis + 50;
            g2.drawOval(graphx,graphy,1,1);
        }
    }
}