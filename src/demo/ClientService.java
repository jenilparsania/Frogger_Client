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
	
	//variables to process our incoming socket data
	private Scanner in;
	private PrintWriter out;
	
	public ClientService() {
		
	}
	
	// implement score as of the class 
	
	public ClientService(Socket s , Frog frog, JButton startButton,JButton saveButton , JLabel frogLabel) {
		
		this.s = s;
		this.frog = frog;
		this.frogLabel = frogLabel;
		this.startButton = startButton;
		this.saveButton = saveButton;
		
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
			
			int x , y = 0;
			String moving = "";
			
			 x = in.nextInt();  // first car's x
			
			 y = in.nextInt(); // first car's y
			 moving = in.next(); // first car's moving
			
			cars[0].setX(x);
			cars[0].setY(y);
			if(moving.equals("true")) {
				cars[0].setMoving(true);
			}else {
				cars[0].setMoving(false);
			}
			
//			carLabels[1].setLocation(cars[1].getX(), cars[1].getY());'
			
			
			
			 x = in.nextInt();  // second car's x
				
			 y = in.nextInt(); // second car's y
			 moving = in.next(); // second car's moving
			
			cars[1].setX(x);
			cars[1].setY(y);
			if(moving.equals("true")) {
				cars[1].setMoving(true);
			}else {
				cars[1].setMoving(false);
			}
			
			
			
			
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
