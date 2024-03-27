package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class ThreadAeroportPrincipal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(2);
		
		for (int i = 0 ; i < 13; i++) {
			Thread t = new ThreadAeroporto(semaforo, i);
			t.start();
		}
	}

}
