import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Graphics2D;

import uk.ac.leedsbeckett.oop.LBUGraphics;

public class GraphicsSystem extends LBUGraphics
{
	 int r,g,b;
	 
	 public static void main(String[] args)
	 
     {
             new GraphicsSystem(); 
     }
	 
	 public GraphicsSystem()
	 {
		 JFrame MainFrame = new JFrame(); 
		
	     MainFrame.setLayout(new FlowLayout());      
	     MainFrame.add(this);                                        
	     MainFrame.pack();                                         
	     MainFrame.setVisible(true);
	     setPreferredSize(1000,400);
	     setyPos(200);
	     setxPos(500);
	     turnLeft(90);
	     penDown();	    
	 }
	 	 
	public void processCommand(String command)
	{
		//try 
		//{
			//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Luciano Delancy\\eclipse-workspace\\data.txt", true));
			
			//File file = new File("C:\\Users\\Luciano Delancy\\eclipse-workspace\\dataSecond.txt");
			//Scanner fileReader = new Scanner(file);
			//while(fileReader.hasNextLine()) {
				//String nextcommand = fileReader.nextLine();
				//bufferedWriter.append(command);
				//bufferedWriter.newLine();
			//}
		//}catch(IOException e) {
			
		//}
		
		//File WriteFile = new File("TurtleMoves.txt");
		//FileWriter write = null;
		//BufferedWriter b1 = new BufferedWriter(write); 
		//try 
		//{
			//write = new FileWriter(WriteFile);
			//b1.write(command);
			//b1.newLine();
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
		
		//try {
		//write.close();
		//} catch (IOException e) {
		//e.printStackTrace();
		//}
		
		String words[] = command.split(" ");
		
		int disInt = 0;
		int disInt1 = 0;
		int disInt2 = 0;
		
		command = words[0];		
		
		if(words.length > 1) 
		{
			String disStr = words[1];
			try
			{
			disInt = Integer.parseInt(disStr);
			}catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(null,"Enter a number with command.","Error",JOptionPane.ERROR_MESSAGE);
				return;}
			if(words.length > 2) 
			{
				String disStr1 = words[2];
				try
				{
				disInt1 = Integer.parseInt(disStr1);
				}catch(NumberFormatException nfe){ 
					JOptionPane.showMessageDialog(null,"Enter a number with command.","Error",JOptionPane.ERROR_MESSAGE);
					return;}
				if(words.length > 3) 
				{
					try {
					String disStr2 = words[3];
					disInt2 = Integer.parseInt(disStr2);
				}catch(NumberFormatException nfe){ 
					JOptionPane.showMessageDialog(null,"Enter a number with command.","Error",JOptionPane.ERROR_MESSAGE);
					return;}
				}	
			}	
		}
		
		if (command.equalsIgnoreCase("about")) 
		{
			about();
		}else if(command.equalsIgnoreCase("turnleft")){
			if(disInt == 0){
				JOptionPane.showMessageDialog(null,"Valid command but missing parameter.","Error",JOptionPane.ERROR_MESSAGE);
				}else if ((0 <= disInt) && (disInt <= 360)){
					turnLeft(disInt);
				}else {JOptionPane.showMessageDialog(null,"Out of bounds.","Error",JOptionPane.ERROR_MESSAGE);}			
		}else if(command.equalsIgnoreCase("turnright")){
			if(disInt == 0){
				JOptionPane.showMessageDialog(null,"Valid command but missing parameter.","Error",JOptionPane.ERROR_MESSAGE);
				}else if ((0 <= disInt) && (disInt <= 360)){
					turnRight(disInt);
				}else {JOptionPane.showMessageDialog(null,"Out of bounds.","Error",JOptionPane.ERROR_MESSAGE);}					
		}else if(command.equalsIgnoreCase("forward")){
			if(disInt == 0){
				JOptionPane.showMessageDialog(null,"Valid command but missing parameter.","Error",JOptionPane.ERROR_MESSAGE);
				}else if((0 <= disInt) && (disInt <= 520)){
					forward(disInt);
				}else {JOptionPane.showMessageDialog(null,"Out of bounds.","Error",JOptionPane.ERROR_MESSAGE);}					
		}else if(command.equalsIgnoreCase("backward")){
			if(disInt == 0){
				JOptionPane.showMessageDialog(null,"Valid command but missing parameter.","Error",JOptionPane.ERROR_MESSAGE);
				}else if((0 <= disInt) && (disInt <= 520)){
					turnLeft(180);
					forward(disInt);
				}else {JOptionPane.showMessageDialog(null,"Out of bounds.","Error",JOptionPane.ERROR_MESSAGE);}		
		}else if(command.equalsIgnoreCase("penup")){
			penUp();
		}else if(command.equalsIgnoreCase("pendown")){
			penDown();
		}else if(command.equalsIgnoreCase("black")){
			setPenColour(Color.black);
		}else if(command.equalsIgnoreCase("green")){
			setPenColour(Color.green);
		}else if(command.equalsIgnoreCase("red")){
			setPenColour(Color.red);
		}else if(command.equalsIgnoreCase("white")){
			setPenColour(Color.white);
		}else if(command.equalsIgnoreCase("reset")){
			reset();
		}else if(command.equalsIgnoreCase("clear")){
			try	{
				BufferedImage ImgS = ImageIO.read(new File("C:\\Users\\Luciano Delancy\\eclipse-workspace\\Assignment\\TurtlePics.png"));
				BufferedImage ImgC = getBufferedImage();
				if (ImageCompare(ImgS,ImgC) != true) {
					JOptionPane.showMessageDialog(null,"Image is not saved.","Warning",JOptionPane.WARNING_MESSAGE);
				}			
				clear();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}else if (command.equalsIgnoreCase("pen")) {
			if((disInt == 0)&&(disInt1 == 0)&&(disInt2 == 0)) {
				JOptionPane.showMessageDialog(null,"Valid command but missing parameter.","Error",JOptionPane.ERROR_MESSAGE);
			}else if((0 >= disInt)&&(disInt <= 255)||(0 >= disInt1)&&(disInt1 <= 255)||(0 >= disInt2)&&(disInt2 <= 255)) {
				penRGB(disInt,disInt1,disInt2);
			}else {JOptionPane.showMessageDialog(null,"Out of bounds.","Error",JOptionPane.ERROR_MESSAGE);}
		} else if (command.equalsIgnoreCase("saveimage")) {
			try {					
					File file = new File("TurtlePics.png");
					ImageIO.write(getBufferedImage(), "png", file);	
				} catch (IOException e) {
					e.printStackTrace();
				}
		}else if(command.equalsIgnoreCase("savetxt")){	
			//try 
			//{
				//BufferedWriter commandWriter = new BufferedWriter(new FileWriter("savedCommands.txt"));
				//File commandHistFile = new File("commandHistory.txt");
				//Scanner fileReader = new Scanner(commandHistFile);
				//while(fileReader.hasNextLine()) {
					//String nextCommand = fileReader.nextLine();
					//commandWriter.write(nextCommand);
					//commandWriter.newLine();
			//	}
			//}catch(IOException e) {
				//e.printStackTrace();
			//}
			
			//try {
					
				//	FileWriter myWriter = new FileWriter("moveturtle.txt");					
					//myWriter.write(command+"\n");
					//myWriter.close();
								
				//}catch (IOException e) {
					//e.printStackTrace();
				//}					
		}else if(command.equalsIgnoreCase("loadimage")){
			try {
			BufferedImage ImgS = ImageIO.read(new File("C:\\Users\\Luciano Delancy\\eclipse-workspace\\Assignment\\TurtlePics.png"));
			setBufferedImage(ImgS);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else if (command.equalsIgnoreCase("loadtxt")) {	
			try {
			File file = new File("moveturtle.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader br = new BufferedReader(filereader);
			StringBuffer buffer = new StringBuffer();
			String line;
			while((line = br.readLine()) != null) {
				buffer.append(line);
				buffer.append("\n");
				processCommand(line);
			}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else if(command.equalsIgnoreCase("triangle")){
			if(disInt == 0) {
				JOptionPane.showMessageDialog(null,"Valid command but missing parameter.","Error",JOptionPane.ERROR_MESSAGE);
			}else if((0 <= disInt) && (disInt <= 520)) {
				triangle(disInt);
			}else {JOptionPane.showMessageDialog(null,"Out of bounds.","Error",JOptionPane.ERROR_MESSAGE);}
		}else if (command.equalsIgnoreCase("tri")) {
			if((disInt == 0)||(disInt1 == 0)||(disInt2 == 0)) {
				JOptionPane.showMessageDialog(null,"Valid command but missing parameter.","Error",JOptionPane.ERROR_MESSAGE);
			}else if((disInt <= 255)&&(disInt1 <= 255)&&(disInt2 <= 255)) {
			    triangleThree(disInt,disInt1,disInt2);
			}else {JOptionPane.showMessageDialog(null,"Out of bounds.","Error",JOptionPane.ERROR_MESSAGE);}
		}else if(command.equalsIgnoreCase("circle")) {
			if(disInt == 0) {
				JOptionPane.showMessageDialog(null,"Valid command but missing parameter.","Error",JOptionPane.ERROR_MESSAGE);
			}else if((0 <= disInt) && (disInt <= 520)) {
				circle(disInt);
			}else {JOptionPane.showMessageDialog(null,"Out of bounds.","Error",JOptionPane.ERROR_MESSAGE);}
		}else if(command.equalsIgnoreCase("circle2.0")) {
				if(disInt == 0) {
					JOptionPane.showMessageDialog(null,"Valid command but missing parameter.","Error",JOptionPane.ERROR_MESSAGE);
				}else if((0 <= disInt) && (disInt <= 520)) {
					circle​2(disInt);
				}else {JOptionPane.showMessageDialog(null,"Out of bounds.","Error",JOptionPane.ERROR_MESSAGE);}
		}else if(command.equalsIgnoreCase("house")) {
			if(disInt == 0) {
				JOptionPane.showMessageDialog(null,"Valid command but missing parameter.","Error",JOptionPane.ERROR_MESSAGE);
			}else if((0 <= disInt) && (disInt <= 520)) {
			int x = getxPos();
			int y = getyPos();
			triangle(disInt);
			turnRight(90);
			forward(disInt);
			turnLeft(90);
			forward(disInt);
			turnLeft(90);
			forward(disInt);
			setxPos(x+disInt/2);
			setyPos(y+disInt/2);}
		}else{JOptionPane.showMessageDialog(null,"Invalid command.","Error",JOptionPane.ERROR_MESSAGE);}
	}
	
	public void about() 
	{
		super.about();
		clearInterface();
		displayMessage("Luciano Delancy");
	}
	
	public void circle​2(int radius) 
	{
		int x = getxPos();
		int y = getyPos();
		for(int i = 0; i<360;i++) {
		 penUp();
		 forward(radius-1);
		 penDown();
		 forward(1);
		 setxPos(x);
		 setyPos(y);
		 turnLeft(1);
		 }
	}
	
	public void circle(int radius) 
	{
		int x = getxPos();
		int y = getyPos();
		Graphics2D a = getGraphics2DContext();
		a.drawOval(x, y, radius, radius);
	}
	
	public void penRGB(int r,int g,int b ) 
	{
		Color c = new Color(r, g, b);
		setPenColour(c);
	}
	
	public void triangle(int t)
	{
		turnLeft(90);
		for(int i =0; i<3;i++) 
		{
			forward(t);
			turnLeft(120);
		}
	}
	
	public void triangleThree(int a,int b, int c) 
	{
		int q = getxPos();
		int u = getyPos();
		turnRight();
		forward(100);
		turnRight(180-a);
		forward(100);
		turnRight(180-b);
		turnRight(180-c);
		drawLine(getPenColour(),getxPos(),getyPos(),q,u);
		
	}
	
	public void reset() 
	{
		super.reset();
		turnLeft(90);
		penDown();
	}
	
	boolean ImageCompare(BufferedImage Img1,BufferedImage Img2) {
	if(Img1.getWidth() == Img2.getWidth() && Img1.getHeight() == Img2.getHeight()) {
				for(int x = 0; x < Img1.getWidth(); x++) {
					for(int y = 0; y < Img1.getHeight(); y++) {
						if(Img1.getRGB(x, y) != Img2.getRGB(x, y)) {
							return false;
						}
					}
				}
			}else {	
				return false;
			}return true;
	}
}
