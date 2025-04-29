import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;

public class Ragruop extends JFrame {
    JPanel  tpan,mpan,mpan1,mpanel,bpan;
    JTextField txt,txt1;
    JTextArea txta;
    JButton b,b2;
    JLabel lab,lab1,lab2;

    public Ragruop(Font f,Font f2,Font f3){
        List<Image> icons = new ArrayList<>();
        icons.add(Toolkit.getDefaultToolkit().getImage("image\\calculator-icon-free-vector16.png"));
        icons.add(Toolkit.getDefaultToolkit().getImage("image\\calculator-icon-free-vector32.png"));
        icons.add(Toolkit.getDefaultToolkit().getImage("image\\calculator-icon-free-vector64.png"));
        setIconImages(icons);
        setTitle("PR-mate-calcolo-combinatorio-(Calcolatrice-calcolo-combinatorio)");
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        tpan = new JPanel();
        tpan.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lab = new JLabel("strumento ragruppamento:");
        lab.setFont(f);
        lab.setForeground(Color.GREEN);
        tpan.setBackground(Color.BLACK);
        tpan.add(lab);
        add(tpan,BorderLayout.NORTH);

        mpan = new JPanel();
        mpan.setLayout(new GridLayout(2, 1, 5, 5));
        mpan.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        mpan.setBackground(Color.BLACK);
        mpanel=new JPanel();
        mpanel.setLayout(new GridLayout(2, 2, 5, 5));
        mpanel.setBackground(Color.BLACK);
        lab1 = new JLabel("n1:");
        lab1.setFont(f2);
        lab1.setForeground(Color.GREEN);
        txt = new JTextField(20);
        txt.setFont(f2);
        txt.setForeground(Color.GREEN);
        txt.setBackground(Color.DARK_GRAY);
        bpan= new JPanel();
        lab2 = new JLabel("n2:");
        lab2.setFont(f2);
        lab2.setForeground(Color.GREEN);
        txt1 = new JTextField(20);
        txt1.setFont(f2);
        txt1.setForeground(Color.GREEN);
        txt1.setBackground(Color.DARK_GRAY);
        mpan1=new JPanel();
        mpan1.setLayout(new FlowLayout());
        txta = new JTextArea("Last operation:\n",10, 50);
        txta.setEditable(false);
        txta.setFont(f3);
        txta.setForeground(Color.GREEN);
        txta.setBackground(Color.DARK_GRAY);
        JScrollPane scrollPane = new JScrollPane(txta);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mpan1.setBackground(Color.BLACK);
        mpan1.add(scrollPane);
        mpanel.add(lab1);
        mpanel.add(lab2);
        mpanel.add(txt);
        mpanel.add(txt1);
        mpan.add(mpanel);
        mpan.add(mpan1);
        add(mpan,BorderLayout.CENTER);

        bpan= new JPanel();
        bpan.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        b = new JButton("return to program");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        b.setForeground(Color.BLACK);
        b.setFont(f3);
        b2 = new JButton("calculate");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int val1 = Integer.parseInt(txt.getText());
                int val2 = Integer.parseInt(txt1.getText());
                int r=val1*val2;
                String fnl="raggrupamento("+val1+";"+val2+")="+r+"\n";
                txta.append(fnl);
            }
        });
        b2.setForeground(Color.BLACK);
        b2.setFont(f3);
        bpan.add(b2);
        bpan.add(b);
        bpan.setBackground(Color.BLACK);
        add(bpan,BorderLayout.SOUTH);

        setSize(512, 480);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
            @Override
            public void windowClosed(WindowEvent e) {   
            }
            @Override
            public void windowIconified(WindowEvent e) {   
            }
            @Override
            public void windowDeiconified(WindowEvent e) {  
            }
            @Override
            public void windowActivated(WindowEvent e) {
            }
            @Override
            public void windowDeactivated(WindowEvent e) { 
            }
        });
        setVisible(false);
    }
}
