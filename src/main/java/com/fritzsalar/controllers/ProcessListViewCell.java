package com.fritzsalar.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fritzsalar.parser.models.Service;
import com.fritzsalar.ServicesBL;
import com.fritzsalar.constants.ProcessStatus;
import com.fritzsalar.parser.models.Process;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class ProcessListViewCell extends ListCell<Process> {
	private Service _service;
	private Process _process;

	@FXML
	private Label lblProcessName;
	
	@FXML
	private Label lblStatus;
	
	@FXML
	private Label lblAction;

	@FXML
	private GridPane gridPaneProcess;

	private FXMLLoader mLLoader;

	
	public ProcessListViewCell(Service service) {
		this._service = service;
	}

	@Override
	protected void updateItem(Process process, boolean empty) {
		super.updateItem(process, empty);

		if (empty || process == null) {

			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("../ProcessCell.fxml"));
				mLLoader.setController(this);

				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			lblProcessName.setText(process.getName());
			lblStatus.setText(this.getStatus(process));
			_process = process;
			
			setText(null);
			setGraphic(gridPaneProcess);
		}
	}
	
	@FXML
	public void btnStart_Clicked() {
		System.out.println("btnStart clicked");
		ServicesBL serviceBL = new ServicesBL();
		serviceBL.start(_process);

		lblStatus.setText(this.getStatus(_process));
	}
	
	@FXML
	public void btnStop_Clicked() {
		System.out.println("btnStop clicked");
		ServicesBL serviceBL = new ServicesBL();
		serviceBL.stop(_process);
		
		lblStatus.setText(this.getStatus(_process));
	}
	
	@FXML
	public void btnRestart_Clicked() {
		System.out.println("btnRestart clicked");
	}
	
	
	
	private String getStatus(Process process) {
		ServicesBL serviceBL = new ServicesBL();
		ProcessStatus status = serviceBL.getProcessStatus(_service.getName(), process.getName());
		
		return status.toString().toLowerCase();
	}
}