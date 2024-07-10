
import uk.ac.leedsbeckett.oop.LBUGraphics;

public class Main extends LBUGraphics
{
        public static void main(String[] args)
        {
                new Main();                 
        }

        public Main()
        {
        	GraphicsSystem go = new GraphicsSystem();
        }
        
    
        
        public void processCommand(String command)      //this method must be provided because LBUGraphics will call it when it's JTextField is used
        {
        	
        }
        
}
