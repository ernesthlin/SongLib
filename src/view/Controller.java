package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import model.Song;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller 
{
	@FXML Button addButton;
	@FXML Button editButton;
	@FXML Button deleteButton;
	@FXML TextField songName;
	@FXML TextField artist;
	@FXML TextField album;
	@FXML TextField year;
	boolean answer;
	
	public boolean confirmBox(String title, String message)
	{
		Stage confirmBox = new Stage();
		confirmBox.setTitle(title);
		confirmBox.initModality(Modality.APPLICATION_MODAL);
		
		Label msg = new Label(message);
		VBox layout = new VBox(10);
		HBox bottom = new HBox();
		Button yes = new Button("Yes");
		Button no = new Button("No");
		bottom.getChildren().addAll(yes, no);
		layout.getChildren().addAll(msg, bottom);
		
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


