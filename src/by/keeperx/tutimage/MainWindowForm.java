/*
 * Created by JFormDesigner on Thu Aug 18 16:44:30 EAT 2016
 */

package by.keeperx.tutimage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Vasiliy
 */
public class MainWindowForm extends JFrame {
    private final String[] list={".png",".jpg"};
    public MainWindowForm(int width, int height) {
        initComponents();
        comboBox1.addItem("png");
        comboBox1.addItem("jpg");
        comboBox1.setSelectedIndex(0);
       // pack();
        //label1.setBounds(275, 10, 50, 25);
        //setLocationRelativeTo(null);
        setSize(width,height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    private void button1ActionPerformed() {
        System.out.print("2-");
    }

    private void button3ActionPerformed(ActionEvent e) {
      if (Main.getImage()!=null) {
          label2.setIcon(new ImageIcon(Main.getImage()));
          label2.updateUI();
      }
    }



    private void button1ActionPerformed(ActionEvent e) {
        try {
            Main.setImage(new URL(textArea1.getText()));
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null,"Чё-то не похоже на ссылку)");
        }
    }

    private void menuItem3ActionPerformed(ActionEvent e) {
        System.exit(0);
    }








    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel3 = new JPanel();
        button1 = new JButton();
        hSpacer1 = new JPanel(null);
        hSpacer2 = new JPanel(null);
        button2 = new JButton();
        textArea1 = new JTextArea();
        panel2 = new JPanel();
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        button3 = new JButton();
        panel6 = new JScrollPane();
        panel5 = new JPanel();
        label2 = new JLabel();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        buttonClipboard = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //======== panel3 ========
                {
                    panel3.setLayout(new FlowLayout());

                    //---- button1 ----
                    button1.setText("GetImage");
                    button1.addActionListener(e -> button1ActionPerformed(e));
                    panel3.add(button1);
                    buttonClipboard.setText("Clipboard");
                    buttonClipboard.addActionListener(e -> {
                        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                        try{
                        textArea1.setText((String)clip.getData(DataFlavor.stringFlavor));
                        }catch(Exception f){};



                    } );
                    panel3.add(buttonClipboard);

                    //---- hSpacer2 ----
                    hSpacer2.setPreferredSize(new Dimension(100, 10));
                    panel3.add(hSpacer2);

                    //---- button2 ----
                    button2.setText("Get File");
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFileChooser jFC=new JFileChooser();
                            int reply =jFC.showOpenDialog(null);
                            System.out.println(reply);
                            if (reply==JFileChooser.APPROVE_OPTION){Main.setImage(jFC.getSelectedFile());}
                        }
                    });
                    panel3.add(button2);
                }
                panel1.add(panel3, BorderLayout.NORTH);

                //---- textArea1 ----
                textArea1.setText("Enter URL Here");
                panel1.add(textArea1, BorderLayout.CENTER);
            }
            tabbedPane1.addTab("1", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(null);

                //---- label1 ----
                label1.setText("format:");
                panel2.add(label1);
                label1.setBounds(460, 10, 50, 25);
                panel2.add(comboBox1);
                comboBox1.setBounds(505, 10, 65, comboBox1.getPreferredSize().height);

                //---- button3 ----
                button3.setText("View");
                button3.addActionListener(e -> button3ActionPerformed(e));
                panel2.add(button3);
                button3.setBounds(10, 10, 90, button3.getPreferredSize().height);

                //======== panel6 ========
                {
                panel6.setViewportView(panel5);
                panel6.setAutoscrolls(true);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new BorderLayout());

                        //---- label2 ----
                        label2.setText("");
                        panel5.add(label2, BorderLayout.CENTER);
                    }

                }
                panel2.add(panel6);
                panel6.setBounds(0, 45, 580, 345);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("2", panel2);
        }
        contentPane.add(tabbedPane1, BorderLayout.CENTER);

        //======== menuBar1 ========
        {
            menuBar1.setToolTipText("12");

            //======== menu1 ========
            {
                menu1.setText("Menu");

                //---- menuItem1 ----
                menuItem1.setText("Save file");
                menuItem1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (Main.getImage()==null){return;}
                        JFileChooser jFC=new JFileChooser();
                        int reply=jFC.showSaveDialog(null);
                        if(reply==JFileChooser.APPROVE_OPTION){Main.saveImage(jFC.getSelectedFile(),(String)comboBox1.getSelectedItem());}
                    }
                });
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Options");

                //---- menuItem3 ----
                menuItem3.setText("Exit Program");
                menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
                menu2.add(menuItem3);
            }
            menuBar1.add(menu2);
        }
        contentPane.add(menuBar1, BorderLayout.PAGE_START);
        setSize(640, 480);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JTabbedPane tabbedPane1;
    public JPanel panel1;
    public JPanel panel3;
    public JButton button1;
    public JPanel hSpacer1;
    public JPanel hSpacer2;
    public JButton button2;
    public JTextArea textArea1;
    public JPanel panel2;
    public JLabel label1;
    public JComboBox comboBox1;
    public JButton button3;
    public JScrollPane panel6;
    public JPanel panel5;
    public JLabel label2;
    public JMenuBar menuBar1;
    public JMenu menu1;
    public JMenuItem menuItem1;
    public JMenu menu2;
    public JMenuItem menuItem3;
    public JButton buttonClipboard;
}
