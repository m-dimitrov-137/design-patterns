package common;
import java.util.ArrayList;
import java.util.List;
import observer.Observable;
import observer.Observer;
import state.Context;
import state.State;

public abstract class Employees implements Context, Observable{
	
	public static int CITY = 1;
	public static int COUNTRY = 2;
	public static int INTERNATIONAL = 3;
	protected State state;
	
	protected List<Observer> observers = new ArrayList<Observer>();
	
	protected int level;
	
	protected String name;
	
	protected Employees nextEmployee;
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void setNextEmployee(Employees nextLogger) {
		this.nextEmployee = nextLogger;
	}
	
	public void acceptShipment(int level) {
		
		System.out.println("\n Order with lvl " + level + " is being accepted by " + this.name);
		
		if(this.level >= level) {
			this.handleOrder();
		}

		else if(this.nextEmployee != null) {
			System.out.println(this.name + " couldn't handle it.");
			
			this.nextEmployee.acceptShipment(level);
		}
		
	}
	
	abstract protected void handleOrder();
	
}
