public class SarkarBilashCabinet
{
    private boolean isLocked;
    private boolean hasCode;
    
    public SarkarBilashCabinet()
    {
        isLocked = true;
        hasCode = false;
        
        
    }
    
    public String toString()
    {
        if(isLocked==false)
            return "The cabinet is unlocked and you have the key.";
        else
            return "The cabinet is LOCKED. You do not have the key.";
        
    }
    
    public void openCabinet(SarkarBilashSafe a)
    {
        if(a.gethasKey()==true)
        {
            System.out.println("The cabinet is now open.");
            isLocked = false;
        }
        else
            System.out.println("You are missing a key.");
        
        
    }
    
    public void examine()
    {
        if(isLocked==true)
        {
            System.out.println("A very nice wooden cabinet is directly infront of you. It seems to have a key hole and a handle.");
        }
        else if(hasCode==true)
        {
            System.out.println("The piece of paper has a 4 digit numerical code '2704'");
        }
        else
            System.out.println("There is a piece of paper.");
            
        
    }
    
    public boolean takeCode()
    {
        if(isLocked==false)
        {
            System.out.println("The piece of paper has a 6 digit numerical code '020704'");
            hasCode=true;
            return true;
        }
        else
        {
            System.out.println("The cabinet is locked. You cannot do this action.");
            return false;
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}