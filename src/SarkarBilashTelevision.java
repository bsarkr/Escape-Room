import javax.swing.JOptionPane;
public class SarkarBilashTelevision
{
    private boolean isOn;
    private boolean hasCode;
    
    public SarkarBilashTelevision()
    //step 1
    {
        isOn = false;
        hasCode = false;
        
    }
    
    //step 3
    public String toString()
    {
        if(isOn==false)
          return "The television is off\nYou do not have the code";
        else
            return "The television is on";
                  
    }
    
    //step 4 
    public boolean getIsOn()
    {
        return isOn;
    }
    
    public boolean getHasCode()
    {
        return hasCode;
    }
            
    
    //step 5 intresting methods
    public void turnOn()
    {
        if(isOn==true)
            System.out.println("The safe television is already on");
        else
        {
            System.out.println("The television is now on");
            isOn=true; 
        }
      
    }
            
    public void examine()
    {
        if(isOn==true)
        {
            hasCode = true;
            System.out.println("On the top left it is playing the lyrics for All Star by Smash Mouth\nOn the top right \"The Room\" staring Tommy Wiseau is playing \nOn the bottom left is a portrait of Mr.Surial \nOn the bottom right is a unknown word \"ǝɔuǝᴉɔSɹǝʇndɯoƆ\"");
            //^^THIS IS A NOTE FOR YOU MR.SURIAL ---> the unknown word is ComputerScience upside-down 
        }
        else
            System.out.println("There is a retro style televisoin from the 1990's that seems to be off");
        
    }
    
    public void punchTV() 
    {
        isOn=false; //makes it not possible to continue
        System.out.println("There is a huge gaping hole in the middle of the tv.\noh... the entire front panel came off ");
        System.out.println("Mission Failed. We'll get em next time.");
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}