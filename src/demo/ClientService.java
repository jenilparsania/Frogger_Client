package demo;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;

import demo.Car;
import demo.Frog;
import demo.GameProperties;
import demo.Log;

public class ClientService  implements Runnable{



	//declare but not initialize the passed variables from
	// BankServer (we  need to use the originals)
	private Socket s;
	// variable passing in the gamePrepServer
	final int CLIENT_PORT = 5656;
	private Car cars[];
	private Car cars1[], cars2[];
	private Log logs[], logs1[], logs2[];
	private Frog frog;
	private JLabel frogLabel;
	private JButton startButton;
	private JButton saveButton;
	private JLabel[] carLabels;
	private JLabel[] carLabels1;
	private JLabel[] carLabels2;
	
	//variables to process our incoming socket data
	private Scanner in;
	private PrintWriter out;
	
	public ClientService() {
		
	}
	
	// implement score as of the class 
	
	public ClientService(Socket s , Frog frog, JButton startButton,JButton saveButton , JLabel frogLabel, Car cars[], Car cars2[],  Car cars1[], JLabel[] carLabels, JLabel[] carLabels1, JLabel[] carLabels2) {
		
		this.s = s;
		this.frog = frog;
		this.frogLabel = frogLabel;
		this.startButton = startButton;
		this.saveButton = saveButton;
		this.cars = cars;
		this.cars2 = cars2;
		this.cars1 = cars1;
		this.carLabels = carLabels;
		this.carLabels1 = carLabels1;
		this.carLabels2 = carLabels2;
		
	}
	
	
	
	public void run() {
		
		try {
			in = new Scanner(s.getInputStream());
			
			out = new PrintWriter(s.getOutputStream());
			
			processRequest();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				s.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	private void processRequest() throws IOException {
		//need a loop to process the command tokens as they are 
		// parsed one at a time 
		while (true) {
			if(!in.hasNext()) return; // this is the line which stops us if there is not data left to parse
			
			// extract the first token (command)
			
			String command = in.next();    //in.next() gets String
			
			executeCommand(command);
			
			
			
		}
	}
	
	private void executeCommand(String command) throws   IOException {
		
		if(command.equals("MOVEFROG")) {
			//MOVEFROG UP
			//MOVEFROG DOWN
			//extract the string passed through socket
			String direction = in.next();
			
			//refer the frog moving in the game Prep project
			if(direction.equals("UP")) {
				int y = frog.getY();
				y -= GameProperties.CHARACTER_STEP;
				frog.setY(y);	
			}
			
			if(direction.equals("DOWN")) {
				int y = frog.getY();
				y+= GameProperties.CHARACTER_STEP;
				frog.setY(y);
			}
			
			if(direction.equals("LEFT")) {
				int x = frog.getX();
				x-= GameProperties.CHARACTER_STEP;
				frog.setX(x);
			}
			
			if(direction.equals("RIGHT")) {
				int x = frog.getX();
				x+= GameProperties.CHARACTER_STEP;
				frog.setX(x);
			}
			
			
			return ;
			
			
			
		
			
		}else if(command.equals("STARTGAME")) {
			// loop through and start cars and logs moving 
			
			
			
			return ;
			
		}else if(command.equals("CARDATA")) {
			
			int x1 , y1 , x2,y2, x3 , y3 , x4, y4= 0;
			String moving = "true";
			
			 x1 = in.nextInt();  // first car's x
			
			 y1 = in.nextInt(); // first car's y
			// moving = in.next(); // first car's moving
			 
			cars[0].setX(x1);
			cars[0].setY(y1);
			
			cars[0].setMoving(true);

			
			carLabels[0].setLocation(cars[0].getX(), cars[0].getY());
			
			
			 x2 = in.nextInt();  // second car's x
				
			 y2 = in.nextInt(); // second car's y
			
			
			cars[1].setX(x2);
			cars[1].setY(y2);
		
			cars[1].setMoving(true);
			
			carLabels[1].setLocation(cars[1].getX(), cars[1].getY());
			
			x3 = in.nextInt();  // second car's x
			
			 y3 = in.nextInt(); // second car's y
			
			
			cars[2].setX(x3);
			cars[2].setY(y3);
			cars[2].setMoving(true);
			carLabels[2].setLocation(cars[2].getX(), cars[2].getY());
			
			x4 = in.nextInt();  // second car's x
			
			 y4 = in.nextInt(); // second car's y
			
			
			cars[3].setX(x3);
			cars[3].setY(y3);
			cars[3].setMoving(true);
			carLabels[3].setLocation(cars[3].getX(), cars[3].getY());
			
			
			
			
			return ;
		
		}else if(command.equals("FROGPOSITION")) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			frog.setX(x);
			frog.setY(y);
			
			
			frogLabel.setLocation(frog.getX(), frog.getY());
			
			return;
		}
		
		else {
			// not a valid command
			System.out.println(command + "received");
			String outCommand = "INVALID";
			out.println(outCommand);
			out.flush();
			
			return ; 
		}
	}
	
	




}
