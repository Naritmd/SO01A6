package controller;
import java.util.concurrent.Semaphore;
import java.util.Set;
import java.util.HashSet;

public class Ex1Controller extends Thread
{
	private Semaphore Semaforo;
	private int Cavaleiro;
	private static boolean tocha = true;
	private static boolean pedra = true;
	private static Set<Integer> PortasEscolhidas = new HashSet <> ();
	private static int PortaSaida = (int) ((Math.random() * 4) +1);
	
	public Ex1Controller (Semaphore Semaforo, int Cavaleiro)
	{
		this.Semaforo = Semaforo;
		this.Cavaleiro = Cavaleiro;
	}
	
	@Override
	public void run ()
	{
		caminhar();
		
		try 
		{
			Semaforo.acquire();
			EscolherPorta();			
		}	catch (InterruptedException e) {
				System.err.println(e.getMessage());
		}	finally {
				Semaforo.release();
		}
		
	
	
	}

	private void caminhar() {

		int distancia = 0;
		while (distancia < 2000)
		{
			try {
				sleep(50);
				int Caminhar = (int) ((Math.random() * 5) + 2);
				distancia += Caminhar;
				if (distancia >= 500 && tocha == true) {
					tocha ();
				} if (distancia >= 1500 && pedra == true) {
					pedra ();
				}	
				
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
				System.out.println("Cavaleiro #" + Cavaleiro + " andou " + distancia + " m." );
		}
		
	}

	private void EscolherPorta() {
		int PortaEscolhida;
		do {
			PortaEscolhida= (int) ((Math.random() * 4) +1);
		} while (PortasEscolhidas.contains(PortaEscolhida));
			PortasEscolhidas.add(PortaEscolhida);
			if (PortaEscolhida == PortaSaida) {
				System.out.println("Cavaleiro # " + Cavaleiro + " escolhei a porta segura # " + PortaSaida + " e saiu seguro.");
			}
		
		
	}
	
	private void tocha() {
		try {
			Semaforo.acquire();
			System.out.println("Cavaleiro #" + Cavaleiro + " pegou a tocha.");
			tocha = false; 
		} catch (InterruptedException e) {
				System.err.println(e.getMessage());
		} finally {
			Semaforo.release();
		}
	}
	
	private void pedra() {
		try {
			Semaforo.acquire();
			System.out.println("Cavaleiro #" + Cavaleiro + " pegou a pedra");
			pedra = false;
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			Semaforo.release();
		}
	}
	
}
