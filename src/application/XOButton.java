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
	
	byte status=0;
	
	public XOButton() {
		super();
		this.setPadding(new Insets(0,0,0,0));
		this.setAlignment(Pos.CENTER);
		this.setMinSize(50, 50);
		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				status++;
				status%=3;
				switch(status) {
				case 0: setGraphic(null); 
						break;
				case 1: setGraphic(Xiv); 
						break;
				case 2: setGraphic(Oiv); 
						break;
				}
				System.out.println(status);
			}
		});
	}
}
