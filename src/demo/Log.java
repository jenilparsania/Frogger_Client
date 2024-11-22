package demo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Log  extends Sprite{
	private Boolean moving;
	private Boolean direction;
	private Thread t;
	private Boolean hasPassedCars;
	private JButton startButton;
	private Car car;
	private Car cars[];
	private Car cars1[];
	private Car cars2[];
	private JLabel carLabel;
	private JLabel[] carLabels;
	private JLabel logLabel;
	
	private Frog frog;
	private JLabel frogLabel;
	
	public void setStartButton(JButton temp) {
		startButton = temp;
		
	}
	
	public void setFrog(Frog temp) {
		frog = temp;
	}
	
	
	
	public void setFrogLabel(JLabel temp) {
		frogLabel = temp;
	}
	
	public void setLogLabel(JLabel temp) {
		this.logLabel = temp;
	}
	
	public Boolean getMoving() {
		return moving;
	}
	
	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	
	public void setCar(Car temp) { 
		this.car = temp;
	}
	
	public void setCarLabel(JLabel temp) { 
		this.carLabel = temp;
	}
	
	public void setCars(Car[] temp) { //could be used for array
		this.cars = temp;
	}
	
	public void setCars1(Car[] temp) { //could be used for array
		this.cars1 = temp;
	}
	
	public void setCars2(Car[] temp) { //could be used for array
		this.cars2 = temp;
	}
	
	public void setCarLabels(JLabel[] temp) { // could be used for array 
		this.carLabels = temp;
	}
	
	public Boolean getDirection() {
		return this.direction;
	}
	
	public void setDirection(boolean temp) { 
		this.direction = temp;
	}
	
	
	public Log() {
		super();
		this.moving = false;
	}
	
	public Log(int x, int y,int height, int width, String image) {
		super(x,y,height,width,image);
		this.moving = false;
		
		
	}
	private GamePrepClient gamePrep;
	public void setGamePrep(GamePrepClient gamePrep) {
		this.gamePrep = gamePrep;
	}
	
	
	
}		
	
	/*
	public void startAgain() { // as the thread is stopped frog should move again to initial phase
		frog.setX(GameProperties.x_left);
		frog.setY(GameProperties.y_left);
		frogLabel.setLocation(frog.getX(),frog.getY());
		
		
	}*/
	
	
	

	
	

			
	

