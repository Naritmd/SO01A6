
package controller;
import java.util.concurrent.Semaphore;


public class ThreadAeroporto extends Thread {
	private Semaphore semaforo;
	private int aviao;
	
	public ThreadAeroporto(Semaphore semaforo, int aviao) {
		this.semaforo = semaforo;
		this.aviao = aviao;
		
	}
	
	@Override
	
	public void run()
	{
		manobrar();
		try {
				semaforo.acquire();
				taxiar();
				decolar();
		} catch (InterruptedException e){
				System.err.println(e.getMessage());
		} finally {
			semaforo.release();
			afastar();
		}
	}

	private void manobrar() {
		int tempo = (int) ((Math.random() * 701) + 300);
		try {
			sleep (tempo);
			System.out.println("Avi�o # " + aviao + "manobrou em " + tempo + "ms.");
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

	private void taxiar() {
		int tempo = (int) ((Math.random() * 1001) + 500);
		try {
			sleep(tempo);
			if (tempo % 2 == 0)
				System.out.println("Avi�o #" + aviao + " taxiou em " + tempo + "ms.");
		} catch (InterruptedException e){
			System.err.println(e.getMessage());
		}
		
	}

	private void decolar() {
		int tempo = (int) ((Math.random() * 801) + 600);
		try {
			sleep(tempo);
			if (tempo % 2 == 0)
				System.out.println("Avi�o #" + aviao + " decolou da pista norte.");
			else 
				System.out.println("Avi�o #" + aviao + " decolou da pista sul");
		} catch (InterruptedException e){
			System.err.println(e.getMessage());
		}
		
	}

	 private void afastar() {
		 int tempo = (int) ((Math.random() * 801) + 300);
			try {
				sleep (tempo);
				System.out.println("Avi�o # " + aviao + " se afasto em  " + tempo + "ms.");
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());		
	}
			
	}

}