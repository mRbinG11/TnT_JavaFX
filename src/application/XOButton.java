package application;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class XOButton extends Button {
	Image Ximg=new Image(getClass().getResourceAsStream("/img/x.png"),46,46,true,true);
	ImageView Xiv=new ImageView(Ximg);
		
	Image Oimg=new Image(getClass().getResourceAsStream("/img/o.png"),46,46,true,true);
	ImageView Oiv=new ImageView(Oimg);
	
	static byte status=1;
	boolean buttonClicked=false;
	
	public XOButton() {
		super();
		this.setPadding(new Insets(0,0,0,0));
		this.setAlignment(Pos.CENTER);
		this.setMinSize(50, 50);
		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(!buttonClicked)	buttonClicked=true;
				else	buttonClicked=false;
				if(buttonClicked) {
					switch(status) {
					case 1: setGraphic(Xiv); 
							break;
					case 0: setGraphic(Oiv); 
							break;
					}
				}
				else setGraphic(null);
				System.out.println(status);
			}
		});
	}
	public void reset() {
		status=1;
		buttonClicked=false;
		setGraphic(null);
	}
}
