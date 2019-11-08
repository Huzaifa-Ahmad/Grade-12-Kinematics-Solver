import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.util.*;
import javax.swing.event.*;

public class Main extends JFrame {
    private JLabel answer;
    private JTextField TFieldVelocity, TFieldRxnTime, TFieldMu;
    private JButton solve, wTXT, rTXT;
    private Graphs graphs;

    String sVelocity, sTime, sMu, sDis1, sDisT; 
    double dVelocity, dTime, dMu, Dis1, Dis2, dDisT;
    public static boolean ViewGraphs;

    public Main(Graphs graphs){
        super("Kinematics Calculator");
        setLayout(new GridLayout(6,1));
        
        this.graphs = graphs;

        //Creating panels
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1,2));
        add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1,2));
        add(panel4);

        JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayout(1,2));
        add(panel6);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayout(1,1));
        add(panel5);

        //panel 1
        JLabel Vlabel = new JLabel("Enter the initial velocity in km/h");
        panel1.add(Vlabel);

        Vlabel.setFont(new Font("Century Gothic", Font.BOLD,20));
        Vlabel.setHorizontalAlignment(JTextField.CENTER);

        TFieldVelocity = new JTextField("", 20);
        panel1.add(TFieldVelocity);

        TFieldVelocity.setFont(new Font("Century Gothic", Font.BOLD,20));
        TFieldVelocity.setHorizontalAlignment(JTextField.CENTER);

        //panel 2
        JLabel Tlabel = new JLabel("Enter the reaction time");
        panel2.add(Tlabel);

        Tlabel.setFont(new Font("Century Gothic", Font.BOLD,23));
        Tlabel.setHorizontalAlignment(JTextField.CENTER);

        TFieldRxnTime = new JTextField("", 20);
        panel2.add(TFieldRxnTime);

        TFieldRxnTime.setFont(new Font("Century Gothic", Font.BOLD,20));
        TFieldRxnTime.setHorizontalAlignment(JTextField.CENTER);

        //panel 3
        JLabel Mulabel = new JLabel("Enter the coefficient of friction");
        panel3.add(Mulabel);

        Mulabel.setFont(new Font("Century Gothic", Font.BOLD,23));
        Mulabel.setHorizontalAlignment(JTextField.CENTER);

        TFieldMu = new JTextField("", 20);
        panel3.add(TFieldMu);

        TFieldMu.setFont(new Font("Century Gothic", Font.BOLD,20));
        TFieldMu.setHorizontalAlignment(JTextField.CENTER);

        //panel 4
        solve = new JButton("Confirm Values");
        panel4.add(solve);

        solve.setFont(new Font("Century Gothic", Font.BOLD,23));
        solve.setHorizontalAlignment(JTextField.CENTER);

        answer = new JLabel();
        panel4.add(answer);

        answer.setFont(new Font("Century Gothic", Font.BOLD,23));
        answer.setHorizontalAlignment(JTextField.CENTER);

        //panel6
        wTXT = new JButton("Save to a .txt file");
        panel6.add(wTXT);

        wTXT.setFont(new Font("Century Gothic", Font.BOLD,23));
        wTXT.setHorizontalAlignment(JTextField.CENTER);

        rTXT = new JButton("Read from a .txt file");
        panel6.add(rTXT);

        rTXT.setFont(new Font("Century Gothic", Font.BOLD,23));
        rTXT.setHorizontalAlignment(JTextField.CENTER);

        //panel 5
        JButton GraphsButton = new JButton("View Graphs");
        panel5.add(GraphsButton);

        GraphsButton.setFont(new Font("Century Gothic", Font.BOLD,23));
        GraphsButton.setHorizontalAlignment(JTextField.CENTER);

        ActionListener acts1 = new action();
        solve.addActionListener(acts1);

        action2 acts2 = new action2();
        GraphsButton.addActionListener(acts2);

        // action acts3 = new action();
        // wTXT.addActionListener(acts3);

        //Graphs grf = new Graphs(boolean ViewGraphs);
    }

    public class action implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (!TFieldVelocity.getText().isEmpty() && TFieldRxnTime.getText().isEmpty() || TFieldMu.getText().isEmpty()) {
                answer.setText("ERROR! MISSING VALUES");
                answer.setForeground(Color.RED);
            }

            else{
                sVelocity = TFieldVelocity.getText();
                dVelocity = Double.parseDouble(sVelocity);
                dVelocity = ((dVelocity / 3600) * 1000);

                sTime = TFieldRxnTime.getText();
                dTime = Double.parseDouble(sTime);

                sMu = TFieldMu.getText();
                dMu = Double.parseDouble(sMu);

                Dis1 = dVelocity * dTime;
                Dis2 = (dVelocity * dVelocity)/(2 * dMu * 10);
                dDisT = (Dis1 + Dis2)*100;
                dDisT = (Math.round(dDisT))/100;

                sDisT = String.valueOf(dDisT);
                answer.setText("Your car will come to stop in " + sDisT + " m.");
                answer.setForeground(Color.RED);
            }
        }
    }
    
    public class action2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ViewGraphs = true;    
            graphs.showFrames();
        }
    }
}
