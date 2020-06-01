  
package MediatorAndFactory;

public class Main {

	public static void main(String[] args) {
		Factory factory = new MainFactory();
		User firstUser = factory.createUser("Miro");
		User secondUser = factory.createUser("Valeri");
		User thirdUser = factory.createUser("Angel");
		User anotherUser = factory.createUser("Elena");

		ChatRoom.AddUser(firstUser);
		ChatRoom.AddUser(secondUser);
		ChatRoom.AddUser(thirdUser);
		
		firstUser.sendMessage("My name is Miroslav!");
		secondUser.sendMessage("Hi Miro!");
		thirdUser.sendMessage("Hi Miro!");

		anotherUser.sendMessage("Hi!");
		
		firstUser.sendMessage("Do u guys love cats?");
		secondUser.sendMessage("addBot");
		thirdUser.sendMessage("Yeah cats are great, I have a cat at home!");
		thirdUser.sendMessage("another message!");

	}

}