package com.fritzsalar;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fritzsalar.constants.ProcessStatus;
import com.fritzsalar.parser.models.Services;
import com.fritzsalar.processes.UnixProcess;
import com.fritzsalar.utilities.parsers.XmlParser;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class Main extends Application {
	@FXML
	private Button btnRefresh;
	@FXML
	private ListView<String> listViewServices;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Process Manager");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		launch(args);
	}

	@FXML
	public void btnRefresh_Clicked(ActionEvent e) {
		System.out.println("btnRefresh_Clicked");

		ServicesBL servicesBL = new ServicesBL();
		List<String> myList = servicesBL.getListByNames();
		ObservableList<String> items = FXCollections.observableArrayList(myList);

		listViewServices.setItems(items);
	}
}
