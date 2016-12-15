package com.fritzsalar.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.fritzsalar.ServicesBL;
import com.fritzsalar.parser.models.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ServiceController implements Initializable {

    @FXML
    private ListView<Service> listViewServices;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

		ServicesBL servicesBL = new ServicesBL();
		List<Service> myList = servicesBL.getList();
        ObservableList<Service> items = FXCollections.observableArrayList(myList);
        
        listViewServices.setItems(items);
        listViewServices.setCellFactory(listViewCeil -> new ServiceListViewCell());
    }
	
	@FXML
    public void btnRefresh_Clicked(ActionEvent e) {
        System.out.println("From Controller: btnRefresh_Clicked");
    }
}