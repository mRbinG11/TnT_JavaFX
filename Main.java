package application;
	
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/*import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URL;*/

public class Main extends Application {
	static Text turnlbl=new Text("X's Turn");
	static FlowPane fp=new FlowPane();
	static Scene scene=new Scene(fp);
	static Button end = new Button();
	static GridPane mgp=new GridPane();
	static XOButton btns[]=new XOButton[81];
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("T 'n' T");
		primaryStage.setResizable(false);
		Image icon=new Image(getClass().getResourceAsStream("/img/tic-tac-toe.png"));
		primaryStage.getIcons().add(icon);
		
	/*	final URL resource = getClass().getResource("/application/Mahalo x DLMT - So Cold (feat. Lily Denning).mp3");
	    final Media media = new Media(resource.toString());
	    final MediaPlayer mediaPlayer = new MediaPlayer(media);
	    mediaPlayer.play();*/
	    
		fp.setMaxSize(500, 600);
		fp.setPadding(new Insets(0,0,0,0));
		
		MenuBar mb=new MenuBar();
		Menu fmenu=new Menu("File");
		MenuItem ngame=new MenuItem("New Game");
		MenuItem lgame=new MenuItem("Load Game");
		MenuItem sgame=new MenuItem("Save Game");
		MenuItem exit=new MenuItem("Exit");
		
		fmenu.getItems().addAll(ngame,lgame,sgame,new SeparatorMenuItem(),exit);
		mb.setMinWidth(560);
		mb.getMenus().addAll(fmenu);
		
		
		//mgp.setMaxSize(550, 600);
		mgp.setPrefSize(540, 560);
		mgp.setPadding(new Insets(10,10,10,10));
        mgp.setVgap(10);
        mgp.setHgap(10);
        mgp.setAlignment(Pos.CENTER);
		
		GridPane gp1=new GridPane();
		gp1.setMinSize(170, 170);
        gp1.setVgap(5);
        gp1.setHgap(5);
        gp1.setAlignment(Pos.CENTER);
        
        GridPane gp2=new GridPane();
		gp2.setMinSize(170, 170);
        gp2.setVgap(5);
        gp2.setHgap(5);
        gp2.setAlignment(Pos.CENTER);
        
        GridPane gp3=new GridPane();
		gp3.setMinSize(170, 170);
        gp3.setVgap(5);
        gp3.setHgap(5);
        gp3.setAlignment(Pos.CENTER);
        
        GridPane gp4=new GridPane();
		gp4.setMinSize(170, 170);
        gp4.setVgap(5);
        gp4.setHgap(5);
        gp4.setAlignment(Pos.CENTER);
        
        GridPane gp5=new GridPane();
		gp5.setMinSize(170, 170);
        gp5.setVgap(5);
        gp5.setHgap(5);
        gp5.setAlignment(Pos.CENTER);
        
        GridPane gp6=new GridPane();
		gp6.setMinSize(170, 170);
        gp6.setVgap(5);
        gp6.setHgap(5);
        gp6.setAlignment(Pos.CENTER);
        
        GridPane gp7=new GridPane();
		gp7.setMinSize(170, 170);
        gp7.setVgap(5);
        gp7.setHgap(5);
        gp7.setAlignment(Pos.CENTER);
        
        GridPane gp8=new GridPane();
		gp8.setMinSize(170, 170);
        gp8.setVgap(5);
        gp8.setHgap(5);
        gp8.setAlignment(Pos.CENTER);
        
        GridPane gp9=new GridPane();
		gp9.setMinSize(170, 170);
        gp9.setVgap(5);
        gp9.setHgap(5);
        gp9.setAlignment(Pos.CENTER);
		
		
		int t=0;
		
		for(;t<81;)
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++) {
					if(t<9) {
						btns[t]=new XOButton();
						gp1.add(btns[t++], j, i);
					}else if(t>8&&t<18) {
						btns[t]=new XOButton();
						gp2.add(btns[t++], j, i);
					}else if(t>17&&t<27) {
						btns[t]=new XOButton();
						gp3.add(btns[t++], j, i);
					}else if(t>26&&t<36) {
						btns[t]=new XOButton();
						gp4.add(btns[t++], j, i);
					}else if(t>35&&t<45) {
						btns[t]=new XOButton();
						gp5.add(btns[t++], j, i);
					}else if(t>44&&t<54) {
						btns[t]=new XOButton();
						gp6.add(btns[t++], j, i);
					}else if(t>53&&t<63) {
						btns[t]=new XOButton();
						gp7.add(btns[t++], j, i);
					}else if(t>62&&t<72) {
						btns[t]=new XOButton();
						gp8.add(btns[t++], j, i);
					}else if(t>71&&t<81) {
						btns[t]=new XOButton();
						gp9.add(btns[t++], j, i);
					}
			}
		
		
		end.setText("End Turn");
	    end.setDefaultButton(true);
	    end.setDisable(true);
	    
		ngame.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				for(int i=0;i<81;i++)
					btns[i].reset();
				XOButton.status=1;
				XOButton.game=false;
				XOButton.lastPlayed=XOButton.lastTurnPlayed=-1;
				mgp.requestFocus();
				end.setDisable(true);
			}	
		});
		
		sgame.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				FileOutputStream fos = null;
			    File file;
			      
			      try {
			          //Specify the file path here
				  file = new File("save.txt");
				  fos = new FileOutputStream(file);
				  if (!file.exists()) {
				     file.createNewFile();
				  }
				  
				  for(int t=0;t<81;t++) {
					  if(t!=XOButton.lastPlayed) {
						  	fos.write(btns[t].symbol);
						  	fos.flush();
					  }
					  else {
						  fos.write(' ');
						  fos.flush();
					  }
					 
				  }
				  fos.write((char)XOButton.lastTurnPlayed);
				  fos.flush();
				  fos.write((char)XOButton.status);
				  fos.flush();
			       } 
			       catch (IOException ioe) {
				  ioe.printStackTrace();
			       }
			}
		});
		
		lgame.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				try {
					for(int i=0;i<81;i++)
						btns[i].reset();
				      FileInputStream fis = new FileInputStream("save.txt");
				      char current;
				      while (fis.available() > 0) {
				    	  for(int t=0;t<81;t++) {
				    		  current = (char) fis.read();
				    		  if(current=='x') {
				    			  btns[t].setGraphic(btns[t].Xiv);
				    			  btns[t].fixed=true;
				    			  btns[t].symbol='x';
				    		  }
				    		  else if(current=='o') {
				    			  btns[t].setGraphic(btns[t].Oiv);
				    			  btns[t].fixed=true;
				    			  btns[t].symbol='o';
				    		  }
				    		  else btns[t].setGraphic(null);
				    		
				        
				    	  }
				    	  XOButton.lastTurnPlayed=(int)fis.read();
				    	  XOButton.status=(byte)fis.read();
				    	  
				    	 // fis.close();
							
				       }
				      for(int k=(XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9;k<((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9)+9;k++)
							btns[k].setStyle("-fx-background-color: green;");
						
						for(int k=0;k<81;k++)
							if((k<(XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9||k>=((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9)+9))
								btns[k].disable=true;
							else 
								btns[k].disable=false;
						btns[XOButton.lastTurnPlayed].requestFocus();
				    } catch (IOException e) {
				      e.printStackTrace();
				    }
				
			}
		});
		
		mgp.add(gp1, 0, 0);
		mgp.add(gp2, 1, 0);
		mgp.add(gp3, 2, 0);
		mgp.add(gp4, 0, 1);
		mgp.add(gp5, 1, 1);
		mgp.add(gp6, 2, 1);
		mgp.add(gp7, 0, 2);
		mgp.add(gp8, 1, 2);
		mgp.add(gp9, 2, 2);
		
		Separator sp=new Separator();
		sp.setMinWidth(560);
		
		
		Text timer=new Text();
		
		fp.getChildren().addAll(mb,mgp,sp,turnlbl,timer,end);
		
		for(int i=0;i<81;i++) {
			final int temp=new Integer(i);
			btns[i].setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					
					
					if(!btns[temp].disable&&!btns[temp].fixed) {
						
						end.setDisable(false);
						
						if(XOButton.lastPlayed!=-1) {
							for(int k=(XOButton.lastPlayed-(XOButton.lastPlayed/9)*9)*9;k<(XOButton.lastPlayed-(XOButton.lastPlayed/9)*9)*9+9;k++)
								btns[k].setStyle(null);
								btns[XOButton.lastPlayed].symbol=' ';
								btns[XOButton.lastPlayed].setGraphic(null);
						}
						
						if(XOButton.lastTurnPlayed!=-1)
							for(int k=(XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9;k<((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9)+9;k++)
								btns[k].setStyle("-fx-background-color: green;");
						
							
							
						for(int k=(temp-(temp/9)*9)*9;k<((temp-(temp/9)*9)*9)+9;k++)
							btns[k].setStyle("-fx-background-color: red;");
						
						
						
						switch(XOButton.status) {
						case 1: btns[temp].setGraphic(btns[temp].Xiv); 
								btns[temp].symbol='x';
								break;
						case 0: btns[temp].setGraphic(btns[temp].Oiv);
								btns[temp].symbol='o';
								break;
						}
						XOButton.lastPlayed=temp;
						
								
							
							
					}
					
					
				}
			});
		}
		end.setAlignment(Pos.CENTER_RIGHT);
		end.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				XOButton.status++;
				XOButton.status%=2;
				switch(XOButton.status) {
				case 1: turnlbl.setText("X's Turn");
						break;
				case 0: turnlbl.setText("O's Turn");
						break;
				}
				XOButton.lastTurnPlayed=XOButton.lastPlayed;
				btns[XOButton.lastTurnPlayed].fixed=true;
				
				for(int k=(XOButton.lastTurnPlayed/9)*9;k<((XOButton.lastTurnPlayed/9)*9)+9;k++)
					btns[k].setStyle(null);
				for(int k=(XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9;k<((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9)+9;k++)
					btns[k].setStyle("-fx-background-color: green;");
				
				for(int k=0;k<81;k++)
					if((k<(XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9||k>=((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9)+9))
						btns[k].disable=true;
					else 
						btns[k].disable=false;
					
				
				end.setDisable(true);
				XOButton.game=true;
				XOButton.lastPlayed=-1;
				btns[XOButton.lastTurnPlayed].requestFocus();
			}
		});
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		mgp.requestFocus();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
