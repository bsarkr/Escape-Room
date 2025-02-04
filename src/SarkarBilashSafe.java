import javax.swing.JOptionPane;
public class SarkarBilashSafe
{
    private boolean isLocked;
    private boolean hasKey;
    private boolean isPowered;
    private boolean isOpen;
    
    public SarkarBilashSafe()
    {
        isLocked = true;
        hasKey= false;
        isPowered = false; 
        isOpen = false;
    }
    
    public String toString()
    {
        if(isPowered==false)
            return "The safe has no power \nThe safe is locked\nYou dont have the key";
        else 
            return "The power is on";
        
    }
    
    public void powerOn()
    {
        if(isPowered==true)
            System.out.println("The power is already on");
        else
        {
            isPowered=true;
            System.out.println("The safe now has power");
        }
         
    }
    
    public void numCode()
    {
        
        if(isLocked==false)
        {
            System.out.println("The safe is already unlocked");
        }
        else 
        {
            String code = JOptionPane.showInputDialog("Enter the secret code here");
        
            if(code.equals("ComputerScience"))
            {
                System.out.println("The safe has unlocked");
                isLocked=false;
            }
          
            else
                System.out.println("The secret code was incorrect!! You fool!!");
        }
    }
    
    public void open()
    {
        if(isLocked==true)
        {
            System.out.println("You cannot do that. The safe is locked.");
        }
        else if(isOpen==true)
        {
            System.out.println("The safe is already open");
        }
        else
        {
        System.out.println("The safe is now open");
        isOpen = true;
        }
        
    }
    
    public void examine()
    {
        if(isLocked==false)
            System.out.println("There is a bottle of handsanitizer, a role of toilet paper, and a very shiny key all the way in the back of the safe");
        else if(isPowered==true)
            System.out.println("There is a numlock keypad that is glowing green");
        else
            System.out.println("There is a safe with a numlock and a wallplug that is not plugged in");
  
    }
    
    public boolean takeKey()
    {
        if(hasKey==true)
        {
            System.out.println("You already have the key");
            return true;
        }
        else
        {
        if(isLocked==false)
        {
            hasKey=true;
            System.out.println("You now have the key");
            
        }
        else
            System.out.println("You do not have the key");
        return false;
        }
                 
    } 
    
    public Boolean gethasKey()
    {
        return hasKey;
    }
    
    
    
    
    
    
}
    

    
    
   
    
    
    
    
    
    
    
    
    
    
    
