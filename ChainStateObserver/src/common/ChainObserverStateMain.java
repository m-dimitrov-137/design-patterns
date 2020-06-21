package common;

import chain.CityEmployees;
import chain.CountryEmployees;
import chain.InternationalEmployees;
import observer.Workers;
import state.WaitingState;

public class ChainObserverStateMain {

	public static void main(String[] args) {
		
		Workers worker = new Workers();
		
		Employees plovdivEmployee = new CityEmployees();
		Employees bulgariaEmployee = new CountryEmployees();
		Employees internationalEmployee = new InternationalEmployees();
		
		WaitingState waitingState = new WaitingState();
		
		worker.setName("[WW]");
		plovdivEmployee.setName("[PLOVDIV]");
		bulgariaEmployee.setName("[BG]");
		internationalEmployee.setName("[INT]");

		plovdivEmployee.setNextEmployee(bulgariaEmployee);
		bulgariaEmployee.setNextEmployee(internationalEmployee);
		
		System.out.println(" Initialization \n");
		waitingState.applyState(plovdivEmployee);
		waitingState.applyState(bulgariaEmployee);
		waitingState.applyState(internationalEmployee);
		System.out.println();

		
		plovdivEmployee.subscribe(worker);
		bulgariaEmployee.subscribe(worker);
		internationalEmployee.subscribe(worker);
		
		System.out.println(" Order 1 - lvl 1 ");
		plovdivEmployee.acceptShipment(1);
		System.out.println("\n Order 2 - lvl 2 ");
		plovdivEmployee.acceptShipment(2);
		System.out.println("\n Oorder 3 - lvl 2 ");
		bulgariaEmployee.acceptShipment(2);
		System.out.println("\n Order 4 - lvl 3 ");
		plovdivEmployee.acceptShipment(3);
				
	}

}
