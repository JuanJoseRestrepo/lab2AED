package controller;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Threads.ThreadTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import model.*;

import javafx.util.Callback;


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
	@FXML
	private Button addHorse;
	@FXML
	private Button addBet;
	@FXML
	private Button searchBet;
	@FXML
	private Button rematch;
	
	private Dealer dealer;
	
	private boolean tf = false;

	
	
	public Label getTime() {
		return time;
	}

	public void setTime(Label time) {
		this.time = time;
	}

	public boolean isTf() {
		return tf;
	}

	public void setTf(boolean tf) {
		this.tf = tf;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		time.setText("00:00");
		dealer = new Dealer();
		scoreInicial.setSpacing(5);
		scoreInicial.setAlignment(Pos.CENTER);
		Image i = new Image("/controller/horseRun.gif",1400,300,false,false);
		Image o = new Image("/controller/horseHipodromo.jpg",2400,820,true,true);
		gift.setImage(i);
		hipodrome.setImage(o);
	}
	

	public void addHorse() {
		Horse newHorse = new Horse("","");
		if (dealer.addHorseQueue(newHorse) == false) {
			//TODO
			//show message, horse couldnt be added
		}
	}
	
	public void addBet() {
		//TODO
		User newUser = new User(0,"",0,null);
		dealer.addGambler(newUser);
	}
	
	public void searchBet() {
		//TODO
	}
	
	public void rematch() {
		//TODO
	}	
	
	public void ramdomTest(ActionEvent e) {

			if(scoreInicial.getChildren().isEmpty() == true) {
			dealer = new Dealer();
			dealer.generateHorses();	
			beginMethodTime();
			Label m = new Label("First Race");
			scoreInicial.getChildren().add(m);
				
				for(int j = 0; j < dealer.getHorsesNames().size();j++) {
					Label aux = new Label(dealer.getHorsesNames().get(j));
					scoreInicial.getChildren().add(aux);
				}
				
			}else {
				scoreInicial.getChildren().clear();
				scoreFinal.getChildren().clear();
				
				setTf(true);
			}

	}
	
	private void beginMethodTime() {

			ThreadTime t = new ThreadTime(this);		
				t.start();	
	}

	public void updateTime(String msj) {
		
		time.setText(msj);
		
	}
	
	public void finishRace() {
		dealer.setWinners(false);
		Label m = new Label("Carrera Final");
		scoreFinal.setSpacing(5);
		scoreFinal.setAlignment(Pos.CENTER);
		scoreFinal.getChildren().add(m);
		
		for(int j = 0; j < dealer.getHorsesNames().size();j++) {
			Label aux = new Label(dealer.getHorsesNames().get(j));
			scoreFinal.getChildren().add(aux);
		}
		
	}

} //end of class
