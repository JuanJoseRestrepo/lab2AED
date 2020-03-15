package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import Threads.ThreadTime;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Dealer;

public class PrincipalController implements Initializable{

	@FXML
	private Label principal;
	@FXML
	private ImageView gift;
	@FXML
	private ImageView hipodrome;
	@FXML
	private VBox scoreInicial;
	@FXML
	private VBox scoreFinal;
	@FXML
	private Label time;
	@FXML
	private Button ramdom;
	
	private boolean iniciaHilo = false;
	private boolean corriendo = false;
	
	private Dealer dealer;
	

	private int seconds = 0;
	private int minutes = 0;
	
	
	public Label getTime() {
		return time;
	}

	public void setTime(Label time) {
		this.time = time;
	}
	
	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public boolean isIniciaHilo() {
		return iniciaHilo;
	}

	public void setIniciaHilo(boolean iniciaHilo) {
		this.iniciaHilo = iniciaHilo;
	}

	public boolean isCorriendo() {
		return corriendo;
	}

	public void setCorriendo(boolean corriendo) {
		this.corriendo = corriendo;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		time.setText("00:00");
		dealer = new Dealer();
		Image i = new Image("/controller/horseRun.gif",1400,300,false,false);
		Image o = new Image("/controller/horseHipodromo.jpg",2400,820,true,true);
		gift.setImage(i);
		hipodrome.setImage(o);
	//	scoreInicial.setSpacing(5);
	//	scoreInicial.setAlignment(Pos.CENTER);
		
	//	Label m = new Label("Carrera Inicial");
	//	scoreInicial.getChildren().add(m);
		
	//	for(int j = 0; j < dealer.getHorsesNames().size();j++) {
	//		Label aux = new Label(dealer.getHorsesNames().get(j));
	//		scoreInicial.getChildren().add(aux);
	//	}
		
	}
	
	public void ramdomTest(ActionEvent e) {
		
		if(corriendo == false) {
			iniciaHilo = true;
			corriendo = true;
			beginMethodTime();
		}
		
	}
	
	private void beginMethodTime() {
		
		if(iniciaHilo == true) {
			ThreadTime t = new ThreadTime(this,time);
			t.start();
		}
		
	}

	public void finishRace(ActionEvent e) {
		
	}

}
