package demo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Car extends Sprite {
	// would have to look that the Boolean variables like: 
	// visible and moving 
	private Boolean moving;
	private Thread t;
	
	private JLabel carLabel;
	
	private Frog frog;
	private Log log;
	private JLabel frogLabel;
	private JLabel logLabel;
	private Log logs[];
	private Log logs1[];
	private Log logs2[];
	
	
	private JButton startButton;
	
	public void setStartButton(JButton temp) {
		startButton = temp;
		
	}
	
	public void setFrog(Frog temp) {
		frog = temp;
	}
	
	public void setFrogLabel(JLabel temp) {
		frogLabel = temp;
	}
	
	public void setLog(Log temp) {
		log = temp;
	}
	
	public void setLogLabel(JLabel temp) {
		logLabel = temp;
	}
	
	public void setCarLabel(JLabel temp) {
		this.carLabel = temp;
	}
	
	public void setLogs(Log[] temp) {
		this.logs = temp;
	}
	
	public void setLogs1(Log[] temp) {
		this.logs1 = temp;
	}
	
	public void setLogs2(Log[] temp) {
		this.logs2 = temp;
	}
	public Boolean getMoving() {
		return moving;
	}
	
	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	public Car() {
		super();
		this.moving = false;
		
	}
	
	public Car(int x, int y,int height, int width, String image) {
		super(x,y,height,width,image);
		this.moving = false;
		
	}
	
	private GamePrepClient gamePrep;
	public void setGamePrep(GamePrepClient gamePrep) {
		this.gamePrep = gamePrep;
	}
	
	
}

	
	
	




