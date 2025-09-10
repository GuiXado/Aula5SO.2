package controller;

import java.util.concurrent.Semaphore;

public class Prato extends Thread{

	private int id; //= (int) threadId();
	private Semaphore mutex;
	private int tempo;
	private int inicio = 0;
	
	public Prato(int id, Semaphore mutex) {
		this.id = id;
		this.mutex = mutex;
	}
	
	public void run() {
		if (id % 2 == 0) {
			sopa();
		}else {
			lasanha();
		}
		try {
			mutex.acquire();
			entrega();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			mutex.release();
		}
	}

	private void sopa() {
		System.out.println("#"+id+" Sopa de Cebola Foi Iniciada!");
		tempo = (int)((Math.random() * 301) + 500);
		while (inicio < tempo) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
			System.out.println("#"+id+" Sopa de Cebola Cozinnhou"+tempo/100+"%");
			inicio+=100;
			}
		}
		System.out.println("#"+id+" Sopa de Cebola Foi Finalizada");
	}

	private void lasanha() {
		System.out.println("#"+id+" Lasaha Bolonhesa Foi Iniciada!");
		tempo = (int)((Math.random() * 601) + 600);
		while (inicio < tempo) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			System.out.println("#"+id+" Lasaha Bolonhesa Cozinnhou "+ (inicio * 100) / tempo +"%");
			inicio+=100;
			}
		}
		System.out.println("#"+id+" Sopa de Cebola Foi Finalizada");
	}
	
	private void entrega() {
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("#"+id+" Sopa de Cebola Entregue");			
		}

	}
}
