package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrincipalController implements Initializable{

	@FXML
	private Label principal;
	@FXML
	private ImageView gift;
	@FXML
	private ImageView hipodrome;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image i = new Image("/controller/horseRun.gif",1200,300,false,false);
		Image o = new Image("/controller/horseHipodromo.jpg",1080,720,false,false);
		gift.setImage(i);
		hipodrome.setImage(o);
	}

}
