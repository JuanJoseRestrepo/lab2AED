package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;

import com.sun.javafx.logging.Logger;

import Threads.ThreadTime;
import Threads.ThreadTimeRematch;
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
		        	Horse m2 = new Horse(text1.getText(), text2.getText());	
		            return m2;
		        	}else {
		    			showAlert(4);
		        	}
		        }
		 
		        return null;
		    }
		});
		setCss(dialog);
		Optional<Horse> m1 = dialog.showAndWait();
		
		if(m1.isPresent()) {
			
			if(dealer.getHorses().size() == 6) {
				beginMethodTime();
				dealer.getGamblers().clearNodes();
				searchBet.setDisable(false);
				addBet.setDisable(false);
				
				System.out.println("Entre aqui hptass");  
				
			}else if(dealer.getHorses().size() >= 10) {
				showAlert(5); 
			}
			
			if(dealer.getHorsesNames().size() < 10) {
				dealer.getHorsesNames().add(m1.get().getHorseName());
				dealer.addHorseQueue(m1.get());
			}
			
			Label m = new Label("ROW - HORSE NAME");
			scoreInicial.getChildren().add(m);
				
			int row =1;
			for(int j = 0; j < dealer.getHorsesNames().size();j++) {
				Label aux = new Label(row+" - "+dealer.getHorsesNames().get(j));
				scoreInicial.getChildren().add(aux);
				++row;
			}
				 
			 
				
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
		case 4:
			gameOver.setHeaderText("Information missing");
			break;
		case 5:
			gameOver.setHeaderText("There can only be 10 horses per race!");
			break;
		case 6:
			gameOver.setHeaderText("Please check the bet,some of the texts are empty...");
			break;
		case 7:
			gameOver.setHeaderText("Please check the horse picked, because we cannot find it");
			break;

		default:
			break;
		}
		
		gameOver.showAndWait();
	}

	
	public void rematch(ActionEvent e) {
		
		dealer.getGamblers().clearNodes();
		scoreInicial.getChildren().clear();
		scoreFinal.getChildren().clear();
		addBet.setDisable(false);
		searchBet.setDisable(false);
		Label m = new Label("ROW - HORSE NAME");
		scoreInicial.getChildren().add(m);
		
		int row = 1;
		for(int j = 0; j < dealer.getHorsesNamesRematch().size();j++) {	
			Label aux = new Label(row+" - "+ dealer.getHorsesNamesRematch().get(j));
			scoreInicial.getChildren().add(aux);
			++row;
		}
		beginMethodRematch();
		dealer.getHorsesNamesRematch().clear();
		
	}
	
	public void addBet(ActionEvent e) {
		
		Dialog<User> dialog = new Dialog<>();
		dialog.setTitle("");
		dialog.setHeaderText("Please type the bet:");
		dialog.setResizable(false);
		 
		Label label1 = new Label("ID: ");

		TextField text1 = new TextField();
		
		Label label2 = new Label("Your Name:  ");
		
		TextField text2 = new TextField();
		
		Label label3 = new Label("Horse name:  ");
		
		TextField text3 = new TextField();
		
		Label label4 = new Label("Please type your bet:  ");
		
		TextField text4 = new TextField();
		
		Label label5 = new Label("Please type the row:");
		
		TextField text5 = new TextField();
		         
		GridPane grid = new GridPane();
		grid.add(label1, 1, 1);
		grid.add(text1, 2, 1);
		grid.add(label2, 1, 2);
		grid.add(text2,2,2);
		grid.add(label3,1,3);
		grid.add(text3,2,3);
		grid.add(label5,1,4);
		grid.add(text5, 2, 4);
		grid.add(label4,1,5);
		grid.add(text4,2,5);
		

		dialog.getDialogPane().setContent(grid);
		
		ButtonType buttonTypeOk = new ButtonType("Add", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		
		dialog.setResultConverter(new Callback<ButtonType, User>() {
		    @Override
		    public User call(ButtonType b) {
		 
		        if (b == buttonTypeOk) {
		        	
		        	try {
		        		
		        		int mustBeNumber = Integer.parseInt(text1.getText());
			        	double mustBeDouble = Double.parseDouble(text4.getText());
			        	int rowPosition = Integer.parseInt(text5.getText());
			        	
			        	if(!text1.getText().isEmpty() && !text2.getText().isEmpty() && !text3.getText().isEmpty() && !text4.getText().isEmpty() && !text5.getText().isEmpty()) {
				        	
			        		dataStructures.Node<Horse> horse4Bet = dealer.findHorseWithRow(text3.getText() ,rowPosition); //dependency
			        		
			        		Horse theHorse = null;
			        		if (horse4Bet != null) {
								theHorse =  new Horse(horse4Bet.getInfo().getHorsemanName(),horse4Bet.getInfo().getHorseName());
							}else {
				        		showAlert(6);
				        	}
			        		
				        	User gambler = new User(mustBeNumber, text2.getText(), mustBeDouble, theHorse);
				            
				        	return gambler;

			        	} 
					}catch(Exception e3) {
						showAlert(1);
					}
		        	
		        }
		 
		        return null;
		    }
		});
		
		setCss(dialog);
		Optional<User> gambler = dialog.showAndWait();
		try {
		User finalGambler = gambler.get();
		
		if (finalGambler.getMyWinnerHorse() != null) {
			dealer.addGambler(finalGambler);
		} else {
			showAlert(7);
		}
		
		}catch(Exception e4) {
			showAlert(1);
		}
	
		
	}
	
	public void ramdomTest(ActionEvent e) {
			
		    dealer.getGamblers().clearNodes();
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
	
	private void beginMethodRematch(){
		
		ThreadTimeRematch t = new ThreadTimeRematch(this);		
		t.start();	
		
	}

	public void updateTime(String msj) {
		
		time.setText(msj);
		
	}
	
	public void finishRace() {
		dealer.setWinners(false);

		Label m = new Label("PODIUM");
		scoreFinal.getChildren().add(m);	
		
		Horse[] horsesSorted = dealer.sortByPosition(false);
		
		int pos = 1;
		
		for(int j = 1; j < horsesSorted.length;j++) {
			Label aux = new Label(pos+". "+horsesSorted[j].getHorseName());
			scoreFinal.getChildren().add(aux);
			++pos;
		}
		
		dealer.fillStack4Rematch();
		dealer.getHorses().clearQueue();
		dealer.getHorsesNames().clear();
		dealer.setNumberOfHorses(0);
		ramdom.setDisable(false);
		rematch.setDisable(false);
		addBet.setDisable(true);
	}
	
	public void finishRaceRematch() {
		
		dealer.setWinners(true);

		Label m = new Label("PODIUM");
		scoreFinal.getChildren().add(m);

		Horse[] horsesSorted = dealer.sortByPosition(true);
		
		int pos = 1;
		
		for(int j = 1; j < horsesSorted.length;j++) {
			Label aux = new Label(pos+". "+horsesSorted[j].getHorseName());
			scoreFinal.getChildren().add(aux);
			++pos;
		}
		
		dealer.getHorsesRematch().clearStack();
		dealer.getHorsesNamesRematch().clear();
		dealer.setNumberOfHorses(0);
		ramdom.setDisable(false);
		rematch.setDisable(true);
		addBet.setDisable(true);
	}

} //end of class
