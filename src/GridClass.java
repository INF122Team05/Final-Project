import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.text.AbstractDocument;

// Needed to have a fixed dimension based on the game type
// Num representing the Game
// Based on the Game, Generating Different size of Grid
// Bejeweled & Candy Crush are similar
public class GridClass extends JFrame {

    // Global Variable
    private JPanel contentPane;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GridClass frame = new GridClass();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
    }
    public GridClass() {
        setFont(new Font("Sylfaen", Font.BOLD, 16));
        setTitle("TMGE");
        setBackground(new Color(152, 251, 152));
        initComponentss();
    }


    private void initComponentss() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1080, 897);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("Bejeweled");
        mnNewMenu.setFont(new Font("Sylfaen", Font.BOLD, 17));
        menuBar.add(mnNewMenu);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Team5 - GameApp");
        lblNewLabel.setBackground(new Color(255, 215, 0));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 17));
        lblNewLabel.setBounds(858, 0, 222, 32);
        contentPane.add(lblNewLabel);


        JPanel[][] panel_88 = new JPanel[8][8];
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();


        for (int i = 0; i < panel_88.length; i++) {
            switch (i) {
                case 1:
                    drawGrid (i, panel_88, 0, 15, panel1);
                    break;
                case 2:
                    drawGrid (i, panel_88, 0, 115, panel2);
                    break;
                case 3:
                    drawGrid (i, panel_88, 0, 215, panel3);
                    break;
                case 4:
                    drawGrid (i, panel_88, 0, 315, panel4);
                    break;
                case 5:
                    drawGrid (i, panel_88, 0, 415, panel5);
                    break;
                case 6:
                    drawGrid (i, panel_88, 0, 515, panel6);
                    break;
                case 7:
                    drawGrid (i, panel_88, 0, 615, panel7);
                    break;
                case 8:
                    drawGrid (i, panel_88, 0, 715, panel8);
                    break;
                case 9:
                    break;
            }
        }
    }

    // Draw necessary panel
    public void drawGrid (int i, JPanel panel_88[][], int panel88Value, int panelxValue, JPanel panel) {
        panel.setBounds(panelxValue, 15, 100, 800);
        contentPane.add(panel);
        panel.setLayout(null);
        for (int j = 0; j < panel_88[i].length; j++) {
            panel_88[i][j] = new JPanel();
            panel_88[i][j].setBackground(new Color(255, 255, 255));
            panel_88[i][j].setBorder(new LineBorder(new Color(0, 0, 0), 1));
            panel_88[i][j].setBounds(0, panel88Value, 100, 100);
            panel.add(panel_88[i][j]);
            panel88Value+=100;
        }
    }




    private void newGameActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GridClass frame = new GridClass();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
