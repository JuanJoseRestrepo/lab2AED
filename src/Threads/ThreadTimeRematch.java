package Threads;

import controller.PrincipalController;
import javafx.application.Platform;

public class ThreadTimeRematch extends Thread {

	private boolean iniciaHilo = true;
	private boolean corriendo = false;
	private int seconds = 0;
	private int minutes = 0;
	
	private PrincipalController principalCon;

	public ThreadTimeRematch(PrincipalController principalCon) {
		super();
		this.principalCon = principalCon;
		setDaemon(true);
	}
	
	 
	
	public boolean isCorriendo() {
		return corriendo;
	}



	public void setCorriendo(boolean corriendo) {
		this.corriendo = corriendo;
	}



	public boolean isIniciaHilo() {
		return iniciaHilo;
	}



	public void setIniciaHilo(boolean iniciaHilo) {
		this.iniciaHilo = iniciaHilo;
	}



	public void run() {
		
		if(principalCon.isTf() == true) {
			principalCon.setTf(false);	
		}
		while(iniciaHilo && !principalCon.isTf()) {
			corriendo = true;
			String msj = "";
			ejecutarHiloCronometro();
			
			if(seconds < 10) {
			 msj =  "0"+ minutes + ":" + "0" + seconds;
			}else {
			 msj =  "0"+ minutes + ":" + seconds;
			}
			ThreadUpdateTimeRematch timer1 = new ThreadUpdateTimeRematch(msj,principalCon);
			Platform.runLater(timer1);
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
		}

		
		System.out.println("Holasdasd");
		ThreadFinishRematch m1 = new ThreadFinishRematch(principalCon);
		m1.start();
		
			 
	}
 
	public void ejecutarHiloCronometro() {
		seconds++;
		
		if(seconds > 59) {
			seconds = 00;
			minutes++;
		}
	 
		if(minutes == 3){
			corriendo =false;
			iniciaHilo = false;
			minutes = 00;
			seconds = 00;
			principalCon.setTf(false);
		}

	}
	
}
