import java.util.Scanner;
//Change StudentEscapeRoom to your name in the format LastFirstEscapeRoom****
public class SarkarBilashEscapeRoom extends EscapeRoomParent
{
    //Declare your instance variables here.                             ***
    //The furniture and/or objects in your room should be declared here
     private SarkarBilashTelevision Television;
     private SarkarBilashSafe Safe;
     private SarkarBilashCabinet Cabinet;
     private SarkarBilashVault Vault;
    
    //Default Constructor
    //YOU MUST ALSO CHANGE THE NAME OF THIS TO MATCH THE NAME OF THE CLASS  ****
    public SarkarBilashEscapeRoom()
    {
        //initialize ALL of your instance variables here.  (assign them here)****
        Television = new SarkarBilashTelevision();
        Safe = new SarkarBilashSafe();
        Cabinet = new SarkarBilashCabinet();
        Vault = new SarkarBilashVault();    
    }
    // required
    public void resetRoom()
    {
        //REinitialize ALL of your instance variables here.  (assign them here)****
        //This method will allow us to replay the room.  
        //If you have a variable that helps you determined if you solved the room, don't reset it here.
        Television = new SarkarBilashTelevision();
        Safe = new SarkarBilashSafe();
        Cabinet = new SarkarBilashCabinet();
        Vault = new SarkarBilashVault();   
    }
    
    // required
    public String getRoomName()
    {
        return "Bilash Sarkar"; //change to YOUR full name, for example: John Smith ****
    } // end getRoomName
    
    // required
    public boolean isSolved()//****
    {
        //This method must be written but you should do it last.  This should return true when the room is solved (when they win). ****
        return false;  
    } // end isSolved
    
    // required
    public void startRoom()
    {
        //THIS IS WHERE MOST OF YOUR CODE WILL GO.  After you wrote the constructor and getRoomName() you should write code here. ****
        // declare any local variables that you may need here,
          String command;
          String verb;
          String noun;
          int spacePos;
          
        
        // Initialize the scanner object so we can get player input
        Scanner inScanner = new Scanner(System.in);
        
        // required - print some kind of welcome message.
        System.out.println("Welcome to " + getRoomName() + "'s Escape Room.  Good luck!!!");
        System.out.println("You are citizen on New York City and in the middle of the covid-19 pandemic. You have the corona virus and the cure is in this roomn.\nYou can only enter 1 or 2 word commands.");
        System.out.println("Type \"help\" if you would like to know what commands you could give.");
        
        boolean gameOver = false;
        // required - when starting room, perform the look command
        look();
        System.out.println("=========================================");
        
        // Write the while loop here continuously asking the user for input.
        while(!gameOver)
        {
            System.out.println("=========================================");
            System.out.println("Please enter a command:");
            
            command = inScanner.nextLine();
            
            spacePos = command.indexOf(" ");
            
            if(spacePos != -1)
            {
                verb = command.substring(0,spacePos);
                noun = command.substring(spacePos +1);
            }
            else
            {
                verb = command;
                noun = "";
            }
            
            //checking what the command is
            if(verb.equals("quit"))
            {
                gameOver = true;
                
            }
            else if(verb.equals("look"))
            {
                
                System.out.println("In this room there is a television, safe, cabinet, and vault.");
            }
            else if(verb.equals("help"))
            {
                System.out.println("Commands that may be used: quit, look, help, examine ObjectName,\nturn on, punch tv, power on, enter code,\nopen,take key, unlock cabinet, take paper,\nrelease vault, and take cure");
            }
            else if((verb.equals("examine")) && noun.equals("television"))
            {
                Television.examine();
            }
            else if(verb.equals("examine") && noun.equals("safe"))
            {
                Safe.examine();
            }
            else if(verb.equals("examine") && noun.equals("cabinet"))
            {
                Cabinet.examine();
            }
            else if(verb.equals("examine") && noun.equals("vault"))
            {
                Vault.examine();
            }
            else if(verb.equals("turn") && noun.equals("on"))
            {
                Television.turnOn();
            }
            else if(verb.equals("punch") && noun.equals("tv"))
            {
                Television.punchTV();
                gameOver = true;
            }
            else if(verb.equals("power") && noun.equals("on"))
            {
                Safe.powerOn();
            }
            else if(verb.equals("enter") && noun.equals("code"))
            {
                Safe.numCode();
            }
            else if(verb.equals("open"))
            {
                Safe.open();
            }
            else if(verb.equals("take") && noun.equals("key"))
            {
                Safe.takeKey();
            }
            else if(verb.equals("unlock") && noun.equals("cabinet"))
            {
                Cabinet.openCabinet(Safe);
            }
            else if(verb.equals("take") && noun.equals("paper"))
            {
                Cabinet.takeCode();
            }
            else if(verb.equals("release") && noun.equals("vault"))
            {
                Vault.openVault();
            }
            else if(verb.equals("take") && noun.equals("cure"))
            {
                Vault.takeCure();
                gameOver=true;
            }
            else
                System.out.println("I can't do that!");
                
                
         
        }
        System.out.println("Thanks for playing!");
       
        
        
        //Code below should NOT be in the loop.
        // required - when room is finished, either solved or quit, call this method.
        resetRoom();
        leaveRoom();
    } // end startRoom
    
    //You must write the look method
    public void look()
    {
        System.out.println("In this room there is a television, safe, cabinet, and vault.");  //Write what you want to happen when the user looks around ****
    }
    //Feel free to write more NON static methods to help you organize your code.
    
    
} // end class StudentEscapeRoom
