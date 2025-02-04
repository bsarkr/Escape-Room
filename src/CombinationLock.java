import javax.swing.JOptionPane;

// required - must use this class at least once
public class CombinationLock
{
    private String combination = "";
    private boolean openFlag = false;
    private String lastTriedCombination;
    
    /**
     * Parameterized constructor-
     * This allows you to set the combo to open the lock.  
     * The format of the combination must be ##-##-##
     */
    public CombinationLock(String argCombination)
    {
        // Set the combination.
        combination = argCombination;
        
        // Reset the last tried combination.
        lastTriedCombination = "00-00-00";
    } // end constructor
    
    // This method will lock the combination lock
    public void lock()
    {
        openFlag = false;
    } // end lock
    
    // This method will unlock the combination lock.  
    // ****THIS IS THE METHOD THAT YOU MUST CALL TO OPEN THE LOCK***
    public boolean unlock()
    {
        // If the lock is already open, nothing should be done.
        if (openFlag) 
            return openFlag;
        
        // Prompt the player for the combination
        String enteredCombination = JOptionPane.showInputDialog("Enter the combination (##-##-##)");
        
        // Save the combination.
        lastTriedCombination = enteredCombination;
        
        // Check if the combination is correct
        if (enteredCombination.equals(combination))
        {
            // The combination is correct.
            openFlag = true;
        }
        
        // Return the status of the lock.
        return openFlag;
    } // end unlock
    
    // This method will return the status of the lock.
    // TRUE if unlocked, FALSE if locked.
    public boolean isUnlocked()
    {
        return openFlag;
    } // end isUnlocked
    
    // This method will return the last combination that was tried.
    public String getLastTriedCombination()
    {
        return lastTriedCombination;
    } // end getLastTriedCombination
    
    // This method resets the lock to its starting state.
    public void initialize()
    {
        openFlag = false;
        lastTriedCombination = "00-00-00";
    } // end initialize
} // end class CombinationLock
