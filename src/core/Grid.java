package core;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

// Needed to have a fixed dimension based on the game type
// Num representing the Game
// Based on the Game, Generating Different size of Grid
// Bejeweled & Candy Crush are similar
public class Grid extends JFrame {

    // Global Variable
    private JPanel contentPane;
    private JTextField textContent;
    public String userInput;
    public GameTimer timer;
    public boolean checkInput;
    private String gameSelect;
    public int score;
    private JLabel scoreLabel;
    private JLabel timerLabel;
    private int totalTime;

    JPanel[][] panel_88 = new JPanel[6][6];

    int[][] id = new int[6][6];
    Image[][] ImageBlock = new Image[6][6];
    Block[][] blockBlock = new Block[6][6];


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
    public Grid(int totalTime) {
        setFont(new Font("Sylfaen", Font.BOLD, 16));
        setTitle("TMGE");
        setBackground(new Color(152, 251, 152));
        initComponentss();
        score = 0;
        this.totalTime = totalTime;
        timer = new GameTimer(totalTime);
    }


    private void initComponentss() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1080, 775);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("Tile Matching Game");
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

        // User input panel
        JPanel panel = new JPanel();
        panel.setBounds(790, 50, 200, 600);
        contentPane.add(panel);
        panel.setLayout(null);

        // Timer Label
        timerLabel = new JLabel("0");
        timerLabel.setBounds(25, 250, 150, 60);
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(timerLabel);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 70));

        // Score Label
        scoreLabel = new JLabel("");
        scoreLabel.setBounds(25,300,150,60);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(scoreLabel);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        scoreLabel.setText("Score: " + score);

        // User input Stop button
        JButton stopButton = new JButton("End");
        stopButton.setFont(new Font("Sylfaen", Font.CENTER_BASELINE, 35));
        stopButton.setBounds(25, 100, 150, 50);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == stopButton){
                    timer.setTime(1);
                }
            }
        });
        panel.add(stopButton);


        // User input Start button
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Sylfaen", Font.CENTER_BASELINE, 35));
        startButton.setBounds(25, 170, 150, 50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == startButton){
                    timer.runTimer();
                }
            }
        });
        panel.add(startButton);




        // User input text field
        JLabel coords = new JLabel();
        coords.setBounds(25, 460, 150, 20);
        coords.setFont(new Font("Arial", Font.PLAIN, 15));
        coords.setText("Enter coordinates (x1,y1,x2,y2): ");
        textContent = new JTextField(30);
        textContent.setBounds(25, 480, 150, 20);
        // User input Enter button
        JButton button = new JButton("Enter");
        button.setFont(new Font("Sylfaen", Font.HANGING_BASELINE, 15));
        button.setBounds(65, 510, 70, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button){
                    // Input by click on the button
                    String input = textContent.getText();
                    //   System.out.println(input);
                    userInput = input;
                    checkInput = true;
                }
            }
        });

        textContent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Input from User
                String input = textContent.getText();
                //System.out.println(input);
            }
        });
        panel.add(button);
        panel.add(textContent);
        panel.add(coords);


        // User input GAME NAME
        JLabel namePrompt = new JLabel();
        namePrompt.setBounds(25, 360, 150, 20);
        namePrompt.setFont(new Font("Arial", Font.PLAIN, 15));
        namePrompt.setText("Enter a game name:");
        JTextField gameName = new JTextField(30);
        gameName.setBounds(25, 380, 150, 20);
        // User input Enter button
        JButton nameButton = new JButton("Enter");
        nameButton.setFont(new Font("Sylfaen", Font.HANGING_BASELINE, 15));
        nameButton.setBounds(65, 410, 70, 25);
        nameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == nameButton){
                    // Input by click on the button
                    String input = gameName.getText();
                    mnNewMenu.setText(input.toUpperCase());
                    gameSelect = input;
                    userInput = input;
                    checkInput = true;
                    addImages(input);
                }
            }
        });

        gameName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Input from User
                String input = gameName.getText();
                //System.out.println(input);
            }
        });
        panel.add(nameButton);
        panel.add(gameName);
        panel.add(namePrompt);




        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();




        for (int i = 0; i < panel_88.length; i++) {

            switch (i) {
                case 0:
                    drawGrid (i, panel_88, 0, 35, panel1);
                    break;
                case 1:
                    drawGrid (i, panel_88, 0, 135, panel2);
                    break;
                case 2:
                    drawGrid (i, panel_88, 0, 235, panel3);
                    break;
                case 3:
                    drawGrid (i, panel_88, 0, 335, panel4);
                    break;
                case 4:
                    drawGrid (i, panel_88, 0, 435, panel5);
                    break;
                case 5:
                    drawGrid (i, panel_88, 0, 535, panel6);
                    break;
            }
        }

    }

    // Draw necessary panel
    public void drawGrid (int i, JPanel panel_88[][], int panel88Value, int panelxValue, JPanel panel) {
        panel.setBounds(panelxValue, 50, 100, 600);
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

    public void addImage(String name, int i, int j){
        Block myPicture = new Block(name);
        myPicture.setImage();
        Image block = myPicture.getBlockImage().getScaledInstance(panel_88[i][j].getWidth(),panel_88[i][j].getHeight(),Image.SCALE_SMOOTH);
        JLabel picLabel = new JLabel(new ImageIcon(block));
        id[i][j] = myPicture.getID();
        ImageBlock[i][j] = block;
        blockBlock[i][j] = myPicture;
        panel_88[i][j].add(picLabel);
    }
    public void addImages(String name){
        for (int i = 0; i < panel_88.length; i++){
            for (int j = 0; j < panel_88[i].length; j++){
                addImage(name, i, j);
            }
        }
    }

    // Call to update the grid after blocks have been removed following a match
    public void updateGrid(){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (id[i][j] == -1){
                    int tempj = j;
                    while (tempj > 0){

                        removeBlock(i, tempj);
                        addBlock(i, tempj, i, tempj-1);
                        id[i][tempj] = id[i][tempj-1];
                        ImageBlock[i][tempj] = ImageBlock[i][tempj-1];
                        blockBlock[i][tempj] = blockBlock[i][tempj-1];
                        tempj--;
                    }
                    addImage(this.gameSelect, i,tempj);
                }
            }
        }
    }


    // Current Version Will Ask User to Type Two Coordinates at the same time. ex: 1,4,5,5
    // The Coordinates are (1,4)(5,5)
    public void swapImage (boolean checkInput, String input) {


        // Only accept the input separate by single comma "," no space afterwords
        if (checkInput == true) {
            String[] inputNum = input.split(",");
            int numX = Integer.parseInt(inputNum[0]) - 1;
            int numY = Integer.parseInt(inputNum[1]) - 1;
            int num2X = Integer.parseInt(inputNum[2]) - 1;
            int num2Y = Integer.parseInt(inputNum[3]) - 1;
            //System.out.print(inputNum[0] +" "+ inputNum[1]+" "+ inputNum[2]+" "+ inputNum[3]);

            // Get first coordinate component for second coordinate update
            Component first = null;
            Component[] componentList = panel_88[numX][numY].getComponents();
            for(Component c : componentList){
                if(c instanceof JLabel){
                    first = c;
                }
            }

            // Setting temp variable
            int idtemp = id[numX][numY];
            Image imageTemp = ImageBlock[numX][numY];
            Block blockTemp = blockBlock[numX][numY];

            // Remove first coordinates
            removeBlock(numX, numY);
            // Update first coordinates
            addBlock(numX, numY, num2X, num2Y);

            // Update 2D array for first coordinate
            id[numX][numY] = id[num2X][num2Y];
            ImageBlock[numX][numY] = ImageBlock[num2X][num2Y];
            blockBlock[numX][numY] = blockBlock[num2X][num2Y];

            // Remove second coordinates
            removeBlock(num2X, num2Y);
            // Update second coordinates
            addSecondBlock(num2X, num2Y, numX, numY, first);

            // Update 2D array for second coordinate
            id[num2X][num2Y] = idtemp;
            ImageBlock[num2X][num2Y] = imageTemp;
            blockBlock[num2X][num2Y] = blockTemp;


        }

    }

    public void addSecondBlock (int x, int y, int x2, int y2, Component first) {
        Component[] component1 = panel_88[x2][y2].getComponents();
        for(Component c : component1){
            if(c instanceof JLabel){
                panel_88[x][y].add(first);
            }
        }
        panel_88[x][y].revalidate();
        panel_88[x][y].repaint();
    }

    public void addBlock (int x, int y, int x2, int y2) {
        Component[] component1 = panel_88[x2][y2].getComponents();
        for(Component c : component1){
            if(c instanceof JLabel){
                panel_88[x][y].add(c);
            }
        }
        panel_88[x][y].revalidate();
        panel_88[x][y].repaint();
    }

    public void removeBlock(int x, int y){
        Component[] componentList = panel_88[x][y].getComponents();
        for(Component c : componentList){
            if(c instanceof JLabel){
                panel_88[x][y].remove(c);
            }
        }
        id[x][y] = -1;
        ImageBlock[x][y] = null;
        blockBlock[x][y] = null;
        panel_88[x][y].revalidate();
        panel_88[x][y].repaint();
    }

    public void updateScore(int score){
        this.score += score;
        scoreLabel.setText("Score: " + this.score);
    }

    public void updateTimer(){
        timerLabel.setText("" + timer.getTimeRemaining());
    }


}
