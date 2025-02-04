public class SarkarBilashVault
{
    private boolean isLocked;
    private boolean hasCure;
    private CombinationLock code;
    
    public SarkarBilashVault()
    {
        isLocked = true;
        hasCure = false;
        code = new CombinationLock("02-07-04");
    }
    
    public String toString()
    {
        if(isLocked==true)
            return "The vault is locked and you do now have the cure";
        else
            return "The vault is open and you not have the cure";
    }
    
    public void openVault()
    {
        if(isLocked==false)
            System.out.println("The vault is already open");
        else if(code.unlock())
        {
            isLocked=false;
            System.out.println("The vault begins to unlock itself and opens slowly as a thin layer of fog creeps out the vault doors.");
        }
        else
        {
            System.out.println("INCORRECT!! get good kid...");
        }
        
       
            
    }
    
    public void examine()
    {
        if(isLocked==false)
            System.out.println("There is a thrown made purely of toilet paper and a pool of handsanitizer.\nOn the throne you see a vial or a substance named anticovid-19");
        else
            System.out.println("There is a massive vault made of gold and is locked by a combination code");
    }
    
    public void takeCure()
    {
        if(isLocked==false)
        {
            hasCure=true;
            System.out.println("Congratulation! You survived the corona virus and escaped this escape room.\nSadly this cure is a one time use only and cannot be used to help other patiants. You are pretty selfish.");
            
        }
        else
            System.out.println("sorry you cannot do that");
        
    }
    
   
    
    
    
    
    
    
    
    
}