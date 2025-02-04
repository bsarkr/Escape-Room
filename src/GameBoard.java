import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class GameBoard extends JComponent
{
    // This is the graphical frame that will hold the game board and the room.
    JFrame gameBoardFrame;
    
    // screen dimensions
    private int screenWidth = 1350;
    private int screenHeight = 200;
    
    // Array of rooms
    private EscapeRoomParent rooms[][];
    private int roomsHorizontal = 12;
    private int roomsVertical = 3;
    
    // This will hold the indices of the current room that we are in.  Both will be -1 if we are not in a room.
    // At the start, we will not be in any room.
    private int currentRoomIndex1 = -1;
    private int currentRoomIndex2 = -1;

    // This method will initialize everything and start the game.
    private void startGame()
    {
        // Create the window that will hold the game board.
        createFrame();
        
        // Add all of the rooms to the game board.
        addRooms();
        
        // Redraw the screen.
        repaint();
    } // end startGame
    
    // This method will create the window that will hold the game board.
    private void createFrame()
    {
        // Create the game board frame
        gameBoardFrame = new JFrame();
        gameBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameBoardFrame.setTitle("Escape Room Adventure");
        gameBoardFrame.setPreferredSize(new Dimension(screenWidth, screenHeight));
        gameBoardFrame.setResizable(false);
        gameBoardFrame.getContentPane().add(this);
        gameBoardFrame.pack();
        //gameBoardFrame.setLocationRelativeTo(null);
        gameBoardFrame.setLayout(null);
        gameBoardFrame.setVisible(true);
        
        // This handles the mouse clicked event.
        gameBoardFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseClickedEvent(e.getX()-3,e.getY()-27);
            }
        });
    } // end createFrame
    
    // This method will add all of the rooms to the game board.
    private void addRooms()
    {
        int startX = 10;
        int startY = 10;
        int width = 100;
        int height = 30;
        int gap = 10;
        int xPos, yPos;
        
        // Add all of the rooms.
        rooms = new EscapeRoomParent[roomsHorizontal][roomsVertical];
        
        // Add all of the individual rooms
        rooms[0][0] = new SarkarBilashEscapeRoom();  //Change this to your room. 
        /*
        rooms[1][0] = new SurielEscapeRoom();
        rooms[2][0] = new MrSegalEscapeRoom();
        rooms[3][0] = new StudentEscapeRoom();
        rooms[4][0] = new StudentEscapeRoom();
        rooms[5][0] = new StudentEscapeRoom();
        rooms[6][0] = new StudentEscapeRoom();
        rooms[7][0] = new StudentEscapeRoom();
        rooms[8][0] = new StudentEscapeRoom();
        rooms[9][0] = new StudentEscapeRoom();
        rooms[10][0] = new StudentEscapeRoom();
        rooms[11][0] = new StudentEscapeRoom();
        
        rooms[0][1] = new StudentEscapeRoom();
        rooms[1][1] = new StudentEscapeRoom();
        rooms[2][1] = new StudentEscapeRoom();
        rooms[3][1] = new StudentEscapeRoom();
        rooms[4][1] = new StudentEscapeRoom();
        rooms[5][1] = new StudentEscapeRoom();
        rooms[6][1] = new StudentEscapeRoom();
        rooms[7][1] = new StudentEscapeRoom();
        rooms[8][1] = new StudentEscapeRoom();
        rooms[9][1] = new StudentEscapeRoom();
        rooms[10][1] = new StudentEscapeRoom();
        rooms[11][1] = new StudentEscapeRoom();
        
        rooms[0][2] = new StudentEscapeRoom();
        rooms[1][2] = new StudentEscapeRoom();
        rooms[2][2] = new StudentEscapeRoom();
        rooms[3][2] = new StudentEscapeRoom();
        rooms[4][2] = new StudentEscapeRoom();
        rooms[5][2] = new StudentEscapeRoom();
        rooms[6][2] = new StudentEscapeRoom();
        rooms[7][2] = new StudentEscapeRoom();
        rooms[8][2] = new StudentEscapeRoom();
        rooms[9][2] = new StudentEscapeRoom();
        rooms[10][2] = new StudentEscapeRoom();
        rooms[11][2] = new StudentEscapeRoom();
        */
        // Initialize all of the rooms.
        for (int i=0; i<roomsHorizontal; i++)
        {
            for (int j=0; j<roomsVertical; j++)
            {
                // Set the x,y position of the room.
                xPos = startX + (i * (width + gap));
                yPos = startY + (j * (height + gap));
                
                // Initialize the room.
                if (rooms[i][j] != null) 
                {
                    rooms[i][j].setDimensions(xPos,yPos,width,height);
                    rooms[i][j].setGameBoardInfo(this,gameBoardFrame,i,j);
                }
            }
        }
    } // end addRooms
    
    // This method will handle the mouse clicked event.
    public void mouseClickedEvent(int argX, int argY)
    {
        // If we are currently in a room, an error should be displayed
        if (currentRoomIndex1 > -1)
        {
            System.out.println("error");
            JOptionPane.showMessageDialog(null,"You must finish or quit the current room before entering a new one.");
        }
        else
        {
            // Loop through the rooms to see if any of them were clicked on.
            for (int i=0; i<roomsHorizontal; i++)
            {
                for (int j=0; j<roomsVertical; j++)
                {
                    if (rooms[i][j] != null && rooms[i][j].isClicked(argX,argY))
                    {
                        // Check if the room has been solved.
                        if (rooms[i][j].isSolved())
                        {
                            JOptionPane.showMessageDialog(null,"This room has already been solved.");
                        }
                        else
                        {
                            enterRoom(i,j);
                        }
                        
                        // We don't need to check any other rooms.
                        return;
                    }
                }
            }
        }
    } // end mouseClicked
    
    public void enterRoom(int argIndex1,int argIndex2)
    {
        // Set the current room.
        currentRoomIndex1 = argIndex1;
        currentRoomIndex2 = argIndex2;
        
        // Hide the room selection frame.
        gameBoardFrame.setVisible(false);
        
        // Start the room
        rooms[currentRoomIndex1][currentRoomIndex2].startRoom();
    } // end enterRoom
    
    public void leaveRoom()
    {
        // Reset the variables that track the current room we are in.
        currentRoomIndex1 = -1;
        currentRoomIndex2 = -1;
        
        // Show the room selection frame.
        gameBoardFrame.setVisible(true);
        
        // Redraw the frame
        repaint();
    } // end leaveRoom
    
    @Override
    public void paintComponent(Graphics g)
    {
        // Draw the game board
        drawSelf(g);
    } // end paintComponent
    
    private void drawSelf(Graphics g)
    {
        // Draw all of the rooms.  If we are currently in a room, display the room we are in.
        if (currentRoomIndex1 == -1)
        {
            for (int i=0; i<roomsHorizontal; i++)
            {
                for (int j=0; j<roomsVertical; j++)
                {
                    try
                    {
                        if (rooms[i][j] != null) rooms[i][j].drawSelf(g);
                    }
                    catch (Exception e)
                    {
                        //
                    }
                }
            }
        }
        else
        {
            g.setColor(Color.black);
            Font messageFont = new Font("Comic Sans MS",Font.BOLD,18);
            String roomName = "Welcome to " + rooms[currentRoomIndex1][currentRoomIndex2].getRoomName() + "'s Room.";
            FontMetrics metrics = g.getFontMetrics(messageFont);
            int x = (screenWidth - metrics.stringWidth(roomName)) / 2;
            int y = ((screenHeight - metrics.getHeight()) / 2) + metrics.getAscent();
            g.setFont(messageFont);
            g.drawString(roomName, x, y);
        }
    } // end drawSelf
    
   
    public static void main (String [] args)
    {
        // Instantiate the game board and start the game.
        GameBoard gameBoard = new GameBoard();
        gameBoard.startGame();

    } // end main
} // end class GameBoard
