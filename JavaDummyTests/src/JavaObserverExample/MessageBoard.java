package JavaObserverExample;

import java.util.Observable;
import java.util.Observer;

class MessageBoard extends Observable {
	private String message;

	public String getMessage() {
		return message;
	}

	public void changeMessage(String message) {
		this.message = message;
		setChanged();
		notifyObservers(message); // Important this one notify's observers
	}

	public static void main(String[] args) {
		MessageBoard board = new MessageBoard();
		Student bob = new Student();
		Student joe = new Student();
		Student michal = new Student();

		board.addObserver(bob);
		board.addObserver(joe);
		// board.deleteObservers();
		board.addObserver(michal);
		board.changeMessage("More Homework!");
	}
}

class Student implements Observer {
	public void update(Observable o, Object arg) {
		System.out.println("Message board changed: " + arg);
	}
}