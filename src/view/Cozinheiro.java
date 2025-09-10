package view;

import java.util.concurrent.Semaphore;
import controller.Prato;

public class Cozinheiro {
	
	public static void main(String[] args) {
	
		Semaphore mutex = new Semaphore(1);
		
		for (int id = 1; id < 6; id++) {
		Prato prato = new Prato(id, mutex);
			prato.start();
		}
		
	
	}
}
