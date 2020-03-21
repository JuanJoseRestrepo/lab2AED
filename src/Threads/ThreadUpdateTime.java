package Threads;

import controller.PrincipalController;
import javafx.application.Platform;

public class ThreadUpdateTime extends Thread {

	private String msj;
	private PrincipalController m;
	public ThreadUpdateTime(String msj, PrincipalController m) {
		super();
		this.msj = msj;
		this.m = m;
		setDaemon(true);
	}
	
	public void run() {
		
		Runnable win = new Runnable() {
			@Override
			public void run() {
				m.updateTime(msj);
			}	
		};

				Platform.runLater(win);
			
}
	
}
