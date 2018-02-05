package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import model.Song;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import model.Song;

public class Controller {
	@FXML Button addButton;
	@FXML Button editButton;
	@FXML Button deleteButton;
	@FXML TextField songName;
	@FXML TextField artist;
	@FXML TextField album;
	@FXML TextField year;
	@FXML Label detail;
	@FXML public ListView<String> list;
	boolean answer;
	
	public void start(Stage primaryStage) throws Exception
	{
		list = new ListView<>();
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
			{
				System.out.println("Old Value: " + oldValue + "\nNew Value: " + newValue);
			}
			
		});
	}
	public void add()
	{
		if(songName.getText().trim().isEmpty() || artist.getText().trim().isEmpty())
		{
			alertBox("Missing Inputs", "Please enter the song name and artist.");
			return;
		}
		Song song = new Song(songName.getText(), artist.getText(), album.getText(), year.getText());
		if(list.getItems().contains(song.listString())) //FIX THIS FOR CASE SENSITIVITY
		{
			alertBox("Duplicate", "This song name and artist is already in your list.");
			return;
		}
		songName.setText("");
		artist.setText("");
		album.setText("");
		year.setText("");
		list.getItems().add(song.listString());
		FXCollections.sort(list.getItems());
		int index = list.getItems().indexOf(song.listString());
		list.getSelectionModel().select(index);
		System.out.println(list.getItems());
		return;
	}
	public void alertBox(String title, String message)
	{
		Stage alertBox = new Stage();
		alertBox.setTitle(title);
		alertBox.initModality(Modality.APPLICATION_MODAL);
		
		Label msg = new Label(message);
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		
		Button ok = new Button("OK");
		ok.setMinWidth(50);
		ok.setMinHeight(20);
		ok.setOnAction(e -> alertBox.close());
		
		layout.getChildren().addAll(msg, ok);
		Scene scene = new Scene(layout, 300, 100);
		alertBox.setScene(scene);
		alertBox.showAndWait();
	}
	public boolean confirmBox(String title, String message)
	{
		Stage confirmBox = new Stage();
		confirmBox.setTitle(title);
		confirmBox.initModality(Modality.APPLICATION_MODAL); 
		
		Label msg = new Label(message);
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		
		Button yes = new Button("Yes");
		Button no = new Button("No");
		bottom.getChildren().addAll(yes, no);
		layout.getChildren().addAll(msg, bottom);
		
		yes.setMinWidth(50);
		yes.setMinHeight(20);
		no.setMinWidth(50);
		no.setMinHeight(20);
		yes.setOnAction(e -> 
		{
			answer = true;
			confirmBox.close();
		});
		
		no.setOnAction(e ->
		{
			answer = false;
			confirmBox.close();
		});
		
		Scene scene = new Scene(layout, 300, 250);
		confirmBox.setScene(scene);
		confirmBox.showAndWait();
		return answer;
	}
}


