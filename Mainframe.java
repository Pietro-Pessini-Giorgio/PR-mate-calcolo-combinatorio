import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.*;

public class Mainframe extends JFrame{
    JPanel  tpan,mpan,mpan1,mpan2,mpan3,mpan3a,mpan3b,bpan;
    JTextField txt,txt1;
    JButton b,b2,b3;
    JLabel lab,lab1,lab2,lab3,lab3b,lab4,lab4b,labn,labnull;
    JRadioButton ch1,ch2,ch3,ch4,opt2,opt3;
    ButtonGroup chGroup1 = new ButtonGroup();
    ButtonGroup chGroup2 = new ButtonGroup();
    ButtonGroup chGroup3 = new ButtonGroup();
    JTextArea txta;
    JMenuBar mn;
    JMenu m;

    public Mainframe(Font f,Font f2,Font f3){
        Instruction ins=new Instruction(f, f2, f3);
        Ragruop rag = new Ragruop(f, f2, f3);
        //to set the frame in the middle of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - 740) / 2;
        int y = (screenSize.height - 640) / 2;
        setLocation(x, y);

        List<Image> icons = new ArrayList<>();
        icons.add(Toolkit.getDefaultToolkit().getImage("image\\calculator-icon-free-vector16.png"));
        icons.add(Toolkit.getDefaultToolkit().getImage("image\\calculator-icon-free-vector32.png"));
        icons.add(Toolkit.getDefaultToolkit().getImage("image\\calculator-icon-free-vector64.png"));
        setIconImages(icons);
        setTitle("PR-mate-calcolo-combinatorio-(Calcolatrice-calcolo-combinatorio)");
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        try {
            File musicPath = new File("music\\War-Without-Reason-_mp3cut.net_.wav");
            if(musicPath.exists()){ 
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }else{
                System.out.println("Couldn't find Music file");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //tpan is used for title
        tpan = new JPanel();
        tpan.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lab = new JLabel("Calcolatrice calcolo combinatorio");
        lab.setFont(f);
        lab.setForeground(Color.GREEN);
        tpan.add(lab);

        //mpan contain various panel use for most of the utilities of this swing app
        mpan = new JPanel();
        mpan.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mpan.setLayout(new GridLayout(3, 1, 15, 15));

        //mpan1 is used for the input of n & k
        mpan1 = new JPanel();
        mpan1.setLayout(new GridLayout(2, 2, 5, 5));
        lab1 = new JLabel("n (numero di elementi):");
        lab1.setFont(f2);
        lab1.setForeground(Color.GREEN);
        txt = new JTextField(20);
        txt.setFont(f2);
        txt.setForeground(Color.GREEN);
        txt.setBackground(Color.DARK_GRAY);
        bpan= new JPanel();
        lab2 = new JLabel("k (numero delle scelte o degli spazi possibili):");
        lab2.setFont(f2);
        lab2.setForeground(Color.GREEN);
        txt1 = new JTextField(20);
        txt1.setFont(f2);
        txt1.setForeground(Color.GREEN);
        txt1.setBackground(Color.DARK_GRAY);
        mpan1.add(lab1);
        mpan1.add(lab2);
        mpan1.add(txt);
        mpan1.add(txt1);
        mpan.add(mpan1);

        //mpan2 is used to choose the operation
        mpan2= new JPanel();
        mpan2.setLayout(new GridLayout(5, 2, 5, 5));
        lab3= new JLabel("l'ordine è importante?:");
        lab3.setFont(f2);
        lab3.setForeground(Color.GREEN);
        lab3b = new JLabel("gli elementi sono tutti diversi?:");
        lab3b.setFont(f2);
        lab3b.setForeground(Color.GREEN);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("RadioButton.background", Color.BLACK);
            UIManager.put("RadioButton.foreground", Color.GREEN);
            UIManager.put("RadioButton.focus", Color.BLACK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            
            // Customize Nimbus colors
            UIManager.put("RadioButton[Focused+Pressed+Selected].iconPainter", 
                new Painter<JComponent>() {
                    @Override
                    public void paint(Graphics2D g, JComponent c, int w, int h) {
                        g.setColor(Color.GREEN);
                        g.fillOval(w/2 - 4, h/2 - 4, 8, 8); // GREEN dot
                    }
                }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        ch1 = new JRadioButton("no"){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                if (isSelected()) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(Color.GREEN); // Set your desired color here
                    
                    // Calculate position for the dot
                    int dotDiameter = getHeight() / 5;
                    int x = getHeight() / 7;
                    int y = (getHeight() - dotDiameter) / 2;
                    
                    g2.fillOval(x, y, dotDiameter, dotDiameter);
                    
                    g2.dispose();
                }
            }
        };
        ch1.setFont(f2);
        ch1.setForeground(Color.GREEN);
        ch1.setBackground(Color.BLACK);
        ch2 = new JRadioButton("si"){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                if (isSelected()) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(Color.GREEN); // Set your desired color here
                    
                    // Calculate position for the dot
                    int dotDiameter = getHeight() / 5;
                    int x = getHeight() / 7;
                    int y = (getHeight() - dotDiameter) / 2;
                    
                    g2.fillOval(x, y, dotDiameter, dotDiameter);
                    
                    g2.dispose();
                }
            }
        };
        ch2.setFont(f2);
        ch2.setForeground(Color.GREEN);
        ch2.setBackground(Color.BLACK);
        ch3 = new JRadioButton("no"){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                if (isSelected()) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(Color.GREEN); // Set your desired color here
                    
                    // Calculate position for the dot
                    int dotDiameter = getHeight() / 5;
                    int x = getHeight() / 7;
                    int y = (getHeight() - dotDiameter) / 2;
                    
                    g2.fillOval(x, y, dotDiameter, dotDiameter);
                    
                    g2.dispose();
                }
            }
        };
        ch3.setFont(f2);
        ch3.setForeground(Color.GREEN);
        ch3.setBackground(Color.BLACK);
        ch4 = new JRadioButton("si"){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                if (isSelected()) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(Color.GREEN); // Set your desired color here
                    
                    // Calculate position for the dot
                    int dotDiameter = getHeight() / 5;
                    int x = getHeight() / 7;
                    int y = (getHeight() - dotDiameter) / 2;
                    
                    g2.fillOval(x, y, dotDiameter, dotDiameter);
                    
                    g2.dispose();
                }
            }
        };
        ch4.setFont(f2);
        ch4.setForeground(Color.GREEN);
        ch4.setBackground(Color.BLACK);
        chGroup1.add(ch1);
        chGroup2.add(ch3);
        chGroup1.add(ch2);
        chGroup2.add(ch4);
        labn=new JLabel("n=k:");
        labn.setFont(f2);
        labn.setForeground(Color.GREEN);
        labnull=new JLabel("");
        opt2= new JRadioButton("si"){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                if (isSelected()) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(Color.GREEN); // Set your desired color here
                    
                    // Calculate position for the dot
                    int dotDiameter = getHeight() / 5;
                    int x = getHeight() / 7;
                    int y = (getHeight() - dotDiameter) / 2;
                    
                    g2.fillOval(x, y, dotDiameter, dotDiameter);
                    
                    g2.dispose();
                }
            }
        };
        opt2.setFont(f2);
        opt2.setForeground(Color.GREEN);
        opt2.setBackground(Color.BLACK);
        opt3= new JRadioButton("no"){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                if (isSelected()) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(Color.GREEN); // Set your desired color here
                    
                    // Calculate position for the dot
                    int dotDiameter = getHeight() / 5;
                    int x = getHeight() / 7;
                    int y = (getHeight() - dotDiameter) / 2;
                    
                    g2.fillOval(x, y, dotDiameter, dotDiameter);
                    
                    g2.dispose();
                }
            }
        };
        opt3.setFont(f2);
        opt3.setForeground(Color.GREEN);
        opt3.setBackground(Color.BLACK);
        chGroup3.add(opt2);
        chGroup3.add(opt3);
        mpan2.add(lab3);
        mpan2.add(lab3b);
        mpan2.add(ch1);
        mpan2.add(ch3);
        mpan2.add(ch2);
        mpan2.add(ch4);
        mpan2.add(labn);
        mpan2.add(labnull);
        mpan2.add(opt2);
        mpan2.add(opt3);
        mpan.add(mpan2);

        //mpan3 show the last operation
        mpan3 = new JPanel();
        mpan3.setLayout(new FlowLayout());
        txta = new JTextArea("Last operation:\n",10, 50);
        txta.setEditable(false);
        txta.setFont(f3);
        txta.setForeground(Color.GREEN);
        txta.setBackground(Color.DARK_GRAY);
        JScrollPane scrollPane = new JScrollPane(txta);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mpan3.add(scrollPane);
        mpan.add(mpan3);

        //bpan contain only the botton use for calculation
        bpan= new JPanel();
        bpan.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b = new JButton("calcola");
        b.setForeground(Color.BLACK);
        b.setFont(f3);
        bpan.add(b);
        add(tpan, BorderLayout.NORTH);
        add(mpan, BorderLayout.CENTER);
        add(bpan, BorderLayout.SOUTH);
        tpan.setBackground(Color.BLACK);
        mpan.setBackground(Color.BLACK);
        mpan1.setBackground(Color.BLACK);
        mpan2.setBackground(Color.BLACK);
        mpan3.setBackground(Color.BLACK);
        bpan.setBackground(Color.BLACK);
        mn=new JMenuBar();
        m=new JMenu("Menu");
        b2=new JButton("instruction");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ins.setVisible(true);
            }
        });
        b3=new JButton("raggruppamento");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rag.setVisible(true);
            }
        });
        m.add(b2);
        m.addSeparator();
        m.add(b3);
        mn.add(m);
        setJMenuBar(mn);


        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int val1 = Integer.parseInt(txt.getText());
                int res;
                String fnl = ""; 
                
                if(ch1.isSelected()){
                    if(ch3.isSelected()){
                        int val2 = Integer.parseInt(txt1.getText());
                        res = (int) CombinatorioCompleto.combinazioniConRipetizione(val1, val2);
                        fnl = "Combinazioni con ripetizione("+val1+";"+val2+")=" + res + "\n";
                        txta.append(fnl);
                    }
                    if(ch4.isSelected()){
                        int val2 = Integer.parseInt(txt1.getText());
                        res = (int) CombinatorioCompleto.combinazioni(val1, val2);
                        fnl = "Combinazioni semplici("+val1+";"+val2+")=" + res + "\n";
                        txta.append(fnl);
                    }
                }
                if(ch2.isSelected()){
                    if(opt2.isSelected()){
                        if(ch4.isSelected()){
                            int val2 = Integer.parseInt(txt1.getText());
                            if (val1==val2) {
                                res = (int) CombinatorioCompleto.permutazioni(val1);
                                fnl = "Permutazioni semplici("+val1+")=" + res + "\n";
                                txta.append(fnl);
                            }else{
                                fnl = "per le permutazione i valori di n e k devono \nessere uguali \n";
                                txta.append(fnl);
                            }
                        }else{
                            String val2 = txt1.getText();
                            StringTokenizer st=new StringTokenizer(val2, ";");
                            ArrayList<Integer> in = new ArrayList<Integer>();
                            while (st.hasMoreTokens()) {
                                in.add(Integer.parseInt(st.nextToken()));
                            }
                            res= (int) CombinatorioCompleto.permutazioniConRipetizione(val1, in);
                            fnl = "permutazioni con ripetizione("+val1+";["+val2+"])=" + res + "\n";  
                            txta.append(fnl);          
                        }
                    }else{
                        if(ch3.isSelected()){
                            int val2 = Integer.parseInt(txt1.getText());
                            res = (int) CombinatorioCompleto.disposizioniConRipetizione(val1, val2);
                            fnl = "Disposizioni con ripetizione("+val1+";"+val2+")=" + res + "\n";
                            txta.append(fnl);
                        }
                        if(ch4.isSelected()){
                            int val2 = Integer.parseInt(txt1.getText());
                            res = (int) CombinatorioCompleto.disposizioni(val1, val2);
                            fnl = "Disposizioni semplici("+val1+";"+val2+")=" + res + "\n";
                            txta.append(fnl);
                        }
                    }
                    
                }
            }
        });


        setSize(740, 740);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
