package com.fritzsalar;
	
import com.fritzsalar.parser.XmlParser;
import com.fritzsalar.process.UnixProcess;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UnixProcess process = new UnixProcess();
//		process.list();
//		process.get("omni");
		process.execute("", "");
		
		XmlParser parser = new XmlParser();
		parser.unmarshal();
		
		launch(args);
	}
}
