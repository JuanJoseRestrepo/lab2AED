package Threads;

import controller.PrincipalController;
import javafx.application.Platform;

public class ThreadFinishRematch extends Thread{


	private PrincipalController m ;

	public ThreadFinishRematch(PrincipalController m) {
		super();
		this.m = m;
		setDaemon(true);
	}
	
	public void run() {

		
		
		Runnable win1 = new Runnable() {
			
			@Override
			public void run() {
				m.finishRaceRematch();
			}
			
			
		};
		
			Platform.runLater(win1);
	}
	
}
