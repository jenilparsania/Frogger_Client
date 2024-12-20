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
	private JLabel[] logLabels;
	private JLabel[] logLabels1;
	private JLabel[] logLabels2;
	
	//variables to process our incoming socket data
	private Scanner in;
	private PrintWriter out;
	
	public ClientService() {
		
	}
	
	// implement score as of the class 
	
	public ClientService(Socket s , Frog frog, JButton startButton,JButton saveButton , JLabel frogLabel, Car cars[], Car cars2[],  Car cars1[], Log logs[],Log logs1[],Log logs2[],JLabel[] carLabels, JLabel[] carLabels1, JLabel[] carLabels2 , JLabel[] logLabels, JLabel[] logLabels1,JLabel[] logLabels2) {
		
		this.s = s;
		this.frog = frog;
		this.frogLabel = frogLabel;
		this.startButton = startButton;
		this.saveButton = saveButton;
		this.cars = cars;
		this.cars2 = cars2;
		this.cars1 = cars1;
		this.logs = logs;
		this.logs2 = logs2;
		this.logs1 = logs1;
		this.carLabels = carLabels;
		this.carLabels1 = carLabels1;
		this.carLabels2 = carLabels2;
		this.logLabels = logLabels;
		this.logLabels2 = logLabels2;
		this.logLabels1 = logLabels1;
		
		
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
		
		if(command.equals("LOGDATA")) {
			int x1 , y1 , x2,y2, x3 , y3 , x4, y4= 0;
			int x5 , y5 , x6,y6, x7 , y7 , x8, y8= 0;
			int x9 , y9 , x10,y10, x11 , y11 , x12, y12= 0;
			
			x1 = in.nextInt();
			y1 = in.nextInt();
			logs[0].setX(x1);
			logs[0].setY(y1);
			logs[0].setMoving(true);
			logs[0].setDirection(true);
			logLabels[0].setLocation(logs[0].getX(), logs[0].getY());
			
			x2 = in.nextInt();
			y2 = in.nextInt();
			logs[1].setX(x2);
			logs[1].setY(y2);
			logs[1].setMoving(true);
			logs[1].setDirection(true);
			logLabels[1].setLocation(logs[1].getX(), logs[1].getY());
			
			x3 = in.nextInt();
			y3 = in.nextInt();
			logs[2].setX(x3);
			logs[2].setY(y3);
			logs[2].setMoving(true);
			logs[2].setDirection(true);
			logLabels[2].setLocation(logs[2].getX(), logs[2].getY());
			
			x4 = in.nextInt();
			y4 = in.nextInt();
			logs[3].setX(x4);
			logs[3].setY(y4);
			logs[3].setMoving(true);
			logs[3].setDirection(true);
			logLabels[3].setLocation(logs[3].getX(), logs[3].getY());
			
			x5 = in.nextInt();
			y5 = in.nextInt();
			logs1[0].setX(x5);
			logs1[0].setY(y5);
			logs1[0].setMoving(true);
			logs1[0].setDirection(true);
			logLabels1[0].setLocation(logs1[0].getX(), logs1[0].getY());

			x6 = in.nextInt();
			y6 = in.nextInt();
			logs1[1].setX(x6);
			logs1[1].setY(y6);
			logs1[1].setMoving(true);
			logs1[1].setDirection(true);
			logLabels1[1].setLocation(logs1[1].getX(), logs1[1].getY());

			x7 = in.nextInt();
			y7 = in.nextInt();
			logs1[2].setX(x7);
			logs1[2].setY(y7);
			logs1[2].setMoving(true);
			logs1[2].setDirection(true);
			logLabels1[2].setLocation(logs1[2].getX(), logs1[2].getY());

			x8 = in.nextInt();
			y8 = in.nextInt();
			logs1[3].setX(x8);
			logs1[3].setY(y8);
			logs1[3].setMoving(true);
			logs1[3].setDirection(true);
			logLabels1[3].setLocation(logs1[3].getX(), logs1[3].getY());

			x9 = in.nextInt();
			y9 = in.nextInt();
			logs2[0].setX(x9);
			logs2[0].setY(y9);
			logs2[0].setMoving(true);
			logs2[0].setDirection(true);
			logLabels2[0].setLocation(logs2[0].getX(), logs2[0].getY());

			x10 = in.nextInt();
			y10 = in.nextInt();
			logs2[1].setX(x10);
			logs2[1].setY(y10);
			logs2[1].setMoving(true);
			logs2[1].setDirection(true);
			logLabels2[1].setLocation(logs2[1].getX(), logs2[1].getY());

			x11 = in.nextInt();
			y11 = in.nextInt();
			logs2[2].setX(x11);
			logs2[2].setY(y11);
			logs2[2].setMoving(true);
			logs2[2].setDirection(true);
			logLabels2[2].setLocation(logs2[2].getX(), logs2[2].getY());

			x12 = in.nextInt();
			y12 = in.nextInt();
			logs2[3].setX(x12);
			logs2[3].setY(y12);
			logs2[3].setMoving(true);
			logs2[3].setDirection(true);
			logLabels2[3].setLocation(logs2[3].getX(), logs2[3].getY());
			
			
			return ;
		}else if(command.equals("STARTGAME")) {
			// loop through and start cars and logs moving 
			
			
			
			return ;
			
		}else if(command.equals("CARDATA")) {
			
			int x1 , y1 , x2,y2, x3 , y3 , x4, y4= 0;
			int x5 , y5 , x6,y6, x7 , y7 , x8, y8= 0;
			int x9 , y9 , x10,y10, x11 , y11 , x12, y12= 0;
			String moving = "true";
			
			 x1 = in.nextInt();  
			 y1 = in.nextInt(); 
			// moving = in.next(); // first car's moving
			cars[0].setX(x1);
			cars[0].setY(y1);
			cars[0].setMoving(true);
			carLabels[0].setLocation(cars[0].getX(), cars[0].getY());
			
			 x2 = in.nextInt();  
			 y2 = in.nextInt(); 
			cars[1].setX(x2);
			cars[1].setY(y2);
			cars[1].setMoving(true);
			carLabels[1].setLocation(cars[1].getX(), cars[1].getY());
			
			x3 = in.nextInt();  
			 y3 = in.nextInt(); 
			cars[2].setX(x3);
			cars[2].setY(y3);
			cars[2].setMoving(true);
			carLabels[2].setLocation(cars[2].getX(), cars[2].getY());
			
			x4 = in.nextInt();  
			y4 = in.nextInt(); 
			cars[3].setX(x4);
			cars[3].setY(y4);
			cars[3].setMoving(true);
			carLabels[3].setLocation(cars[3].getX(), cars[3].getY());
			
			
			
			x5 = in.nextInt();  
			y5 = in.nextInt(); 
			cars1[0].setX(x5);
			cars1[0].setY(y5);
			cars1[0].setMoving(true);
			carLabels1[0].setLocation(cars1[0].getX(), cars1[0].getY());
			
			x6 = in.nextInt();  
			y6 = in.nextInt(); 
			cars1[1].setX(x6);
			cars1[1].setY(y6);
			cars1[1].setMoving(true);
			carLabels1[1].setLocation(cars1[1].getX(), cars1[1].getY());
			
			x7 = in.nextInt();  
			y7 = in.nextInt(); 
			cars1[2].setX(x7);
			cars1[2].setY(y7);
			cars1[2].setMoving(true);
			carLabels1[2].setLocation(cars1[2].getX(), cars1[2].getY());
			
			x8 = in.nextInt();  
			y8 = in.nextInt(); 
			cars1[3].setX(x8);
			cars1[3].setY(y8);
			cars1[3].setMoving(true);
			carLabels1[3].setLocation(cars1[3].getX(), cars1[3].getY());
			
			x9 = in.nextInt();  
			y9 = in.nextInt(); 
			cars2[0].setX(x9);
			cars2[0].setY(y9);
			cars2[0].setMoving(true);
			carLabels2[0].setLocation(cars2[0].getX(), cars2[0].getY());

			x10 = in.nextInt();  
			y10 = in.nextInt(); 
			cars2[1].setX(x10);
			cars2[1].setY(y10);
			cars2[1].setMoving(true);
			carLabels2[1].setLocation(cars2[1].getX(), cars2[1].getY());

			x11 = in.nextInt();  
			y11 = in.nextInt(); 
			cars2[2].setX(x11);
			cars2[2].setY(y11);
			cars2[2].setMoving(true);
			carLabels2[2].setLocation(cars2[2].getX(), cars2[2].getY());

			x12= in.nextInt();  
			y12= in.nextInt(); 
			cars2[3].setX(x12);
			cars2[3].setY(y12);
			cars2[3].setMoving(true);
			carLabels2[3].setLocation(cars2[3].getX(), cars2[3].getY());
			
			
			return ;
		
		}else if(command.equals("FROGPOSITION")) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			frog.setX(x);
			frog.setY(y);
			
			
			frogLabel.setLocation(frog.getX(), frog.getY());
			
			return;
		}else if(command.equals("COLLISIONSDETECTED")) {
			
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
