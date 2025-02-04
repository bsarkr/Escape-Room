import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EscapeRoomParent
{
    // The position and dimensions of the room
    private int xPos,yPos,width,height;
    
    // This is the info from the game board that is holding the room.
    private GameBoard gameBoard;
    private JFrame gameBoardFrame;
    private int index1,index2;

    // This method will set the dimensions of the room.
    public void setDimensions(int argX, int argY, int argWidth, int argHeight)
    {
        xPos = argX;
        yPos = argY;
        width = argWidth;
        height = argHeight;
    } // end setDimensions
    
    // This method will set the gameBoard info
    public void setGameBoardInfo(GameBoard argGameBoard, JFrame argFrame, int argIndex1, int argIndex2)
    {
        gameBoard = argGameBoard;
        gameBoardFrame = argFrame;
        index1 = argIndex1;
        index2 = argIndex2;
    } // end setGameBoard
    
    // This method will return the name of the room.
    public String getRoomName()
    {
        return "Unnamed";
    } // end getRoomName
    
    // This method will return TRUE if the room has been solved, FALSE if not.
    public boolean isSolved()
    {
        return false;
    } // end isSolved
    
    // This method will start playing the room.
    public void startRoom()
    {
        System.out.println("This room cannot be entered.");
        leaveRoom();
    } // end startRoom
    
    // This will be called by the child class when the player is leaving the room.
    public void leaveRoom()
    {
        // Tell the game board that we are leaving the current room.
        gameBoard.leaveRoom();
    } // end leaveRoom
    
    // This method will return true if the passed in mouse position in inside the boundaries of this room.
    // False otherwise.
    public boolean isClicked(int argX, int argY)
    {
        return (argX >= xPos && argX <= xPos + width && argY >= yPos && argY <= yPos + height);
    } // end isClicked
    
    public void drawSelf(Graphics g)
    {
        // Draw the rectangle
        if (isSolved())
        {
            // If the room is solved, it will be colored green
            g.setColor(Color.green);
            g.fillRect(xPos,yPos,width,height);
        }
        else
        {
            // If the room is not solved, it will grey and outlined in black.
            g.setColor(Color.black);
            g.drawRect(xPos,yPos,width,height);
        }
        
        // Draw the room name centered in the box.
        g.setColor(Color.black);
        Font messageFont = new Font("Comic Sans MS",Font.BOLD,12);
        String roomName = getRoomName();
        FontMetrics metrics = g.getFontMetrics(messageFont);
        int x = xPos + (width - metrics.stringWidth(roomName)) / 2;
        int y = yPos + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(messageFont);
        g.drawString(roomName, x, y);
    } // end drawSelf
} // end class EscapeRoomParent
