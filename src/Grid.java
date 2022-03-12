import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Image;
import javax.swing.Timer;

// Needed to have a fixed dimension based on the game type
// Num representing the Game
// Based on the Game, Generating Different size of Grid
// Bejeweled & Candy Crush are similar
public class Grid extends JFrame {

    // Global Variable
    private JPanel contentPane;
    private JTextField textContent;
    public String userInput;
    public boolean checkInput;
    private Timer timer;
    private int seconds;
    JPanel[][] panel_88 = new JPanel[6][6];

    
    
    private Block[][] blocks;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Grid frame = new Grid();
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
    public Grid() {
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

        // User input panel
        JPanel panel = new JPanel();
        panel.setBounds(790, 100, 200, 600);
        contentPane.add(panel);
        panel.setLayout(null);

        // Timer Label
        JLabel timerLabel = new JLabel("");
        timerLabel.setBounds(25, 250, 150, 60);
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(timerLabel);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 70));

        // User input Stop button
        JButton stopButton = new JButton("Stop");
        stopButton.setFont(new Font("Sylfaen", Font.CENTER_BASELINE, 35));
        stopButton.setBounds(25, 100, 150, 50);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == stopButton){
                    timer.stop();
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
                    timer(timerLabel);
                    timer.start();
                }
            }
        });
        panel.add(startButton);




        // User input text field
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
                    System.out.println(input);
                    userInput = input;
                    checkInput = true;
                    swapImage(checkInput, input);
                }
            }
        });

        textContent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Input from User
                String input = textContent.getText();
                System.out.println(input);
            }
        });
        panel.add(button);
        panel.add(textContent);


        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();

        this.blocks = new Block[6][6];
        for (int i = 0; i < panel_88.length; i++) {
            switch (i) {
                case 0:
                    drawGrid (i, panel_88, 0, 15, panel1);
                    break;
                case 1:
                    drawGrid (i, panel_88, 0, 115, panel2);
                    break;
                case 2:
                    drawGrid (i, panel_88, 0, 215, panel3);
                    break;
                case 3:
                    drawGrid (i, panel_88, 0, 315, panel4);
                    break;
                case 4:
                    drawGrid (i, panel_88, 0, 415, panel5);
                    break;
                case 5:
                    drawGrid (i, panel_88, 0, 515, panel6);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        }
        printBlocks(); //for debugging
        checkAvailableMoves();
//        printBlocks();

    }
    
    private boolean checkRight(int i, int j) {
    	Block temp = this.blocks[i][j];
    	this.blocks[i][j] = this.blocks[i][j+1];
		this.blocks[i][j+1] = temp;
//		printBlocks();
		//return [INSERT CHECK VALID FUNCTION]
		
		//swap back
		this.blocks[i][j+1] = this.blocks[i][j];
		this.blocks[i][j] = temp;
//		printBlocks();
		return false;
    }
    private boolean checkLeft(int i, int j) {
    	Block temp = this.blocks[i][j];
    	this.blocks[i][j] = this.blocks[i][j-1];
		this.blocks[i][j-1] = temp;
//		printBlocks();
		//return [INSERT CHECK VALID FUNCTION]
		
		//swap back
		this.blocks[i][j-1] = this.blocks[i][j];
		this.blocks[i][j] = temp;
//		printBlocks();
		return false;
    }
    
    private boolean checkBottom(int i, int j) {
    	Block temp = this.blocks[i][j];
    	this.blocks[i][j] = this.blocks[i+1][j];
		this.blocks[i+1][j] = temp;
//		printBlocks();
		//return [INSERT CHECK VALID FUNCTION]
		
		//swap back
		this.blocks[i+1][j] = this.blocks[i][j];
		this.blocks[i][j] = temp;
//		printBlocks();
		return false;
    }
    
    private boolean checkTop(int i, int j) {
    	Block temp = this.blocks[i][j];
    	this.blocks[i][j] = this.blocks[i-1][j];
		this.blocks[i-1][j] = temp;
//		printBlocks();
		//return [INSERT CHECK VALID FUNCTION]
		
		//swap back
		this.blocks[i-1][j] = this.blocks[i][j];
		this.blocks[i][j] = temp;
//		printBlocks();
		return false;
    }
    
    
    
    private boolean checkAvailableMoves() {
    	
    	for (int i=0; i<this.blocks.length; i++) {
    		for (int j=0; j<this.blocks[i].length;j++) {
    			System.out.println("block" + i + " " + j);
    			Block current = this.blocks[i][j];
    			if (i==0) { //top row
    				if (j==0) { //left bound
    					if (checkRight(i,j)) return true;
    					if (checkBottom(i,j)) return true;
    				} else if (j==this.blocks[i].length-1) { //right bound
    					if (checkLeft(i,j)) return true;
    					if (checkBottom(i,j)) return true;
    				} else { //middle blocks
    					if (checkLeft(i,j)) return true;
    					if (checkRight(i,j)) return true;
    					if (checkBottom(i,j)) return true;
    				}
    			}
    			else if (i==this.blocks.length-1) { //bottom row
    				if (j==0) { //left bound
    					if (checkRight(i,j)) return true;
    					if (checkTop(i,j)) return true;
    				} else if (j==this.blocks[i].length-1) { //right bound
    					if (checkLeft(i,j)) return true;
    					if (checkTop(i,j)) return true;
    				} else { //middle blocks
    					if (checkLeft(i,j)) return true;
    					if (checkRight(i,j)) return true;
    					if (checkTop(i,j)) return true;
    				}
    			} else { //middle row
    				if (j==0) {
    					if (checkRight(i,j)) return true;
    					if (checkTop(i,j)) return true;
    					checkBottom(i,j);
    				} else if (j==this.blocks[i].length-1) {
    					if (checkLeft(i,j)) return true;
    					if (checkTop(i,j)) return true;
    					if (checkBottom(i,j)) return true;
    				} else {
    					if (checkLeft(i,j)) return true;
    					if (checkRight(i,j)) return true;
    					if (checkTop(i,j)) return true;
    					if (checkBottom(i,j)) return true;
    				}
    			}
    		}
    	}
    	return false; //no available moves
    }
    
    //debugging purposes
    private void printBlocks() {
    	for (Block[] x: this.blocks) {
        	for (Block y: x) {
        		System.out.print(y.getID() + ", " );
        	}
        	System.out.println();
        }
    	System.out.println();
    }
    // Draw necessary panel
    public void drawGrid (int i, JPanel panel_88[][], int panel88Value, int panelxValue, JPanel panel) {
        panel.setBounds(panelxValue, 15, 100, 600);
        contentPane.add(panel);
        panel.setLayout(null);
        for (int j = 0; j < panel_88[i].length; j++) {
            panel_88[i][j] = new JPanel();
            panel_88[i][j].setBackground(new Color(255, 255, 255));
            panel_88[i][j].setBorder(new LineBorder(new Color(0, 0, 0), 1));
            panel_88[i][j].setBounds(0, panel88Value, 100, 100);
            panel.add(panel_88[i][j]);
            panel88Value+=100;
            //adding image onto grid
            Block myPicture = new Block();
            myPicture.setImage();
            myPicture.setCol(i);
            myPicture.setRow(j);
            Image block = myPicture.getBlockImage().getScaledInstance(panel_88[i][j].getWidth(),panel_88[i][j].getHeight(),Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(block));
//            System.out.println(myPicture.getID());
            panel_88[i][j].add(picLabel);
            
            this.blocks[j][i] = myPicture;
            
        }
    }

    // Current Version Will Ask User to Type Two Coordinates at the same time. ex: 1,4,5,5
    // The Coordinates are (1,4)(5,5)
    public void swapImage (boolean checkInput, String input) {
        // Only accept the input separate by single comma "," no space afterwords
        if (checkInput == true) {
            String[] inputNum = input.split(",");
            int numX = Integer.parseInt(inputNum[0]);
            int numY = Integer.parseInt(inputNum[1]);
            int num2X = Integer.parseInt(inputNum[2]);
            int num2Y = Integer.parseInt(inputNum[3]);

//            System.out.println(myPicture.getID());



            System.out.println(panel_88[numX][numY]);
            System.out.println(panel_88[num2X][num2Y]);
        }

    }

    public void removeBlock(int x, int y){
        Component[] componentList = panel_88[x][y].getComponents();
        for(Component c : componentList){
                if(c instanceof JLabel){
                    panel_88[x][y].remove(c);
                }
        }   
        panel_88[x][y].revalidate();
        panel_88[x][y].repaint();
    }

    private void timer(JLabel timeLabel) {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seconds > 300) {
                    timeLabel.setText("Time Over");
                    timer.stop();
                }
                seconds++;
                timeLabel.setText("" + seconds);


            }
        });

    }




    private void newGameActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Grid frame = new Grid();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}