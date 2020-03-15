package Threads;

import controller.PrincipalController;
import javafx.application.Platform;

public class ThreadFinish extends Thread {

	private PrincipalController m ;

	public ThreadFinish(PrincipalController m) {
		super();
		this.m = m;
	}
	
	public void run() {
		Runnable win = new Runnable() {

			@Override
			public void run() {
				m.finishRace();
			}	
		};
			
			Platform.runLater(win);
	}
	
}
