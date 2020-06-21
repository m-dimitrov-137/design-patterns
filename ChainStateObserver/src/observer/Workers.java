package observer;

public class Workers implements Observer {

	private String name;
	
	@Override
	public void update(Observable employee) {
		if(employee.getUpdate() == null) {
			System.out.println("No state");
			return;
		}
		
		if(employee.getUpdate().equals("PREPARING_SHIPMENT"))
		{
			System.out.println(this.getName() + " got package from " + 
							   employee.getName() + " and is headed to the storage.");
			employee.getState().resetState(employee);		
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
