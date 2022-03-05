import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
        setTitle("Connect Four");
        setBackground(new Color(152, 251, 152));
        initComponentss();
    }


    private void initComponentss() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1380, 897);

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
        lblNewLabel.setBounds(1108, 0, 222, 32);
        contentPane.add(lblNewLabel);

//        // First Column
//        JPanel panel = new JPanel();
//        panel.setBounds(15, 15, 100, 800);
//        contentPane.add(panel);
//        panel.setLayout(null);
//
//        JPanel panel_9 = new JPanel();
//        panel_9.setBackground(new Color(255, 255, 255));
//        panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_9.setBounds(0, 0, 100, 100);
//        panel.add(panel_9);
//
//        JPanel panel_10 = new JPanel();
//        panel_10.setBackground(new Color(255, 255, 255));
//        panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_10.setBounds(0, 100, 100, 100);
//        panel.add(panel_10);
//
//        JPanel panel_11 = new JPanel();
//        panel_11.setBackground(new Color(255, 255, 255));
//        panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_11.setBounds(0, 200, 100, 100);
//        panel.add(panel_11);
//
//        JPanel panel_12 = new JPanel();
//        panel_12.setBackground(new Color(255, 255, 255));
//        panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_12.setBounds(0, 300, 100, 100);
//        panel.add(panel_12);
//
//        JPanel panel_13 = new JPanel();
//        panel_13.setBackground(new Color(255, 255, 255));
//        panel_13.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_13.setBounds(0, 400, 100, 100);
//        panel.add(panel_13);
//
//        JPanel panel_14 = new JPanel();
//        panel_14.setBackground(new Color(255, 255, 255));
//        panel_14.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_14.setBounds(0, 500, 100, 100);
//        panel.add(panel_14);
//
//        JPanel panel_15 = new JPanel();
//        panel_15.setBackground(new Color(255, 255, 255));
//        panel_15.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_15.setBounds(0, 600, 100, 100);
//        panel.add(panel_15);
//
//        JPanel panel_16 = new JPanel();
//        panel_16.setBackground(new Color(255, 255, 255));
//        panel_16.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_16.setBounds(0, 700, 100, 100);
//        panel.add(panel_16);
//
//        //Second Column
//        JPanel panel_1 = new JPanel();
//        panel_1.setBounds(115, 15, 100, 800);
//        contentPane.add(panel_1);
//        panel_1.setLayout(null);
//
//        JPanel panel_17 = new JPanel();
//        panel_17.setBackground(new Color(255, 255, 255));
//        panel_17.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_17.setBounds(0, 0, 100, 100);
//        panel_1.add(panel_17);
//
//        JPanel panel_18 = new JPanel();
//        panel_18.setBackground(new Color(255, 255, 255));
//        panel_18.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_18.setBounds(0, 100, 100, 100);
//        panel_1.add(panel_18);
//
//        JPanel panel_19 = new JPanel();
//        panel_19.setBackground(new Color(255, 255, 255));
//        panel_19.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_19.setBounds(0, 200, 100, 100);
//        panel_1.add(panel_19);
//
//        JPanel panel_20 = new JPanel();
//        panel_20.setBackground(new Color(255, 255, 255));
//        panel_20.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_20.setBounds(0, 300, 100, 100);
//        panel_1.add(panel_20);
//
//        JPanel panel_21 = new JPanel();
//        panel_21.setBackground(new Color(255, 255, 255));
//        panel_21.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_21.setBounds(0, 400, 100, 100);
//        panel_1.add(panel_21);
//
//        JPanel panel_22 = new JPanel();
//        panel_22.setBackground(new Color(255, 255, 255));
//        panel_22.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_22.setBounds(0, 500, 100, 100);
//        panel_1.add(panel_22);
//
//        JPanel panel_23 = new JPanel();
//        panel_23.setBackground(new Color(255, 255, 255));
//        panel_23.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_23.setBounds(0, 600, 100, 100);
//        panel_1.add(panel_23);
//
//        JPanel panel_24 = new JPanel();
//        panel_24.setBackground(new Color(255, 255, 255));
//        panel_24.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//        panel_24.setBounds(0, 700, 100, 100);
//        panel_1.add(panel_24);
//
//        // Third Column
//        JPanel panel_2 = new JPanel();
//        panel_2.setBounds(215, 15, 100, 800);
//        contentPane.add(panel_2);
//        panel_2.setLayout(null);

//        int [][] grid = new int[6][6];
//
//        for (int row = 0; row < grid.length; row++) {
//            for (int col = 0; col < grid[row].length; col++) {
//
//            }
//        }
        // Above approach is time wasting, and not future maintainable
        // Optimizing algo
        JPanel[][] panel_88 = new JPanel[8][8];

        for (int i = 0; i < panel_88.length; i++) {
            JPanel panel_2 = new JPanel();
            panel_2.setBounds(215, 15, 100, 800);
            contentPane.add(panel_2);
            panel_2.setLayout(null);
            for (int j = 0; j < panel_88[i].length; j++) {
                panel_88[i][j] = new JPanel();
                panel_88[i][j].setBackground(new Color(255, 255, 255));
                panel_88[i][j].setBorder(new LineBorder(new Color(0, 0, 0), 1));
                panel_88[i][j].setBounds(0, 700, 100, 100);
            }
        }
    }




    public void gridClass (int num) {

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
