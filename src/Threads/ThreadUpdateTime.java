package Threads;

import controller.PrincipalController;

public class ThreadUpdateTime extends Thread {

	private String msj;
	private PrincipalController m;
	
	public ThreadUpdateTime(String msj, PrincipalController m) {
		super();
		this.msj = msj;
		this.m = m;
	}
	
	public void run() {
		m.updateTime(msj);
	}
	
}
