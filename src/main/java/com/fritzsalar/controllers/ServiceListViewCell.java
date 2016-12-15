package com.fritzsalar.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fritzsalar.parser.models.Service;
import com.fritzsalar.parser.models.Process;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class ServiceListViewCell extends ListCell<Service> {

	@FXML
	private Label lblServiceName;
	
	@FXML
	private ListView<Process> listViewProcesses;

	@FXML
	private GridPane gridPane;

	private FXMLLoader mLLoader;

	@Override
	protected void updateItem(Service service, boolean empty) {
		super.updateItem(service, empty);

		if (empty || service == null) {

			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("../ServiceCell.fxml"));
				mLLoader.setController(this);

				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			lblServiceName.setText(service.getName());
			
			List<Process> myList = service.getProcesses().getProcessList();
	        ObservableList<Process> items = FXCollections.observableArrayList(myList);
	        
	        listViewProcesses.setItems(items);
	        listViewProcesses.setCellFactory(listViewCeil -> new ProcessListViewCell(service));

			setText(null);
			setGraphic(gridPane);
		}

	}
}