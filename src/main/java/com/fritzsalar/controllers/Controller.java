package com.fritzsalar.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.fritzsalar.ServicesBL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class Controller implements Initializable {

    @FXML
    private ListView<Student> listViewServices;

    private ObservableList<Student> studentObservableList;

    public Controller()  {

        studentObservableList = FXCollections.observableArrayList();

        //add some Students
        studentObservableList.addAll(
                new Student("John Doe", Student.GENDER.MALE),
                new Student("Jane Doe", Student.GENDER.FEMALE),
                new Student("Donte Dunigan", Student.GENDER.MALE),
                new Student("Gavin Genna", Student.GENDER.MALE),
                new Student("Darin Dear", Student.GENDER.MALE),
                new Student("Pura Petty", Student.GENDER.FEMALE),
                new Student("Herma Hines", Student.GENDER.FEMALE)
        );


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//		ServicesBL servicesBL = new ServicesBL();
//		List<String> myList = servicesBL.getListByNames();
//        ObservableList<String> items = FXCollections.observableArrayList(myList);
//        
//        listViewServices.setItems(items);

        listViewServices.setItems(studentObservableList);
        listViewServices.setCellFactory(studentListView -> new StudentListViewCell());
    }
	
	@FXML
    public void btnRefresh_Clicked(ActionEvent e) {
        System.out.println("From Controller: btnRefresh_Clicked");
    }
}