package edu.westga.cs3211.time_management.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs3211.time_management.Main;
import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/** Codebehind for the MainWindow Scene.
 * 
 * @author Jonathan Corley
 */
public class MainWindow {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private ListView<Event> eventList;
    @FXML private TextArea eventDetailsText;
    private Event selectedEvent;
    
    private Calendar calendar;
    
    
    @FXML
    void addEvent(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource("view/AddEvent.fxml"));
    	loader.load();
    	Parent parent = loader.getRoot();
    	Scene scene = new Scene(parent);
    	Stage addEventStage = new Stage();
    	addEventStage.setTitle("Add New Event");
    	addEventStage.setScene(scene);
    	addEventStage.initModality(Modality.APPLICATION_MODAL);
    	AddEvent addEventDialog = loader.getController();
    	addEventDialog.setCalendar(this.calendar);
    	addEventStage.showAndWait();

        this.eventList.setItems(FXCollections.observableArrayList(this.calendar.getEvents()));
    }
    
    private void displayErrorMessage(String errorMessage) {
		Alert alert = new Alert(AlertType.ERROR, errorMessage);
		alert.showAndWait();
    }
    @FXML
    void removeEvent(ActionEvent event) {
    	if (this.selectedEvent != null) {
    		String removeEvent = "Please confirm to delete: " + this.selectedEvent.toStringFull();
    		Alert alert = new Alert(AlertType.CONFIRMATION, removeEvent);
    		alert.setTitle("Remove Event?");
    		
    		Optional<ButtonType> result = alert.showAndWait();
    		
    		if (result.isPresent() && result.get() == ButtonType.OK) {
    			this.calendar.removeEvent(this.selectedEvent);
        		this.eventList.setItems(FXCollections.observableArrayList(this.calendar.getEvents()));
        		this.eventDetailsText.setText("");
        		this.selectedEvent = null;
    			
    		}
    		
    	} else {
    		this.displayErrorMessage("Please choose a method to delete");
    	}
    }
    @FXML
    void updateEvent(ActionEvent event) throws IOException {
    	if (this.selectedEvent == null) {
    		this.displayErrorMessage("Please choose an event  to update");
    		return;
    	}
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource("view/UpdateEvent.fxml"));
    	loader.load();
    	Parent parent = loader.getRoot();
    	Scene scene = new Scene(parent);
    	Stage updateEventStage = new Stage();
    	updateEventStage.setTitle("Update Event");
    	updateEventStage.setScene(scene);
    	updateEventStage.initModality(Modality.APPLICATION_MODAL);
    	UpdateEvent updateDialog = loader.getController();
    	updateDialog.setCalendar(this.calendar);
    	updateDialog.setActiveEvent(this.selectedEvent);
    	updateEventStage.showAndWait();
        this.eventList.setItems(FXCollections.observableArrayList(this.calendar.getEvents()));
        this.eventDetailsText.setText("");
    }
    
    @FXML
    void selectEvent(MouseEvent event) {
    	Event eventSelected = this.eventList.getSelectionModel().getSelectedItem();
    	if (eventSelected != null) {
    		this.eventDetailsText.setText(eventSelected.toStringFull());
    		this.selectedEvent = eventSelected;
    	}
    }

    @FXML
    void initialize() {
        assert this.eventList != null : "fx:id=\"eventList\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.eventDetailsText != null : "fx:id=\"eventDetailsText\" was not injected: check your FXML file 'MainWindow.fxml'.";
        this.eventDetailsText.setEditable(false);
        this.calendar = new Calendar();
        this.eventList.setItems(FXCollections.observableArrayList(this.calendar.getEvents()));
    }
}

