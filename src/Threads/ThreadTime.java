package Threads;

import controller.PrincipalController;
import javafx.scene.control.Label;

public class ThreadTime extends Thread{

	private Label time;
	private PrincipalController principalCon;

	public ThreadTime(PrincipalController principalCon,Label time) {
		super();
		this.principalCon = principalCon;
		this.time = time;
	}
	
	public void run() {
		
		int x =0;
		
		while(principalCon.isCorriendo() == true) {
			try {
				ejecutarHiloCronometro(x);
				Thread.sleep(1000);
				x++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void ejecutarHiloCronometro(int numero) {
		principalCon.setSeconds(principalCon.getSeconds()+1);
		
		if(principalCon.getSeconds() > 59) {
			principalCon.setSeconds(0);
			principalCon.setMinutes(principalCon.getMinutes()+1);
		}
		
		String seg = "", min = "";
		
		if(principalCon.getSeconds() < 10) {
			seg = "0" + principalCon.getSeconds();
		}else {
			seg = "" + principalCon.getSeconds();
		}
		
		if(principalCon.getMinutes() < 3) {
			min = "0" + principalCon.getSeconds();
		}else if(principalCon.getMinutes() == 3){
			min = "03" + principalCon.getSeconds();
			principalCon.setCorriendo(false);
			principalCon.setIniciaHilo(false);
			principalCon.setMinutes(0);
			principalCon.setSeconds(0);
			Label m = new Label("00:00");
			principalCon.setTime(m);
		}
		
		String timer = min + ":" + seg;
		time.setText(timer);
	}
}
