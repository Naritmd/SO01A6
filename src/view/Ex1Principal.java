package view;
import java.util.concurrent.Semaphore;
import controller.Ex1Controller;

public class Ex1Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 1; i < 5; i++)
		{
			Thread t = new Ex1Controller (semaforo, i);
			t.start();
			
		}

	}

}
