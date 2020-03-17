package Threads;

import controller.PrincipalController;
import javafx.application.Platform;

public class ThreadFinish extends Thread {

	private PrincipalController m ;

	public ThreadFinish(PrincipalController m) {
		super();
		this.m = m;
		setDaemon(true);
		System.out.println("asdasd");
	}
	
	public void run() {

		
		
		Runnable win1 = new Runnable() {
			
			@Override
			public void run() {
				m.finishRace();
			}
			
			
		};
		
			Platform.runLater(win1);}
		
	
}
