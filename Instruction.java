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

public class Instruction extends JFrame {
    JPanel  tpan,mpan,mpan1,bpan;
    JButton b;
    JLabel lab,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,lab8b,lab9,lab9c,lab9b,lab9d,lab9e,lab9f,lab10,lab10b;

    public Instruction(Font f,Font f2,Font f3){
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
        lab = new JLabel("Istruzioni per l'uso:");
        lab.setFont(f);
        lab.setForeground(Color.GREEN);
        tpan.setBackground(Color.BLACK);
        tpan.add(lab);
        add(tpan,BorderLayout.NORTH);

        mpan = new JPanel();
        mpan.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        mpan.setBackground(Color.BLACK);
        mpan1 = new JPanel();
        mpan1.setLayout(new GridLayout(17, 1, 5, 5));
        mpan1.setBackground(Color.BLACK);
        lab1 = new JLabel("1) inserire solo valori numerici nelle due caselle (ameno che non vi venga richesto il contrario).");
        lab1.setFont(f2);
        lab1.setForeground(Color.GREEN);
        lab2 = new JLabel("2) calcoli e rispetive combinazioni di pulsanti:");
        lab2.setFont(f2);
        lab2.setForeground(Color.GREEN);
        lab3 = new JLabel("         nome-formula[forlmula-scritta]:ordine,elementi-diversi,n=k");
        lab3.setFont(f2);
        lab3.setForeground(Color.GREEN);
        lab4 = new JLabel("         disposizini-semplici[D(N;K)=n!/(n-k)!]:si,si,no");
        lab4.setFont(f2);
        lab4.setForeground(Color.GREEN);
        lab5 = new JLabel("         disposizini-con-ripetizione[D'(N;K)=n^k]:si,no,no");
        lab5.setFont(f2);
        lab5.setForeground(Color.GREEN);
        lab6 = new JLabel("         cobinazioni-semplici[C(n;k)=n!/(k!*(n-k)!]:no,si,non-importa");
        lab6.setFont(f2);
        lab6.setForeground(Color.GREEN);
        lab7 = new JLabel("         cobinazioni-con-ripetizione[C'(n;k)=C(n+k-1,k)]:no,no,non-importa");
        lab7.setFont(f2);
        lab7.setForeground(Color.GREEN);
        lab8 = new JLabel("         permutazioni-semplici[p(n)=n!]:si,si,si");
        lab8.setFont(f2);
        lab8.setForeground(Color.GREEN);
        lab8b = new JLabel("         per fare le permutaizioni semplici i valori di n e k devono essere uguali");
        lab8b.setFont(f2);
        lab8b.setForeground(Color.GREEN);
        lab9 = new JLabel("         permutazioni-con-ripetizioni[p(n)=n!/(p1!*p2!*...*pk!]:si,no,si");
        lab9.setFont(f2);
        lab9.setForeground(Color.GREEN);
        lab9b = new JLabel("         per le permutazioni con ripetizioni n deve essere un intero mentre k deve avere");
        lab9b.setFont(f2);
        lab9b.setForeground(Color.GREEN);
        lab9c = new JLabel("         tutti gli elementi sudivisi per similarità per esempio per il problemma: tutte gli");
        lab9c.setFont(f2);
        lab9c.setForeground(Color.GREEN);
        lab9d = new JLabel("         anagrammi anche senza senso di aabbc devi inserire in n la somma degli elementi percui");
        lab9d.setFont(f2);
        lab9d.setForeground(Color.GREEN);
        lab9e = new JLabel("         n=5 mentre k tutti i gruppi di elementi ugiali in questo caso siccome abbiamo 2 volte a e b");
        lab9e.setFont(f2);
        lab9e.setForeground(Color.GREEN);
        lab9f = new JLabel("         e 1 volta c k=2;2;1");
        lab9f.setFont(f2);
        lab9f.setForeground(Color.GREEN);
        lab10 = new JLabel("3) tutti gli errori dovuti dal l'uso sbagliato del programma o della scrittura degli input e da attribuire");
        lab10.setFont(f2);
        lab10.setForeground(Color.GREEN);
        lab10b = new JLabel("   solo all'utente e non al programmatore");
        lab10b.setFont(f2);
        lab10b.setForeground(Color.GREEN);
        mpan.setBackground(Color.BLACK);
        mpan1.add(lab1);
        mpan1.add(lab2);
        mpan1.add(lab3);
        mpan1.add(lab4);
        mpan1.add(lab5);
        mpan1.add(lab6);
        mpan1.add(lab7);
        mpan1.add(lab8);
        mpan1.add(lab8b);
        mpan1.add(lab9);
        mpan1.add(lab9b);
        mpan1.add(lab9c);
        mpan1.add(lab9d);
        mpan1.add(lab9e);
        mpan1.add(lab9f);
        mpan1.add(lab10);
        mpan1.add(lab10b);
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
        bpan.add(b);
        bpan.setBackground(Color.BLACK);
        add(bpan,BorderLayout.SOUTH);

        setSize(820, 580);
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
