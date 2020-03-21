package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;

import com.sun.javafx.logging.Logger;

import Threads.ThreadTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
	
	private boolean tf1 = false;
	
	
	
	public boolean isTf1() {
		return tf1;
	}

	public void setTf1(boolean tf1) {
		this.tf1 = tf1;
	}

	public <T extends Dialog<?>> void setCss(T dialog) {
		
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		dialogPane.getStyleClass().add("dialog");
		Stage stage = (Stage) dialogPane.getScene().getWindow();
		stage.getIcons().add(new Image("file:med/Logo.png"));
	}
	
	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

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
		dealer = new Dealer();
		time.setText("00:00");
		scoreInicial.setSpacing(3);
		scoreInicial.setAlignment(Pos.CENTER);
		scoreFinal.setSpacing(3);
		scoreFinal.setAlignment(Pos.CENTER);
		Image i = new Image("/controller/horseRun.gif",1400,300,false,false);
		Image o = new Image("/controller/horseHipodromo.jpg",2400,820,true,true);
		gift.setImage(i);
		hipodrome.setImage(o);
		Label m4 = new Label("ROW - HORSE NAME");
		scoreInicial.getChildren().add(m4);
		
		searchBet.setDisable(true);
		rematch.setDisable(true);
		addBet.setDisable(true);

	}
	

	public void addHorse(ActionEvent e) {
		
		
		if(!scoreInicial.getChildren().isEmpty()) {
			scoreInicial.getChildren().clear();
			scoreFinal.getChildren().clear();
		}
	
		Dialog<Horse> dialog = new Dialog<>();
		dialog.setTitle("");
		dialog.setHeaderText("Please type the horseman's name and the horse's \n name in order to register the horse for the race");
		dialog.setResizable(false);
		 
		Label label1 = new Label("Horseman's name: ");
		Label label2 = new Label("Horse's name: ");
		TextField text1 = new TextField();
		TextField text2 = new TextField();
		         
		GridPane grid = new GridPane();
		grid.add(label1, 1, 1);
		grid.add(text1, 2, 1);
		grid.add(label2, 1, 2);
		grid.add(text2, 2, 2);
		dialog.getDialogPane().setContent(grid);
		
		ButtonType buttonTypeOk = new ButtonType("Accept", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		
		dialog.setResultConverter(new Callback<ButtonType, Horse>() {
		    @Override
		    public Horse call(ButtonType b) {
		 
		        if (b == buttonTypeOk) {
		        	if(!text1.getText().isEmpty() && !text2.getText().isEmpty()) {
		        	Horse m2;	
		            return m2 = new Horse(text1.getText(), text2.getText());
		        	}else {
		    			Alert gameOver = new Alert(AlertType.INFORMATION);
		    			gameOver.setTitle("Game Over!");
		    			gameOver.setHeaderText("No puedes poner el puntaje vacio!");
		    			gameOver.setContentText(
		    					"Perdiste!!! Noooooooo");
		    			gameOver.showAndWait();
		        	}
		        }
		 
		        return null;
		    }
		});
		setCss(dialog);
		Optional<Horse> m1 = dialog.showAndWait();
		
		if(m1.isPresent()) {

				dealer.addHorseQueue(m1.get());
				
				if(dealer.getHorsesNames().size() <= 10) {
					
				dealer.getHorsesNames().add(m1.get().getHorseName());
				}
				
				Label m = new Label("ROW - HORSE NAME");
				scoreInicial.getChildren().add(m);
					
				int row =1;
				for(int j = 0; j < dealer.getHorsesNames().size();j++) {
					Label aux = new Label(row+" - "+dealer.getHorsesNames().get(j));
					scoreInicial.getChildren().add(aux);
					++row;
				}
					 
				 
				if(dealer.getHorses().size() == 7) {
				beginMethodTime();
					System.out.println("Entre aqui hptass");
				
			}else if(dealer.getHorses().size() >= 10) {
    			Alert gameOver = new Alert(AlertType.INFORMATION);
    			gameOver.setTitle("Game Over!");
    			gameOver.setHeaderText("No puedes poner el puntaje vacio!");
    			gameOver.setContentText(
    					"Perdiste!!! Noooooooo");
    			gameOver.showAndWait();
			}
				searchBet.setDisable(false);
				rematch.setDisable(false);
				addBet.setDisable(false);
				
			System.out.println("Si");
			System.out.println(dealer.getHorses().size());
		}else {
			Label m4 = new Label("ROW - HORSE NAME");
			scoreInicial.getChildren().add(m4);
			int row =1;
			for(int j = 0; j < dealer.getHorsesNames().size();j++) {
				Label aux = new Label(row+" - "+dealer.getHorsesNames().get(j));
				scoreInicial.getChildren().add(aux);
				++row;
			}
			System.out.println("No");
		}
	}
	
	
	public void searchBet(ActionEvent e) {
		
		if(!scoreInicial.getChildren().isEmpty()) {
			scoreInicial.getChildren().clear();
			scoreFinal.getChildren().clear();
		}
		
	 
		Dialog<String> dialog = new Dialog<>();
		dialog.setTitle("");
		dialog.setHeaderText("Please type the ID linked to the bet:");
		dialog.setResizable(false);
		 
		Label label1 = new Label("ID: ");

		TextField text1 = new TextField();
		
		         
		GridPane grid = new GridPane();
		grid.add(label1, 1, 1);
		grid.add(text1, 2, 1);

		dialog.getDialogPane().setContent(grid);
		
		ButtonType buttonTypeOk = new ButtonType("Search", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		
		dialog.setResultConverter(new Callback<ButtonType, String>() {
		    @Override
		    public String call(ButtonType b) {
		 
		        if (b == buttonTypeOk) {
		        	
		        	try {
		        		int mustBeNumber = Integer.parseInt(text1.getText());
			        	
			        	if(!text1.getText().isEmpty() ) {
			        	String theKey = text1.getText();	
			            return theKey;
			        	}else {
			        		showAlert(2);
			        	}
					} catch (Exception e2) {
						showAlert(1);
					}
		        	
		        }
		 
		        return null;
		    }
		});
		setCss(dialog);
		Optional<String> m2 = dialog.showAndWait();
		
		if(m2.isPresent()) {
			User found = dealer.search4Gambler(m2.get());
			if (found != null) {
				Alert gameOver = new Alert(AlertType.INFORMATION);
    			gameOver.setTitle("Here is your bet");
    			
    			String pos = "POSITION PENDING";
    			int posHorse = found.getMyWinnerHorse().getPosition();
    			
    			String horseName = found.getMyWinnerHorse().getHorseName();
    			String row = "ROW"+found.getMyWinnerHorse().getRow()+" ";
    			
    			
    			if ( posHorse != -1) {
    				if (posHorse == 1) {
    					pos = "WINNER 1st PlACE";
					} else {
						pos = posHorse+" PLACE";
					}
					
				}
    			
    			gameOver.setHeaderText(pos+" - "+row+horseName);
    			
    			String space = " \n ";
    			gameOver.setContentText("ID: "+found.getId()+space+ "Name: "+found.getName()+space+ "Gamble : $"+found.getAmount());
    			gameOver.showAndWait();
    			//TODO
			} else {
				showAlert(3);
			}
		
		}
	
	}
	
	
	
	public void showAlert(int msg) {
		Alert gameOver = new Alert(AlertType.INFORMATION);
		gameOver.setTitle("ERROR");
		switch (msg) {
		case 1:
			gameOver.setHeaderText("Please check the ID, it must be a number!");
			break;
		case 2:
			gameOver.setHeaderText("Please check the ID, it is empty...");
			break;
		case 3:
			gameOver.setTitle("We are very sorry...");
			gameOver.setHeaderText("But we could not find any bet linked to your ID");
			break;

		default:
			break;
		}
		
		gameOver.showAndWait();
	}

	
	public void rematch() {
		//TODO
	}	
	
	public void ramdomTest(ActionEvent e) {
			//dealer = new Dealer();
		    scoreInicial.getChildren().clear();
		    scoreFinal.getChildren().clear();
			ramdom.setDisable(true);
			dealer.generateHorses();	
			beginMethodTime();
			Label m = new Label("ROW - HORSE NAME");
			scoreInicial.getChildren().add(m);
			
			int row =1;
			for(int j = 0; j < dealer.getHorsesNames().size();j++) {
				Label aux = new Label(row+" - "+dealer.getHorsesNames().get(j));
				scoreInicial.getChildren().add(aux);
				++row;
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

		Label m = new Label("PODIUM");
		scoreFinal.getChildren().add(m);	
		
		Horse[] horsesSorted = dealer.sortByPosition();
		int pos = 1;
		for(int j = 1; j < horsesSorted.length;j++) {
			Label aux = new Label(pos+". "+horsesSorted[j].getHorseName());
			scoreFinal.getChildren().add(aux);
			++pos;
		}
		
		dealer.getHorses().setFront(null);
			dealer.getHorsesNames().clear();
			ramdom.setDisable(false);
	}

} //end of class
